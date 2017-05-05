package com.geometry.vegapp.b_homepage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.geometry.vegapp.R;
import com.geometry.vegapp.d_projectCore.aa_mainWindow.aa_ai_OptionSelector_MainWindow_activity;
import com.geometry.vegapp.h_login.login_activity;

public class homepage_activity extends AppCompatActivity
{
    public static  boolean                                 TESTING_MODE = false;
    public static String                                           user_mode = null;
    public static String                                       user_name = null;
    public static int                                               user_id = -1;
    public static boolean                                  login_status = false;
    public static Context                                            ctx = null;

    String name,email,user_mode_S;
    int id;
    TextView userinfo;

    Button logout_button_xml;
    Button                                                   startButton_xml;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa_ab_vegmain);


        userinfo   = (TextView) findViewById(R.id.userinfo);
        startButton_xml   = (Button)   findViewById(R.id.startButton_xml);


        startButton_xml.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(homepage_activity.this, aa_ai_OptionSelector_MainWindow_activity.class);
                startActivity(intent);
                finish();
            }
        });






    }
    @Override
    public void onResume()
    {
        super.onResume();
        // put your code here...

        ctx = homepage_activity.this;


        //if you are not h_login then you are not eligible for viewing the home page
        if (!homepage_activity.login_status)
        {

            Intent intent = new Intent(homepage_activity.this, login_activity.class);
            startActivity(intent);
            finish();
        }

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        user_mode_S = intent.getStringExtra("user_mode");

        id   = intent.getIntExtra("Id",0);
        homepage_activity.user_id = id;
        homepage_activity.user_mode = user_mode_S;


        if(homepage_activity.TESTING_MODE)
            Toast.makeText(homepage_activity.this,  "Id is ::"+ homepage_activity.user_id, Toast.LENGTH_LONG).show();

        String poster = null;
        poster = "Welcome "+name+ "\n in \n"+user_mode +" Mode";
        userinfo.setText(poster);



    }



    @Override
    public void onBackPressed()
    {

        //thats it
    }




}