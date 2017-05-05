package com.geometry.vegapp.j_project_core.zzDummy.zai_4_Training;

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
import com.geometry.vegapp.h_login.login_activity;
import com.geometry.vegapp.c_utility_functions.helperFunctions_class;
import com.geometry.vegapp.j_project_core.zzDummy.zai_4_Training.a_4_Traning_level_0.a1_recylerviewdetails.OptionSelector_train_view;
import com.geometry.vegapp.i_recyclerViewTouchListener_class.recyclerTouchListener_class;

import java.util.ArrayList;

public class aa_ai_4_OptionSelector_trnWindow extends AppCompatActivity
{


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<ad_ai_4_OptionDataModel_trnWindow> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa_ai_4_optionselector_trnwindow);


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
                // d_recycler_view_fert_view_datamodel_class dataE = data.get(position);
                //Toast.makeText(getApplicationContext(), dataE.getOptionName() + " is selected!", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),   " is selected!", Toast.LENGTH_SHORT).show();
                //   Intent intent = new Intent(OptionSelector_MainWindow.this, a_recycler_view_fert_view_display_activity.class);
                //  startActivity(intent);
                //Intent intent = new Intent(OptionSelector_MainWindow.this, a_recycler_view_fert_view_display_activity.class);
                //    startActivity(intent);
                // finish();


                ad_ai_4_OptionDataModel_trnWindow dataE = data.get(position);

                switch(dataE.getOptionName())
                {
                    case "Post traning Advt":

                        Intent intent = new Intent(aa_ai_4_OptionSelector_trnWindow.this, a_0_trainformEntryForm.class);
                        startActivity(intent);
                        break;


                    case "View Traning List":

                        intent = new Intent(aa_ai_4_OptionSelector_trnWindow.this, OptionSelector_train_view.class);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        data = new ArrayList<ad_ai_4_OptionDataModel_trnWindow>();

        for (int i = 0; i < ac_ai_4_OptionData_trnWindow.nameArray.length; i++)
        {
            data.add(new ad_ai_4_OptionDataModel_trnWindow( ac_ai_4_OptionData_trnWindow.nameArray[i][0], ac_ai_4_OptionData_trnWindow.nameArray[i][1]));
        }



        adapter = new ab_ai_4_OptionAdapter_trnWindow(data,getApplicationContext());
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
                    helperFunctions_class.showToast(aa_ai_4_OptionSelector_trnWindow.this, "Inside Login Function");
                }
                helperFunctions_class.logOut_reset_flags(aa_ai_4_OptionSelector_trnWindow.this);
                Intent intent = new Intent(aa_ai_4_OptionSelector_trnWindow.this, login_activity.class);
                startActivity(intent);
                finish();


                return true;

        }

        return super.onOptionsItemSelected(item);
    }

}


