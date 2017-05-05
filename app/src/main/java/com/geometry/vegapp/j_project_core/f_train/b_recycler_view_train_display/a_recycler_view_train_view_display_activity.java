package com.geometry.vegapp.j_project_core.f_train.b_recycler_view_train_display;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.geometry.vegapp.R;
import com.geometry.vegapp.b_homepage.homepage_activity;
import com.geometry.vegapp.c_utility_functions.helperFunctions_class;
import com.geometry.vegapp.f_webPageLinks.webPageLinks_class;
import com.geometry.vegapp.g_volley_manager.volley_connection_class;
import com.geometry.vegapp.h_login.login_activity;
import com.geometry.vegapp.i_recyclerViewTouchListener_class.recyclerTouchListener_class;
import com.geometry.vegapp.j_project_core.f_train.d_recycler_view_train_item_view.viewtrain;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a_recycler_view_train_view_display_activity extends AppCompatActivity
{

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<d_recycler_view_train_view_datamodel_class> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    public EditText search;
    public EditText search_D;
    public  boolean ready_search =false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zzz_a0_option_selector_seed_view);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        search = (EditText) findViewById( R.id.SearchText);
        search_D= (EditText) findViewById( R.id.SearchTextD);


       // search.setText("Hello");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
      //  recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);


        recyclerView.addOnItemTouchListener(new recyclerTouchListener_class(getApplicationContext(), recyclerView, new recyclerTouchListener_class.ClickListener()
        {
            @Override
            public void onClick(View view, int position)
            {
                d_recycler_view_train_view_datamodel_class dataE = data.get(position);

                Intent intent = new Intent(a_recycler_view_train_view_display_activity.this, viewtrain.class);



                intent.putExtra("organization", dataE.getOrganization());
                intent.putExtra("category",dataE.getCategory());
                intent.putExtra("details", dataE.getDetails());
                intent.putExtra("image", dataE.getImage());

                intent.putExtra("place", dataE.getPlace());
                intent.putExtra("contacts",dataE.getContacts());





                intent.putExtra("price", dataE.getPrice());
                intent.putExtra("userid", dataE.getUserid());
                intent.putExtra("id", dataE.getId());
                intent.putExtra("mobno", dataE.getMobno());
                intent.putExtra("approval", dataE.getApproval());









                startActivity(intent);








                    //Toast.makeText(getApplicationContext(), dataE.getOptionName() + " is selected!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        data = new ArrayList<d_recycler_view_train_view_datamodel_class>();

        /*
        for (int i = 0; i < c_recycler_view_fert_view_data_storage_class.nameArray.length; i++)
        {
            data.add(new d_recycler_view_fert_view_datamodel_class(
                    c_recycler_view_fert_view_data_storage_class.nameArray[i][0], c_recycler_view_fert_view_data_storage_class.nameArray[i][1]

            ));
        }*/


        adapter = new b_recycler_view_train_view_adapter_class(data,getApplicationContext(),this);
        recyclerView.setAdapter(adapter);




    }


    public void addTextListener(){

        search.addTextChangedListener(new TextWatcher()
        {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence query, int start, int before, int count)
            {

                query = query.toString().toLowerCase();
                boolean flag_no_result=true;

                String text=null;
                String Dummy="";

               // helperFunctions_class.showToast(a_recycler_view_fert_view_display_activity.this," ##"+query);


                for (int i = 0; i < data.size(); i++)
                {
                    text = data.get(i).getOrganization();
                    Dummy+=text+"=>"+query +"::";



                    if(isEmpty(query.toString()))
                    {
                        data.get(i).setDisableview(false);
                        //search_D.setText("");
                    }
                    else
                    {



                        if(
                            //    data.get(i).getOrganization().contains(query.toString())

                              data.get(i).getOrganization().toLowerCase().contains(query.toString())||
                                      Integer.toString(data.get(i).getMobno()).toLowerCase().contains(query.toString())||

                                      data.get(i).getPlace().toLowerCase().contains(query.toString())



                                )

                        {
                            data.get(i).setDisableview(false);
                           // search_D.setText(query+"::"+data.get(i).getOrganization());
                           /* helperFunctions_class.showToast(a_recycler_view_fert_view_display_activity.this,""+data.get(i).getOrganization()
                                    +"##"+query
                            );*/
                        }
                        else
                        {
                             data.get(i).setDisableview(true);
                          //  search_D.setText(query+"::"+"no Item");
                         //   helperFunctions_class.showToast(a_recycler_view_fert_view_display_activity.this,"search failed"
                           // );
                        }

                    }


                    /*

                    if(data.get(i).getOrganization().equals(query))
                    {
                         data.get(i).setDisableview(false);
                    }
                    else
                    {
                       data.get(i).setDisableview(true);
                    }*/



                }



                if(flag_no_result)
                {
                  //  search_D.setText("  result::"+query+"::"+text);
                }
                else
                {
                  //  search_D.setText(" No result::"+query+"::"+text);
                }

                search_D.setText(Dummy);
                adapter.notifyDataSetChanged();  // data set changed

            }
        });
    }

    private boolean isEmpty(String str)
    {
        return str.trim().length() == 0;
    }
    private boolean isContainExactWord(String fullString, String partWord){
        String pattern = "\\b"+partWord+"\\b";
        Pattern p= Pattern.compile(pattern);
        Matcher m=p.matcher(fullString);
        return m.find();
    }
    @Override
    public void onStart()
    {
        super.onStart();

        getDataFromServer();


    }



    void getDataFromServer()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, webPageLinks_class.getVegView_URL(),
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                          Gson gson = new Gson();
                          JsonElement element = gson.fromJson (response, JsonElement.class);
                        JsonObject jsonObj = element.getAsJsonObject();

                        data.clear();
                        String result_of_register = jsonObj.get("status").getAsString();
                        int count           = jsonObj.get("count").getAsInt();

                        if(result_of_register.equals("true"))
                        {

                            for(int i =0;i<count;i++)
                            {

                                String idS = Integer.toString(i);
                                String organization = jsonObj.get("organization"+idS).getAsString();

                                int price           = jsonObj.get("price"+idS).getAsInt();
                                String category     = jsonObj.get("category"+idS).getAsString();
                                String details      = jsonObj.get("details"+idS).getAsString();
                                int userid          = jsonObj.get("userid"+idS).getAsInt();
                                String image        = jsonObj.get("image"+idS).getAsString();
                                int id              = jsonObj.get("id"+idS).getAsInt();
                                int mobno           = jsonObj.get("mobno"+idS).getAsInt();
                                String place     = jsonObj.get("place"+idS).getAsString();
                                String contacts     = jsonObj.get("contacts"+idS).getAsString();
                                int approval     = jsonObj.get("approval"+idS).getAsInt();
                                float rating       = jsonObj.get("rating"+idS).getAsFloat();





                                //  int approved         = jsonObj.get("approved"+idS).getAsInt();
                               // int approved=0;


                                data.add(new d_recycler_view_train_view_datamodel_class(
                                        organization,   category,   details,   image,   place,
                                        contacts,   price,   userid,   id,   approval,   mobno,false,rating

                                ));

                            }




                            adapter.notifyDataSetChanged();
                            addTextListener();


                        }
                        else
                        {
                            //Toast.makeText(Register.this, "Registration  Failed", Toast.LENGTH_LONG).show();
                            //register_label.setText("Registration Failed Try again !!");
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(a_recycler_view_train_view_display_activity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams()
            {
                Map<String,String> params = new HashMap<String, String>();

                return params;
            }

        };


        volley_connection_class.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

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
                    helperFunctions_class.showToast(a_recycler_view_train_view_display_activity.this, "Inside Login Function");
                }
                helperFunctions_class.logOut_reset_flags(a_recycler_view_train_view_display_activity.this);
                Intent intent = new Intent(a_recycler_view_train_view_display_activity.this, login_activity.class);
                startActivity(intent);
                finish();


                return true;

        }

        return super.onOptionsItemSelected(item);
    }





}