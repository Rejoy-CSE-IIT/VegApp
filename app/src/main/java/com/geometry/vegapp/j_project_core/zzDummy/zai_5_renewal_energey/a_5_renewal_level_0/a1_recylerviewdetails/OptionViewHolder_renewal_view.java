package com.geometry.vegapp.j_project_core.zzDummy.zai_5_renewal_energey.a_5_renewal_level_0.a1_recylerviewdetails;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geometry.vegapp.R;
import com.geometry.vegapp.b_homepage.homepage_activity;

/**
 * Created by Rijoy on 3/20/2017.
 */

public class OptionViewHolder_renewal_view extends  RecyclerView.ViewHolder
{

    TextView company;
    TextView place;

    TextView category;
    ImageView seedImageView;
    View view;

    CardView card;

    CardView cv;
    final Context ctx;



    public OptionViewHolder_renewal_view(View itemView, final Context ctx)
    {
        super(itemView);
        this.view =itemView;
        this.ctx=ctx;

        this.cv  = (CardView) itemView.findViewById(R.id.optionRView);
        this.company = (TextView) itemView.findViewById(R.id.company);
        this.category = (TextView) itemView.findViewById(R.id.category);
        this.place = (TextView) itemView.findViewById(R.id.place);
        this.seedImageView = (ImageView) itemView.findViewById(R.id.imageseed);

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

    public void bind(final optionDataModel_renewal_view data)
    {


        if(!new String(homepage_activity.user_mode).equals("admin"))
        {
            if(data.getApproval()==0 || data.getDisableview()==1)
            {
                cv.setVisibility(View.GONE);
            }

        }

        //     this.card.setVisibility(View.GONE);


        byte[] decodedString = Base64.decode(data.getImage(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        // Bitmap bitmap_P = Compressor.getDefault(ctx).compressToBitmap(decodedByte.);

        this.seedImageView.setImageBitmap(decodedByte);
        company.setText(data.getOrganization().toString());
        category.setText(data.getCategory().toString());
        place.setText(data.getPlace().toString());











    }

}
