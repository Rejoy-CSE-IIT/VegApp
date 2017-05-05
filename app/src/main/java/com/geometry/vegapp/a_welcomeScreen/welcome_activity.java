package com.geometry.vegapp.a_welcomeScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geometry.vegapp.R;
import com.geometry.vegapp.b_homepage.homepage_activity;

public class welcome_activity extends AppCompatActivity
{
    //4000 millisecond means 4 seconds
    private static int                                             SPLASH_TIME =4000;

    public ProgressBar progressBar;
    public TextView progresstxt;
    private Handler handler = new Handler();
    int progressCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa_aa_welcome);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progresstxt = (TextView) findViewById(R.id.progress);


        progressBar.setProgress(0);
        progressBar.setMax(SPLASH_TIME);

        View decorView = getWindow().getDecorView();





 /*
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/






        /*
        new Thread(new Runnable() {
            public void run()
            {
                while(true)
                {
                    handler.post(new Runnable() {
                        public void run()
                        {
                            progresstxt.setText("Progress::"+progressBar.getProgress()+"Progress max ::"+progressBar.getMax());

                        }
                    });
                 }
/*
                Intent mainIntent=new Intent().setClass(welcome_activity.this,homepage_activity.class);
                startActivity(mainIntent);
                finish();
            }
        }).start();*/






    }
    @Override
    public void onResume()
    {
        super.onResume();
        // put your code here...
        progressCount=0;
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                // TODO Auto-generated method stub
                while (progressCount < 10)
                {
                    try
                    {
                        Thread.sleep(500);
                        progressCount += 2;
                    }
                    catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }



                }

                Intent mainIntent=new Intent().setClass(welcome_activity.this,homepage_activity.class);
              //  Intent mainIntent=new Intent().setClass(welcome_activity.this,smstest.class);
               // Intent mainIntent=new Intent().setClass(welcome_activity.this,MainActivity.class);

                startActivity(mainIntent);
                  finish();
            }
        }).start();

    }
}
