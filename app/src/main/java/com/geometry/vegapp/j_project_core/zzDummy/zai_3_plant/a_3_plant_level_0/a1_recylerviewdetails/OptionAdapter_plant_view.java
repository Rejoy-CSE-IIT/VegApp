package com.geometry.vegapp.j_project_core.zzDummy.zai_3_plant.a_3_plant_level_0.a1_recylerviewdetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geometry.vegapp.R;

import java.util.ArrayList;

public class OptionAdapter_plant_view extends RecyclerView.Adapter<OptionViewHolder_plant_view>
{

    private ArrayList<optionDataModel_plant_view> dataSet;
    Context ctx;



    public OptionAdapter_plant_view(ArrayList<optionDataModel_plant_view> data, Context ctx)
    {
        this.dataSet = data;
        this.ctx =ctx;
    }

    @Override
    public OptionViewHolder_plant_view onCreateViewHolder(ViewGroup parent,
                                                          int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bbc_seed_card, parent, false);



        OptionViewHolder_plant_view myViewHolder = new OptionViewHolder_plant_view(view,ctx);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final OptionViewHolder_plant_view holder, final int listPosition)
    {
        holder.bind(dataSet.get(listPosition));



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
