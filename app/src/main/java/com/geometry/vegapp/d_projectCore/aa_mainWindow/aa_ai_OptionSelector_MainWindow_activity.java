package com.geometry.vegapp.d_projectCore.aa_mainWindow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.geometry.vegapp.R;
import com.geometry.vegapp.b_homepage.homepage_activity;
import com.geometry.vegapp.c_utility_functions.helperFunctions_class;
import com.geometry.vegapp.c_utility_functions.recyclerTouchListener_class;
import com.geometry.vegapp.d_projectCore.ab_seed.a_recycler_view_seed_options.a_recycler_view_seed_options_display_activity;
import com.geometry.vegapp.d_projectCore.ac_veg.a_recycler_view_veg_options.a_recycler_view_veg_options_display_activity;
import com.geometry.vegapp.d_projectCore.ad_fertilizer.a_recycler_view_fert_options.a_recycler_view_fert_options_display_activity;
import com.geometry.vegapp.d_projectCore.ae_plant.a_recycler_view_plant_options.a_recycler_view_plant_options_display_activity;
import com.geometry.vegapp.h_login.login_activity;

import java.util.ArrayList;

public class aa_ai_OptionSelector_MainWindow_activity extends AppCompatActivity
{


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<ad_ai_OptionDataModel_mainWindow_class> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa_ai_optionselector_mainwindow);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);


        recyclerView.addOnItemTouchListener(new recyclerTouchListener_class(getApplicationContext(), recyclerView, new recyclerTouchListener_class.ClickListener()
        {
            @Override
            public void onClick(View view, int position)
            {
                // d_recycler_view_plant_view_datamodel_class dataE = data.get(position);
                //Toast.makeText(getApplicationContext(), dataE.getOptionName() + " is selected!", Toast.LENGTH_SHORT).show();
                //  Toast.makeText(getApplicationContext(),   " is selected!", Toast.LENGTH_SHORT).show();
                //   Intent intent = new Intent(OptionSelector_MainWindow.this, a_recycler_view_plant_view_display_activity.class);
                //  startActivity(intent);
                //Intent intent = new Intent(OptionSelector_MainWindow.this, a_recycler_view_plant_view_display_activity.class);
                //    startActivity(intent);
                // finish();


                ad_ai_OptionDataModel_mainWindow_class dataE = data.get(position);
                if(homepage_activity.TESTING_MODE)
                    Toast.makeText(aa_ai_OptionSelector_MainWindow_activity.this, "outside tester", Toast.LENGTH_LONG).show();
                Intent intent;
                switch(dataE.getOptionName())
                {


                    case "Seed Section":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow_activity.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();


                        intent = new Intent(aa_ai_OptionSelector_MainWindow_activity.this, a_recycler_view_seed_options_display_activity.class);
                        startActivity(intent);
                        break;


                    case "Vegetable Product":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow_activity.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();



                        intent = new Intent(aa_ai_OptionSelector_MainWindow_activity.this, a_recycler_view_veg_options_display_activity.class);
                        startActivity(intent);
                        break;



                    case "Fertilizers":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow_activity.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();


                        intent = new Intent(aa_ai_OptionSelector_MainWindow_activity.this, a_recycler_view_fert_options_display_activity.class);
                        startActivity(intent);
                        break;

                    case "Plant Section":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow_activity.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();


                        intent = new Intent(aa_ai_OptionSelector_MainWindow_activity.this, a_recycler_view_plant_options_display_activity.class);
                        startActivity(intent);
                        break;

                    case "Training":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow_activity.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();

/*
                        intent = new Intent(aa_ai_OptionSelector_MainWindow_activity.this, aa_ai_4_OptionSelector_trnWindow.class);
                        startActivity(intent);*/
                        break;

                    case "Renewal Enegery":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow_activity.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();

/*
                        intent = new Intent(aa_ai_OptionSelector_MainWindow_activity.this, aa_ai_5_OptionSelector_rnwWindow.class);
                        startActivity(intent);*/
                        break;


                    case "user details":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow_activity.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();

/*
                        intent = new Intent(aa_ai_OptionSelector_MainWindow_activity.this, aa_ai_6_OptionSelector_usrWindow.class);
                        startActivity(intent);*/
                        break;




                    //Toast.makeText(getApplicationContext(), dataE.getOptionName() + " is selected!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        data = new ArrayList<ad_ai_OptionDataModel_mainWindow_class>();

        for (int i = 0; i < ac_ai_OptionData_mainWindow_class.nameArray.length; i++)
        {
            data.add(new ad_ai_OptionDataModel_mainWindow_class( ac_ai_OptionData_mainWindow_class.nameArray[i]));
        }



        adapter = new ab_ai_OptionAdapter_mainWindow_class(data,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logoutmenu, menu);
        return true;
    }

    // handle choice from options menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        // switch based on the MenuItem id
        switch (item.getItemId())
        {
            case R.id.logout:

                if(homepage_activity.TESTING_MODE)
                {
                    helperFunctions_class.showToast(aa_ai_OptionSelector_MainWindow_activity.this, "Inside Login Function");
                }
                helperFunctions_class.logOut_reset_flags(aa_ai_OptionSelector_MainWindow_activity.this);
                Intent intent = new Intent(aa_ai_OptionSelector_MainWindow_activity.this, login_activity.class);
                startActivity(intent);
                finish();


                return true;

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed()
    {

        //thats it
    }

}


