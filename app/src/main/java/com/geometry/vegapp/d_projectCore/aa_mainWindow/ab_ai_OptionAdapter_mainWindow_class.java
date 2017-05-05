package com.geometry.vegapp.d_projectCore.aa_mainWindow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geometry.vegapp.R;

import java.util.ArrayList;

public class ab_ai_OptionAdapter_mainWindow_class extends RecyclerView.Adapter<ae_ai_OptionViewHolder_mainwindow_class>
{

    private ArrayList<ad_ai_OptionDataModel_mainWindow_class> dataSet;
    Context ctx;



    public ab_ai_OptionAdapter_mainWindow_class(ArrayList<ad_ai_OptionDataModel_mainWindow_class> data, Context ctx)
    {
        this.dataSet = data;
        this.ctx =ctx;
    }

    @Override
    public ae_ai_OptionViewHolder_mainwindow_class onCreateViewHolder(ViewGroup parent,
                                                                      int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_aa_ai_card_view_mainwindow, parent, false);



        ae_ai_OptionViewHolder_mainwindow_class myViewHolder = new ae_ai_OptionViewHolder_mainwindow_class(view,ctx);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ae_ai_OptionViewHolder_mainwindow_class holder, final int listPosition)
    {
        holder.bind(dataSet.get(listPosition));



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
