package com.geometry.vegapp.j_project_core.zzDummy.zai_2_Fertilizers;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geometry.vegapp.R;

public class ae_ai_2_OptionViewHolder_fert_window extends  RecyclerView.ViewHolder
{

    TextView textViewName;
    TextView textViewVersion;
    ImageView imageViewIcon;
    View view;

    CardView cv;
    final Context ctx;



    public ae_ai_2_OptionViewHolder_fert_window(View itemView, final Context ctx)
    {
        super(itemView);
        this.view =itemView;
        this.ctx=ctx;



    }


    public void bind(final ad_ai_2_OptionDataModel_fertWindow data)
    {

        this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
        textViewName.setText(data.getOptionName());





    }

}
