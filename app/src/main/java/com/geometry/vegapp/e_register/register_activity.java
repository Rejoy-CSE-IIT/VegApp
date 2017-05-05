package com.geometry.vegapp.e_register;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.geometry.vegapp.R;
import com.geometry.vegapp.b_homepage.homepage_activity;
import com.geometry.vegapp.h_login.login_activity;
import com.geometry.vegapp.f_webPageLinks.webPageLinks_class;
import com.geometry.vegapp.g_volley_manager.volley_connection_class;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class register_activity extends AppCompatActivity implements OnItemSelectedListener
{
    EditText Name,Email,Pass,ConPass,mobno,place;
    Button reg_button;
    TextView register_label;
    AlertDialog.Builder builder;
    Spinner spinner_user_mode;
    String  user_mode=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa_ae_register);


        Name           = (EditText)findViewById(R.id.name_reg_id);
        Email          = (EditText)findViewById(R.id.email_reg_id);
        Pass           = (EditText)findViewById(R.id.pass_reg_id);
        mobno          = (EditText)findViewById(R.id.mobno);
        ConPass        = (EditText)findViewById(R.id.con_pass_reg_id);
        place          = (EditText)findViewById(R.id.place_ET);
        reg_button     = (Button) findViewById (R.id.register_button);
        register_label = (TextView) findViewById(R.id.registration_label);
        spinner_user_mode = (Spinner) findViewById(R.id.spinner_opt);


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("user");
        categories.add("vendor");



        // Spinner click listener
        spinner_user_mode.setOnItemSelectedListener(this);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_user_mode.setAdapter(dataAdapter);


        reg_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(Name.getText().toString().equals("")||mobno.getText().toString().equals("")||place.getText().toString().equals("")||
                        Email.getText().toString().equals("")||!isValidEmail(Email.getText().toString())||
                        Pass.getText().toString().equals(""))
                {
                    builder=new AlertDialog.Builder(register_activity.this);
                    builder.setTitle("Something went wrong....");
                    builder.setMessage("please fill all the fields..");

                    builder.setPositiveButton("ok",new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog,int which)
                        {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                }
                else if(!(Pass.getText().toString().equals(ConPass.getText().toString())))
                {
                    builder=new AlertDialog.Builder(register_activity.this);
                    builder.setTitle("Password not confirmed...");
                    builder.setMessage("please  reenter password..");

                    builder.setPositiveButton("ok",new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog,int which)
                        {
                            dialog.dismiss();
                            Pass.setText("");
                            ConPass.setText("");
                        }
                    });

                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();


                }

                else
                {






                    StringRequest stringRequest = new StringRequest(Request.Method.POST, webPageLinks_class.getRegister_URL(),
                            new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response)
                                {
                                    // remember response is the sring that you sent from server open php
                                    if(homepage_activity.TESTING_MODE)
                                    Toast.makeText(register_activity.this, response, Toast.LENGTH_LONG).show();

                                    Gson gson = new Gson();
                                    //*
                                    JsonElement element = gson.fromJson (response, JsonElement.class);
                                    JsonObject jsonObj = element.getAsJsonObject();


                                    String result_of_register = jsonObj.get("status").getAsString();
                                    if(result_of_register.equals("true"))
                                    {

                                        if(homepage_activity.TESTING_MODE)
                                            Toast.makeText(register_activity.this, "Registration Successful!", Toast.LENGTH_LONG).show();

                                        Intent intent = new Intent(register_activity.this, login_activity.class);
                                        intent.putExtra("fromReg", true);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        //Toast.makeText(Register.this, "Registration  Failed", Toast.LENGTH_LONG).show();
                                        register_label.setText("Registration Failed Try again !!");
                                    }
                                }
                            },
                            new Response.ErrorListener()
                            {
                                @Override
                                public void onErrorResponse(VolleyError error)
                                {
                                    if(homepage_activity.TESTING_MODE)
                                       Toast.makeText(register_activity.this,error.toString(),Toast.LENGTH_LONG).show();
                                }
                            }){
                        @Override
                        protected Map<String,String> getParams()
                        {
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("name",Name.getText().toString());
                            params.put("email",Email.getText().toString());
                            params.put("password", Pass.getText().toString());
                            params.put("mobno", mobno.getText().toString());
                            params.put("place", place.getText().toString());
                            params.put("user_mode", user_mode);
                            return params;
                        }

                    };


                    volley_connection_class.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);








                }//

            }
        });///






    }



    public boolean isValidEmail(CharSequence target)
    {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public void login_form_xml(View view)
    {
        Intent intent = new Intent(register_activity.this, login_activity.class);
        startActivity(intent);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        // On selecting a spinner item
        user_mode = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        if(homepage_activity.TESTING_MODE)
        Toast.makeText(parent.getContext(), "Selected: " + user_mode+"index "+id, Toast.LENGTH_LONG).show();




    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }




}
