package com.geometry.vegapp.d_projectCore.ag_renewal.a_recycler_view_renewal_options;

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

import com.geometry.vegapp.R;
import com.geometry.vegapp.b_homepage.homepage_activity;
import com.geometry.vegapp.c_utility_functions.helperFunctions_class;
import com.geometry.vegapp.c_utility_functions.recyclerTouchListener_class;
import com.geometry.vegapp.d_projectCore.ae_plant.b_recycler_view_plant_display.a_recycler_view_plant_view_display_activity;
import com.geometry.vegapp.d_projectCore.ag_renewal.c_recycler_view_renewal_entry.renewalformEntryForm;
import com.geometry.vegapp.h_login.login_activity;

import java.util.ArrayList;

public class a_recycler_view_renewal_options_display_activity extends AppCompatActivity
{


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<d_recycler_view_renewal_options_datamodel_class> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa_ai_5_optionselector_rnwwindow);


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
                // Toast.makeText(getApplicationContext(),   " is selected!", Toast.LENGTH_SHORT).show();
                //   Intent intent = new Intent(OptionSelector_MainWindow.this, a_recycler_view_plant_view_display_activity.class);
                //  startActivity(intent);
                //Intent intent = new Intent(OptionSelector_MainWindow.this, a_recycler_view_plant_view_display_activity.class);
                //    startActivity(intent);
                // finish();


                d_recycler_view_renewal_options_datamodel_class dataE = data.get(position);

                if(homepage_activity.TESTING_MODE)
                    helperFunctions_class.showToast(a_recycler_view_renewal_options_display_activity.this, dataE.getOptionName());

                //   helperFunctions_class.showToast(a_recycler_view_train_options_display_activity.this, dataE.getOptionName()+":"+homepage_activity.user_mode);

                switch(dataE.getOptionName())
                {
                    case "Post Renewal Details":




                        // new String(homepage_activity.user_mode).equals("test")
                        if(new String(homepage_activity.user_mode).equals("user"))
                        {
                            helperFunctions_class.showToast(a_recycler_view_renewal_options_display_activity.this, "Sorry only vendors are allowed to post");
                        }
                        else
                        {

                            Intent intent = new Intent(a_recycler_view_renewal_options_display_activity.this, renewalformEntryForm.class);
                            startActivity(intent);



                            helperFunctions_class.showToast(a_recycler_view_renewal_options_display_activity.this, "post Plant");



                        }
                        break;

                    case "View Renewal List":
                          helperFunctions_class.showToast(a_recycler_view_renewal_options_display_activity.this, "Clciked View Veg");

                    Intent  intent = new Intent(a_recycler_view_renewal_options_display_activity.this,  a_recycler_view_plant_view_display_activity.class);
                        startActivity(intent);
                        break;


                    //Toast.makeText(getApplicationContext(), dataE.getOptionName() + " is selected!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        data = new ArrayList<d_recycler_view_renewal_options_datamodel_class>();

        for (int i = 0; i < c_recycler_view_renewal_options_data_storage_class.nameArray.length; i++)
        {
            data.add(new d_recycler_view_renewal_options_datamodel_class( c_recycler_view_renewal_options_data_storage_class.nameArray[i][0], c_recycler_view_renewal_options_data_storage_class.nameArray[i][1]));
        }



        adapter = new b_recycler_view_renewal_options_adapter_class(data,getApplicationContext());
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
        switch (item.getItemId()) {
            case R.id.logout:

                if(homepage_activity.TESTING_MODE)
                {
                    helperFunctions_class.showToast(a_recycler_view_renewal_options_display_activity.this, "Inside Login Function");
                }
                helperFunctions_class.logOut_reset_flags(a_recycler_view_renewal_options_display_activity.this);
                Intent intent = new Intent(a_recycler_view_renewal_options_display_activity.this, login_activity.class);
                startActivity(intent);
                finish();


                return true;

        }

        return super.onOptionsItemSelected(item);
    }

}


