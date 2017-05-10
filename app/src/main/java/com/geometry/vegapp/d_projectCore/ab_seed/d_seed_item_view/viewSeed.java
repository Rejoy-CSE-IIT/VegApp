package com.geometry.vegapp.d_projectCore.ab_seed.d_seed_item_view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.geometry.vegapp.R;
import com.geometry.vegapp.b_homepage.homepage_activity;
import com.geometry.vegapp.c_utility_functions.helperFunctions_class;
import com.geometry.vegapp.d_projectCore.ab_seed.a_recycler_view_seed_options.a_recycler_view_seed_options_display_activity;
import com.geometry.vegapp.f_webPageLinks.webPageLinks_class;
import com.geometry.vegapp.g_volley_manager.volley_connection_class;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;


public class viewSeed extends AppCompatActivity
{

    ImageView mPinchZoomImageView;
    Uri mImageUri=null;
    TextView organization_ET;
    TextView                                                                price_ET;
    TextView                                                             category_ET;
    TextView                                                              details_ET;

    TextView                                                                place;
    TextView                                                             contacts;
    TextView                                                              mobno;

    Button approve;
    Button                                                                   delete;
    TextView                                                              seed_label;
    int mobile_n0  ;
    int userid  ;
    int postid  ;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;

    String txtphoneNo="",message="";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zzz_viewseed);







        organization_ET    = (TextView)findViewById(R.id.organization_ET);
        price_ET           = (TextView)findViewById(R.id.price_ET);
        category_ET        = (TextView)findViewById(R.id.category_ET);
        details_ET         = (TextView)findViewById(R.id.details_ET);
        approve            = (Button)  findViewById(R.id.approve);
        delete             =  (Button)  findViewById(R.id.delete);
        seed_label         =  (TextView) findViewById(R.id.seedlabel);

        place            = (TextView)  findViewById(R.id.place_ET);
        mobno             =  (TextView)  findViewById(R.id.mobno_ET);
        contacts         =  (TextView) findViewById(R.id.contacts_ET);


        mPinchZoomImageView = (ImageView)  findViewById(R.id.image_select_from_galley_img);




/*
        if(!VegMain.admin_status)
            approve.setVisibility(View.GONE);*/





        Intent mIntent = getIntent();
        int price = mIntent.getIntExtra("price", 0);
        userid = mIntent.getIntExtra("userid", 0);
        postid = mIntent.getIntExtra("id", 0);

        mobile_n0 = mIntent.getIntExtra("mobno", 0);
        int approval = mIntent.getIntExtra("approval", 0);





        String organization = mIntent.getStringExtra("organization");
        String category = mIntent.getStringExtra("category");
        String details = mIntent.getStringExtra("details");
        String image = mIntent.getStringExtra("image");
        String contacts_C = mIntent.getStringExtra("contacts");
        String place_C = mIntent.getStringExtra("place");


        if(new String(homepage_activity.user_mode).equals("user"))
        {
            delete.setVisibility(View.GONE);
            approve.setVisibility(View.GONE);
        }


        if(new String(homepage_activity.user_mode).equals("vendor"))
        {
            if(homepage_activity.user_id!=userid)
                delete.setVisibility(View.GONE);

            approve.setVisibility(View.GONE);


        }


        if(new String(homepage_activity.user_mode).equals("admin")&& approval==1)
        {

            approve.setVisibility(View.GONE);
        }





/*
        if(!homepage_activity.user_mode.equals("admin"))
        {
            if(VegMain.id !=userid )
            {
                delete.setVisibility(View.GONE);
            }
        }
*/

        organization_ET.setText(organization);
        category_ET.setText(category);
        details_ET.setText(details);

        contacts.setText(contacts_C);
        place.setText(place_C);
        mobno.setText(Integer.toString(mobile_n0));



        price_ET.setText(Integer.toString(price));

        byte[] decodedString = Base64.decode(image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,decodedString.length);

        float screenWidth= helperFunctions_class.getScreenWidth(viewSeed.this );


        float newHeight = screenWidth;
        screenWidth=screenWidth/1.4f;
        if (decodedByte.getWidth() != 0 && decodedByte.getHeight() != 0)
        {
            newHeight = (screenWidth * decodedByte.getHeight()) / decodedByte.getWidth();
        }

        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams((int)screenWidth,(int)newHeight);

        this.mPinchZoomImageView.setLayoutParams(parms);
        this.mPinchZoomImageView.setImageBitmap(decodedByte);


        // Bitmap bitmap_P = Compressor.getDefault(ctx).compressToBitmap(decodedByte.);



        // this.mPinchZoomImageView.setImageBitmap(decodedByte);

        approve.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {









                StringRequest stringRequest = new StringRequest(Request.Method.POST, webPageLinks_class.getApproval_Seed_URL(),
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                // remember response is the sring that you sent from server open php
                                //Toast.makeText(fertVeg.this, response, Toast.LENGTH_LONG).show();
                                // Toast.makeText(fertVeg.this, Integer.toString(userid), Toast.LENGTH_LONG).show();
                                Gson gson = new Gson();


                                JsonElement element = gson.fromJson (response, JsonElement.class);
                                JsonObject jsonObj = element.getAsJsonObject();


                                String result_of_register = jsonObj.get("status").getAsString();
                                if(result_of_register.equals("true"))
                                {
                                    Toast.makeText(viewSeed.this, "Approved --+"+mobile_n0, Toast.LENGTH_LONG).show();

                                    // // sendSMSMessage();
                                    // sendSMS();

                                    //mobno.setText(Integer.toString(mobile_n0));
                                    //  sendSMS(Integer.toString(5554) ,"Your Post has been approved by VegMarket");

                                    txtphoneNo=Integer.toString(mobile_n0);
                                    message= "Your seed post is arrpoved with id "+ Integer.toString(postid);
                                    sendSMSMessage();
                                    Intent intent = new Intent(viewSeed.this, a_recycler_view_seed_options_display_activity.class);

                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {
                                    //Toast.makeText(Register.this, "Registration  Failed", Toast.LENGTH_LONG).show();
                                    seed_label.setText("Approval Failed !!");
                                }

                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(viewSeed.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }){
                    @Override
                    protected Map<String,String> getParams()
                    {
                        Map<String,String> params = new HashMap<String, String>();


                        params.put("postid", Integer.toString(postid));







                            /*
                            params.put("imagepath", Integer.toString(VegMain.id)+
                                    java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime())
                            );
                            params.put("image", String)
                            );*/

                        return params;
                    }

                };


                volley_connection_class.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);










            }
        });///


        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {









                StringRequest stringRequest = new StringRequest(Request.Method.POST, webPageLinks_class.getDelete_Seed_URL(),
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                // remember response is the sring that you sent from server open php
                                Toast.makeText(viewSeed.this, response, Toast.LENGTH_LONG).show();
                                Toast.makeText(viewSeed.this, Integer.toString(userid), Toast.LENGTH_LONG).show();
                                Gson gson = new Gson();
                                //*
                                JsonElement element = gson.fromJson (response, JsonElement.class);
                                JsonObject jsonObj = element.getAsJsonObject();


                                String result_of_register = jsonObj.get("status").getAsString();
                                if(result_of_register.equals("true"))
                                {
                                    Toast.makeText(viewSeed.this, "deleted", Toast.LENGTH_LONG).show();

                                    // Intent intent = new Intent(fertformEntryForm.this, optionDataModel_seed.class);
                                    // intent.putExtra("fromReg", true);
                                    // startActivity(intent);

                                    Intent intent = new Intent(viewSeed.this, a_recycler_view_seed_options_display_activity.class);

                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {
                                    //Toast.makeText(Register.this, "Registration  Failed", Toast.LENGTH_LONG).show();
                                    seed_label.setText("deletion failed !!");
                                }

                            }
                        },

                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(viewSeed.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }){
                    @Override
                    protected Map<String,String> getParams()
                    {
                        Map<String,String> params = new HashMap<String, String>();


                        params.put("postid", Integer.toString(postid));





                            /*
                            params.put("imagepath", Integer.toString(VegMain.id)+
                                    java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime())
                            );
                            params.put("image", String)
                            );*/

                        return params;
                    }

                };


                volley_connection_class.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);










            }
        });//




        final RatingBar ratingbar;
        Button buttonrating;
        ratingbar=(RatingBar)findViewById(R.id.ratingBar);
        buttonrating=(Button)findViewById(R.id.rateB);

        buttonrating.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {









                StringRequest stringRequest = new StringRequest(Request.Method.POST, webPageLinks_class.getRating_seed_Register_URL(),
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                // remember response is the sring that you sent from server open php
                                //Toast.makeText(fertVeg.this, response, Toast.LENGTH_LONG).show();
                                // Toast.makeText(fertVeg.this, Integer.toString(userid), Toast.LENGTH_LONG).show();
                                Gson gson = new Gson();


                                JsonElement element = gson.fromJson (response, JsonElement.class);
                                JsonObject jsonObj = element.getAsJsonObject();


                                String result_of_register = jsonObj.get("status").getAsString();
                                if(result_of_register.equals("true"))
                                {
                                    Toast.makeText(viewSeed.this, " rating updated", Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    //Toast.makeText(Register.this, "Registration  Failed", Toast.LENGTH_LONG).show();
                                    seed_label.setText("rating updation Failed !!");
                                }

                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(viewSeed.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }){
                    @Override
                    protected Map<String,String> getParams()
                    {
                        Map<String,String> params = new HashMap<String, String>();


                        params.put("postid", Integer.toString(postid));
                        params.put("currentRating", String.valueOf(ratingbar.getRating()));






                            /*
                            params.put("imagepath", Integer.toString(VegMain.id)+
                                    java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime())
                            );
                            params.put("image", String)
                            );*/

                        return params;
                    }

                };


                volley_connection_class.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);










            }
        });



    }


    protected void sendSMSMessage( )
    {


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        else
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(txtphoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults)
    {

        Toast.makeText(getApplicationContext(), "SMS request received.",
                Toast.LENGTH_LONG).show();
        switch (requestCode)
        {
            case MY_PERMISSIONS_REQUEST_SEND_SMS:
            {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(txtphoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }






}
