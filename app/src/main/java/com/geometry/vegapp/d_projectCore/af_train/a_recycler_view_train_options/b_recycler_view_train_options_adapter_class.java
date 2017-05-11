package com.geometry.vegapp.d_projectCore.af_train.a_recycler_view_train_options;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geometry.vegapp.R;

import java.util.ArrayList;

public class b_recycler_view_train_options_adapter_class extends RecyclerView.Adapter<e_recycler_view_train_options_viewholder_class>
{

    private ArrayList<d_recycler_view_train_options_datamodel_class> dataSet;
    Context ctx;



    public b_recycler_view_train_options_adapter_class(ArrayList<d_recycler_view_train_options_datamodel_class> data, Context ctx)
    {
        this.dataSet = data;
        this.ctx =ctx;
    }

    @Override
    public e_recycler_view_train_options_viewholder_class onCreateViewHolder(ViewGroup parent,
                                                                             int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_aa_ai_card_view_mainwindow, parent, false);



        e_recycler_view_train_options_viewholder_class myViewHolder = new e_recycler_view_train_options_viewholder_class(view,ctx);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final e_recycler_view_train_options_viewholder_class holder, final int listPosition)
    {
        holder.bind(dataSet.get(listPosition));



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
