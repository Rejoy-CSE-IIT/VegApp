package com.geometry.vegapp.j_project_core.a_main_selector;

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
import com.geometry.vegapp.h_login.login_activity;
import com.geometry.vegapp.i_recyclerViewTouchListener_class.recyclerTouchListener_class;
import com.geometry.vegapp.j_project_core.zzDummy.ai_6_user_statics.aa_ai_6_OptionSelector_usrWindow;
import com.geometry.vegapp.j_project_core.zzDummy.zai_2_Fertilizers.aa_ai_2_OptionSelector_fertWindow;
import com.geometry.vegapp.j_project_core.zzDummy.zai_3_plant.aa_ai_3_OptionSelector_plantWindow;
import com.geometry.vegapp.j_project_core.zzDummy.zai_4_Training.aa_ai_4_OptionSelector_trnWindow;
import com.geometry.vegapp.j_project_core.zzDummy.zai_5_renewal_energey.aa_ai_5_OptionSelector_rnwWindow;
import com.geometry.vegapp.j_project_core.b_seed_section.a_recycler_view_seed_options.a_recycler_view_seed_options_display_activity;
import com.geometry.vegapp.j_project_core.c_vegetable.a_recycler_view_veg_options.a_recycler_view_veg_options_display_activity;

import java.util.ArrayList;

public class aa_ai_OptionSelector_MainWindow extends AppCompatActivity
{


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<ad_ai_OptionDataModel_mainWindow> data;
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
                // d_recycler_view_fert_view_datamodel_class dataE = data.get(position);
                //Toast.makeText(getApplicationContext(), dataE.getOptionName() + " is selected!", Toast.LENGTH_SHORT).show();
              //  Toast.makeText(getApplicationContext(),   " is selected!", Toast.LENGTH_SHORT).show();
                //   Intent intent = new Intent(OptionSelector_MainWindow.this, a_recycler_view_fert_view_display_activity.class);
                //  startActivity(intent);
                //Intent intent = new Intent(OptionSelector_MainWindow.this, a_recycler_view_fert_view_display_activity.class);
                //    startActivity(intent);
                // finish();


                ad_ai_OptionDataModel_mainWindow dataE = data.get(position);
                if(homepage_activity.TESTING_MODE)
                    Toast.makeText(aa_ai_OptionSelector_MainWindow.this, "outside tester", Toast.LENGTH_LONG).show();
                Intent intent;
                switch(dataE.getOptionName())
                {


                    case "Seed Section":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();


                          intent = new Intent(aa_ai_OptionSelector_MainWindow.this, a_recycler_view_seed_options_display_activity.class);
                        startActivity(intent);
                        break;


                    case "Vegetable Product":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();



                          intent = new Intent(aa_ai_OptionSelector_MainWindow.this, a_recycler_view_veg_options_display_activity.class);
                        startActivity(intent);
                        break;



                    case "Fertilizers":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();


                        intent = new Intent(aa_ai_OptionSelector_MainWindow.this, aa_ai_2_OptionSelector_fertWindow.class);
                        startActivity(intent);
                        break;

                    case "Plant Section":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();


                        intent = new Intent(aa_ai_OptionSelector_MainWindow.this, aa_ai_3_OptionSelector_plantWindow.class);
                        startActivity(intent);
                        break;

                    case "Training":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();


                        intent = new Intent(aa_ai_OptionSelector_MainWindow.this, aa_ai_4_OptionSelector_trnWindow.class);
                        startActivity(intent);
                        break;

                      case "Renewal Enegery":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();


                        intent = new Intent(aa_ai_OptionSelector_MainWindow.this, aa_ai_5_OptionSelector_rnwWindow.class);
                        startActivity(intent);
                        break;


                    case "user details":

                        if(homepage_activity.TESTING_MODE)
                            Toast.makeText(aa_ai_OptionSelector_MainWindow.this, "Inside tester"+dataE.getOptionName(), Toast.LENGTH_LONG).show();


                        intent = new Intent(aa_ai_OptionSelector_MainWindow.this, aa_ai_6_OptionSelector_usrWindow.class);
                        startActivity(intent);
                        break;




                    //Toast.makeText(getApplicationContext(), dataE.getOptionName() + " is selected!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        data = new ArrayList<ad_ai_OptionDataModel_mainWindow>();

        for (int i = 0; i < ac_ai_OptionData_mainWindow.nameArray.length; i++)
        {
            data.add(new ad_ai_OptionDataModel_mainWindow( ac_ai_OptionData_mainWindow.nameArray[i]));
        }



        adapter = new ab_ai_OptionAdapter_mainWindow(data,getApplicationContext());
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
                    helperFunctions_class.showToast(aa_ai_OptionSelector_MainWindow.this, "Inside Login Function");
                }
                helperFunctions_class.logOut_reset_flags(aa_ai_OptionSelector_MainWindow.this);
                Intent intent = new Intent(aa_ai_OptionSelector_MainWindow.this, login_activity.class);
                startActivity(intent);
                finish();


                return true;

        }

        return super.onOptionsItemSelected(item);
    }

}


