package com.geometry.vegapp.d_projectCore.ae_plant.b_recycler_view_plant_display;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geometry.vegapp.R;

import java.util.ArrayList;

public class b_recycler_view_plant_view_adapter_class extends RecyclerView.Adapter<e_recycler_view_plant_view_viewholder_class>
{

    private ArrayList<d_recycler_view_plant_view_datamodel_class> dataSet;
    Context ctx;
    Activity act;



    public b_recycler_view_plant_view_adapter_class(ArrayList<d_recycler_view_plant_view_datamodel_class> data, Context ctx, Activity act)
    {
        this.dataSet = data;
        this.ctx =ctx;
        this.act=act;
    }

    @Override
    public e_recycler_view_plant_view_viewholder_class onCreateViewHolder(ViewGroup parent,
                                                                          int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bbc_seed_card, parent, false);



        e_recycler_view_plant_view_viewholder_class myViewHolder = new e_recycler_view_plant_view_viewholder_class(view,ctx,act);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final e_recycler_view_plant_view_viewholder_class holder, final int listPosition)
    {
        holder.bind(dataSet.get(listPosition));



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
