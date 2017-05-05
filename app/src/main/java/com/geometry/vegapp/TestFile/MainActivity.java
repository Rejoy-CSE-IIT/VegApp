package com.geometry.vegapp.TestFile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.geometry.vegapp.R;

public class MainActivity extends AppCompatActivity
{

    RatingBar ratingbar1;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick(){

        ratingbar1=(RatingBar)findViewById(R.id.ratingBar1);
        button=(Button)findViewById(R.id.button1);
        //Performing action on Button Click
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                //Getting the rating and displaying it on the toast
               // String rating=String.valueOf(ratingbar1.getRating());
              //  Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();


                ratingbar1.setRating(3.23f);
            }

        });
    }


}