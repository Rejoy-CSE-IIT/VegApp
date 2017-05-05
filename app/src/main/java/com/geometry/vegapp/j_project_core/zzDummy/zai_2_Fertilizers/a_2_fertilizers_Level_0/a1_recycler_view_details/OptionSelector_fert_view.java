package com.geometry.vegapp.j_project_core.zzDummy.zai_2_Fertilizers.a_2_fertilizers_Level_0.a1_recycler_view_details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.geometry.vegapp.R;
import com.geometry.vegapp.f_webPageLinks.webPageLinks_class;
import com.geometry.vegapp.g_volley_manager.volley_connection_class;
import com.geometry.vegapp.i_recyclerViewTouchListener_class.recyclerTouchListener_class;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OptionSelector_fert_view extends AppCompatActivity
{

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<optionDataModel_fert_view> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    public EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zzz_a0_option_selector_seed_view);

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
                optionDataModel_fert_view dataE = data.get(position);

                Intent intent = new Intent(OptionSelector_fert_view.this, viewfert.class);



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







                startActivity(intent);








                    //Toast.makeText(getApplicationContext(), dataE.getOptionName() + " is selected!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        data = new ArrayList<optionDataModel_fert_view>();

        /*
        for (int i = 0; i < c_recycler_view_fert_view_data_storage_class.nameArray.length; i++)
        {
            data.add(new d_recycler_view_fert_view_datamodel_class(
                    c_recycler_view_fert_view_data_storage_class.nameArray[i][0], c_recycler_view_fert_view_data_storage_class.nameArray[i][1]

            ));
        }*/


        adapter = new OptionAdapter_fert_view(data,getApplicationContext());
        recyclerView.setAdapter(adapter);
        addTextListener();



    }


    public void addTextListener(){

        search.addTextChangedListener(new TextWatcher()
        {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence query, int start, int before, int count)
            {

                query = query.toString().toLowerCase();



                for (int i = 0; i < data.size(); i++)
                {

                    String text = data.get(i).getCategory();

                    if(data.get(i).getCategory().contains(query)||
                            data.get(i).getContacts().contains(query)||
                            data.get(i).getDetails().contains(query)||
                            data.get(i).getPlace().contains(query)


                            )
                    {
                        data.get(i).setDisableview(1);

                    }
                    else
                        data.get(i).setDisableview(0);



                    /*
                    final String text = data.get(i).toLowerCase();
                    if (text.contains(query)) {

                        filteredList.add(list.get(i));
                    }*/
                }

                //mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
               // mAdapter = new SimpleAdapter(filteredList, MainActivity.this);
               // mRecyclerView.setAdapter(mAdapter);
                adapter.notifyDataSetChanged();  // data set changed
            }
        });
    }


    @Override
    public void onStart()
    {
        super.onStart();

        getDataFromServer();




    }



    void getDataFromServer()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, webPageLinks_class.getFertView_URL(),
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                          Gson gson = new Gson();
                          JsonElement element = gson.fromJson (response, JsonElement.class);
                        JsonObject jsonObj = element.getAsJsonObject();


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




                                //  int approved         = jsonObj.get("approved"+idS).getAsInt();
                               // int approved=0;


                                data.add(new optionDataModel_fert_view(
                                        organization,   category,   details,   image,   place,   contacts,   price,   userid,   id,   approval,   mobno

                                ));

                            }




                            adapter.notifyDataSetChanged();


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
                        Toast.makeText(OptionSelector_fert_view.this,error.toString(),Toast.LENGTH_LONG).show();
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








}