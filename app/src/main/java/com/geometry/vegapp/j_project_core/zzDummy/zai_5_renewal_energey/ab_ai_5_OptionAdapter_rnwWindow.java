package com.geometry.vegapp.j_project_core.zzDummy.zai_5_renewal_energey;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geometry.vegapp.R;

import java.util.ArrayList;

public class ab_ai_5_OptionAdapter_rnwWindow extends RecyclerView.Adapter<ae_ai_5_OptionViewHolder_rnw_window>
{

    private ArrayList<ad_ai_5_OptionDataModel_rnwWindow> dataSet;
    Context ctx;



    public ab_ai_5_OptionAdapter_rnwWindow(ArrayList<ad_ai_5_OptionDataModel_rnwWindow> data, Context ctx)
    {
        this.dataSet = data;
        this.ctx =ctx;
    }

    @Override
    public ae_ai_5_OptionViewHolder_rnw_window onCreateViewHolder(ViewGroup parent,
                                                                  int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_aa_ai_card_view_mainwindow, parent, false);



        ae_ai_5_OptionViewHolder_rnw_window myViewHolder = new ae_ai_5_OptionViewHolder_rnw_window(view,ctx);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ae_ai_5_OptionViewHolder_rnw_window holder, final int listPosition)
    {
        holder.bind(dataSet.get(listPosition));



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
