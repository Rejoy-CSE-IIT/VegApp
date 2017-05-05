package com.geometry.vegapp.j_project_core.zzDummy.zai_4_Training;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geometry.vegapp.R;

import java.util.ArrayList;

public class ab_ai_4_OptionAdapter_trnWindow extends RecyclerView.Adapter<ae_ai_4_OptionViewHolder_trn_window>
{

    private ArrayList<ad_ai_4_OptionDataModel_trnWindow> dataSet;
    Context ctx;



    public ab_ai_4_OptionAdapter_trnWindow(ArrayList<ad_ai_4_OptionDataModel_trnWindow> data, Context ctx)
    {
        this.dataSet = data;
        this.ctx =ctx;
    }

    @Override
    public ae_ai_4_OptionViewHolder_trn_window onCreateViewHolder(ViewGroup parent,
                                                                  int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_aa_ai_card_view_mainwindow, parent, false);



        ae_ai_4_OptionViewHolder_trn_window myViewHolder = new ae_ai_4_OptionViewHolder_trn_window(view,ctx);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ae_ai_4_OptionViewHolder_trn_window holder, final int listPosition)
    {
        holder.bind(dataSet.get(listPosition));



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
