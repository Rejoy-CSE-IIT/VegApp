package com.geometry.vegapp.d_projectCore.ag_renewal.a_recycler_view_renewal_options;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geometry.vegapp.R;

public class e_recycler_view_renewal_options_viewholder_class extends  RecyclerView.ViewHolder
{

    TextView textViewName;
    TextView textViewVersion;
    ImageView imageViewIcon;
    View view;

    CardView cv;
    final Context ctx;



    public e_recycler_view_renewal_options_viewholder_class(View itemView, final Context ctx)
    {
        super(itemView);
        this.view =itemView;
        this.ctx=ctx;



    }


    public void bind(final d_recycler_view_renewal_options_datamodel_class data)
    {

        this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
        textViewName.setText(data.getOptionName());





    }

}
