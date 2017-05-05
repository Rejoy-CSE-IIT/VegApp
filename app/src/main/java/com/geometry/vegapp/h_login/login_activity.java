package com.geometry.vegapp.h_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.geometry.vegapp.R;
import com.geometry.vegapp.b_homepage.homepage_activity;
import com.geometry.vegapp.c_utility_functions.helperFunctions_class;
import com.geometry.vegapp.e_register.register_activity;
import com.geometry.vegapp.f_webPageLinks.webPageLinks_class;
import com.geometry.vegapp.g_volley_manager.volley_connection_class;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class login_activity extends AppCompatActivity
{


    TextView signup_text, login_label;
    EditText email, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa_ac_login);


        login_label = (TextView) findViewById(R.id.login_label);
        signup_text = (TextView) findViewById(R.id.sign_up);
        button      = (Button) findViewById(R.id.login_button);
        email       = (EditText) findViewById(R.id.email_id);
        password    = (EditText) findViewById(R.id.password);

        signup_text.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(homepage_activity.TESTING_MODE)
                    helperFunctions_class.showToast(login_activity.this,"Move to Register");
                Intent intent = new Intent(login_activity.this, register_activity.class);
                startActivity(intent);

            }
        });


        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {




                StringRequest stringRequest = new StringRequest(Request.Method.POST, webPageLinks_class.getLogin_URL(),
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                // remember response is the sring that you sent from server open php
                                if(homepage_activity.TESTING_MODE)
                                    Toast.makeText(login_activity.this, response, Toast.LENGTH_LONG).show();
                                Gson gson = new Gson();
                                //*
                                JsonElement element = gson.fromJson (response, JsonElement.class);
                                JsonObject jsonObj = element.getAsJsonObject();


                                String result_of_login = jsonObj.get("status").getAsString();
                                String user_mode = jsonObj.get("user_mode").getAsString();

                                int id =jsonObj.get("Id").getAsInt();
                                if(homepage_activity.TESTING_MODE)
                                    Toast.makeText(login_activity.this,  "Id is from h_login ::"+ id, Toast.LENGTH_LONG).show();
                                //*
                                // Toast.makeText(LoginActivity.this, result_of_login+"::"+jsObj.get("status").getAsString(), Toast.LENGTH_LONG).show();


                                // if(result_of_login.equals(jsObj.get("status").getAsString()))
                                if(result_of_login.equals("true"))
                                {
                                    Toast.makeText(login_activity.this, "Login Successful!", Toast.LENGTH_LONG).show();
                                    homepage_activity.login_status=true;
                                    Intent intent = new Intent(login_activity.this, homepage_activity.class);
                                    intent.putExtra("name",jsonObj.get("name").getAsString());
                                    intent.putExtra("email",jsonObj.get("email").getAsString());
                                    intent.putExtra("user_mode",jsonObj.get("user_mode").getAsString());
                                    intent.putExtra("Id",id);
                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {    if(homepage_activity.TESTING_MODE)
                                    Toast.makeText(login_activity.this, "Login Failed", Toast.LENGTH_LONG).show();
                                    login_label.setText("Login Failed");
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(login_activity.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }){
                    @Override
                    protected Map<String,String> getParams()
                    {
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("email",email.getText().toString());
                        params.put("password", password.getText().toString());
                        return params;
                    }

                };


                volley_connection_class.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);


            }
        });//






    }

    @Override
    public void onResume()
    {
        super.onResume();

        //This is for checking h_login in call after registration success
        Intent intent = getIntent();

        if (intent.hasExtra("fromReg"))
        {
            if (intent.getExtras().getBoolean("fromReg"))
            {
                login_label.setText("Registration Successful");
            }

        }


    }

    @Override
    public void onBackPressed()
    {

        //thats it
    }

}