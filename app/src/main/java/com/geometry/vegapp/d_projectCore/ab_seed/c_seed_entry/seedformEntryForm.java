package com.geometry.vegapp.d_projectCore.ab_seed.c_seed_entry;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.geometry.vegapp.h_login.login_activity;
import com.geometry.vegapp.i_ImageProcessing.PinchZoomImageView_class;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import id.zelory.compressor.Compressor;
import id.zelory.compressor.FileUtil;

public class seedformEntryForm extends AppCompatActivity
{

    PinchZoomImageView_class mPinchZoomImageViewClass;
    Uri mImageUri=null;
    EditText organization_ET;
    EditText                                                                price_ET;
    EditText                                                             category_ET;
    EditText                                                              details_ET;
    EditText                                                              place_ET;

    EditText                                                              mobno_ET;

    EditText                                                              contacts_ET;
    Button seed_req_button;
    Button                                                         selectImageButton;
    TextView seed_label;

    Bitmap bitmap_P=null;
    private static final int           REQUEST_OPEN_GALLEY =0;



    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_0_seedform_entry_form);


        organization_ET    = (EditText)findViewById(R.id.organization_ET);
        price_ET           = (EditText)findViewById(R.id.price_ET);
        place_ET             = (EditText)findViewById(R.id.place_ET);
        category_ET        = (EditText)findViewById(R.id.category_ET);
        details_ET         = (EditText)findViewById(R.id.details_ET);
        mobno_ET         = (EditText)findViewById(R.id.mobno_ET);
        contacts_ET         = (EditText)findViewById(R.id.contacts_ET);
        seed_req_button    = (Button)  findViewById(R.id.seed_req_button);
        selectImageButton  =  (Button)  findViewById(R.id.selectImageButton);
        seed_label         =  (TextView) findViewById(R.id.seedlabel);
        mPinchZoomImageViewClass = (PinchZoomImageView_class)  findViewById(R.id.image_select_from_galley_img);

        selectImageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_OPEN_GALLEY);
                //mImageUri=null;
            }

        });




        seed_req_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(organization_ET.getText().toString().equals("")||place_ET.getText().toString().equals("")||
                        price_ET.getText().toString().equals("") ||bitmap_P==null||
                        category_ET.getText().toString().equals("")||
                        mobno_ET.getText().toString().equals("")||
                        contacts_ET.getText().toString().equals("")||
                        details_ET.getText().toString().equals(""))

                {
                    builder=new AlertDialog.Builder(seedformEntryForm.this);
                    builder.setTitle("Something went wrong....");
                    builder.setMessage("please fill all the fields..");

                    builder.setPositiveButton("ok",new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog,int which)
                        {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                }
                else
                {






                    StringRequest stringRequest = new StringRequest(Request.Method.POST, webPageLinks_class.getSeed_Register_URL(),
                            new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response)
                                {


                                    // remember response is the sring that you sent from server open php
                                    if(homepage_activity.TESTING_MODE)
                                        Toast.makeText(seedformEntryForm.this, response, Toast.LENGTH_LONG).show();

                                    Gson gson = new Gson();
                                    //*
                                    JsonElement element = gson.fromJson (response, JsonElement.class);
                                    JsonObject jsonObj = element.getAsJsonObject();


                                    String result_of_register = jsonObj.get("status").getAsString();
                                    if(result_of_register.equals("true"))
                                    {


                                        //  if(homepage_activity.TESTING_MODE)
                                        Toast.makeText(seedformEntryForm.this, "Seed Registration Successful!", Toast.LENGTH_LONG).show();


                                        Intent intent = new Intent(seedformEntryForm.this, a_recycler_view_seed_options_display_activity.class);
                                        startActivity(intent);
                                        finish();

                                        //Intent intent = new Intent(renewalformEntryForm.this, d_recycler_view_train_view_datamodel_class.class);
                                        // intent.putExtra("fromReg", true);
                                        // startActivity(intent);
                                    }
                                    else
                                    {
                                        //Toast.makeText(Register.this, "Registration  Failed", Toast.LENGTH_LONG).show();
                                        seed_label.setText("Seed Registration Failed Try again !!");
                                    }
                                    bitmap_P=null;
                                }
                            },
                            new Response.ErrorListener()
                            {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(seedformEntryForm.this,error.toString(),Toast.LENGTH_LONG).show();
                                }
                            }){
                        @Override
                        protected Map<String,String> getParams()
                        {
                            Map<String,String> params = new HashMap<String, String>();


                            params.put("organization",organization_ET.getText().toString());
                            params.put("price",price_ET.getText().toString());
                            params.put("category",category_ET.getText().toString());
                            params.put("details",details_ET.getText().toString());
                            params.put("place",place_ET.getText().toString());
                            params.put("id", Integer.toString(homepage_activity.user_id));
                            params.put("mobno",mobno_ET.getText().toString());
                            params.put("contacts", contacts_ET.getText().toString());
/*
                            params.put("imagename", Integer.toString(homepage_activity.user_id)+
                                    java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime())
                            );*/

                            params.put("image", getStringImage(bitmap_P));



                            return params;
                        }

                    };


                    volley_connection_class.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);








                }//

            }
        });///






    }



    public boolean isValidEmail(CharSequence target)
    {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent_resultdata)
    {


        // Check which request we're responding to
        if (requestCode == REQUEST_OPEN_GALLEY && resultCode ==RESULT_OK)
        {


            if(intent_resultdata!=null)
            {
                mImageUri = intent_resultdata.getData();



                if(mImageUri==null)
                {
                    // utilClass.getToast("NULL",renewalformEntryForm.this);
                }
                else
                {

                    //   utilClass.getToast("NOT NULL",renewalformEntryForm.this);

                    mPinchZoomImageViewClass.setVisibility(View.VISIBLE);
                    mPinchZoomImageViewClass.setImageUri(mImageUri, 0);
                    seed_req_button.setVisibility(View.VISIBLE);
                    try
                    {
                        File actualImage;
                        actualImage = FileUtil.from(seedformEntryForm.this, mImageUri);
                        bitmap_P = Compressor.getDefault(this).compressToBitmap(actualImage);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }

            }
        }




        super.onActivityResult(requestCode, resultCode, intent_resultdata);






    }




    private void uploadImage()
    {

    }


    public String getStringImage(Bitmap bmp)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 70, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
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
                    helperFunctions_class.showToast(seedformEntryForm.this, "Inside Login Function");
                }
                helperFunctions_class.logOut_reset_flags(seedformEntryForm.this);
                Intent intent = new Intent(seedformEntryForm.this, login_activity.class);
                startActivity(intent);
                finish();


                return true;

        }

        return super.onOptionsItemSelected(item);
    }




}
