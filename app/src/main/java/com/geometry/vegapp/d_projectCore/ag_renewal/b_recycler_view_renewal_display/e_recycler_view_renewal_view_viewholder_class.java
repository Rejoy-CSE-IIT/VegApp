package com.geometry.vegapp.d_projectCore.ag_renewal.b_recycler_view_renewal_display;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.geometry.vegapp.R;
import com.geometry.vegapp.b_homepage.homepage_activity;
import com.geometry.vegapp.c_utility_functions.helperFunctions_class;

/**
 * Created by Rijoy on 3/20/2017.
 */

public class e_recycler_view_renewal_view_viewholder_class extends  RecyclerView.ViewHolder
{

    TextView company;
    // TextView place;

    TextView category;
    ImageView seedImageView;
    View view;

    CardView card;

    CardView cv;
    final Context ctx;
    final Activity activity;

    RatingBar ratingbar;



    public e_recycler_view_renewal_view_viewholder_class(View itemView, final Context ctx, final Activity act)
    {
        super(itemView);
        this.view =itemView;
        this.ctx=ctx;
        this.activity=act;

        this.cv  = (CardView) itemView.findViewById(R.id.optionRView);
        this.company = (TextView) itemView.findViewById(R.id.company);
        this.category = (TextView) itemView.findViewById(R.id.category);
        // this.place = (TextView) itemView.findViewById(R.id.place);
        this.seedImageView = (ImageView) itemView.findViewById(R.id.imageseed);


        ratingbar=(RatingBar)itemView.findViewById(R.id.ratingBar1);


        //

    }
/*
        view.setOnClickListener(new View.OnClickListener()
        {
        @Override
            public void onClick(View v)
            {
            // item clicked
            }
        });*/

    public void bind(final d_recycler_view_renewal_view_datamodel_class data)
    {


        if( data.disableview)
        {
            cv.setVisibility(View.GONE);
        }
        else

        {
            cv.setVisibility(View.VISIBLE);
        }

        if(!new String(homepage_activity.user_mode).equals("admin"))
        {
            if(data.getApproval()==0 )
            {
                cv.setVisibility(View.GONE);
            }

        }

        //     this.card.setVisibility(View.GONE);


        byte[] decodedString = Base64.decode(data.getImage(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        // Bitmap bitmap_P = Compressor.getDefault(ctx).compressToBitmap(decodedByte.);



        // this.seedImageView.setImageBitmap(decodedByte);

        float screenWidth= helperFunctions_class.getScreenWidth(activity );


        float newHeight = screenWidth;
        //  screenWidth=screenWidth/1.3f;
        if (decodedByte.getWidth() != 0 && decodedByte.getHeight() != 0)
        {
            newHeight = (screenWidth * decodedByte.getHeight()) / decodedByte.getWidth();
        }

        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams((int)screenWidth,(int)newHeight);
        this.seedImageView.setLayoutParams(parms);
        this.seedImageView.setImageBitmap(decodedByte);

        company.setText(data.getOrganization().toString());
        category.setText(data.getCategory().toString());

        ratingbar.setRating(data.getRating());
        //  place.setText(data.getPlace().toString());











    }




}
