package com.geometry.vegapp.d_projectCore.aa_mainWindow;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geometry.vegapp.R;

public class ae_ai_OptionViewHolder_mainwindow_class extends  RecyclerView.ViewHolder
{

    TextView textViewName;
    TextView textViewVersion;
    ImageView imageViewIcon;
    View view;

    CardView cv;
    final Context ctx;



    public ae_ai_OptionViewHolder_mainwindow_class(View itemView, final Context ctx)
    {
        super(itemView);
        this.view =itemView;
        this.ctx=ctx;



    }


    public void bind(final ad_ai_OptionDataModel_mainWindow_class data)
    {

        this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
        textViewName.setText(data.getOptionName());





    }

}
