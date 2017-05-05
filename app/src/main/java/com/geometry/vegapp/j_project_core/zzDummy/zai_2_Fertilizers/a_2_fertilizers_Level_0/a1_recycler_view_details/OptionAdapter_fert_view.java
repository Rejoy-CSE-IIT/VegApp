package com.geometry.vegapp.j_project_core.zzDummy.zai_2_Fertilizers.a_2_fertilizers_Level_0.a1_recycler_view_details;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geometry.vegapp.R;

import java.util.ArrayList;

public class OptionAdapter_fert_view extends RecyclerView.Adapter<OptionViewHolder_fert_view>
{

    private ArrayList<optionDataModel_fert_view> dataSet;
    Context ctx;



    public OptionAdapter_fert_view(ArrayList<optionDataModel_fert_view> data, Context ctx)
    {
        this.dataSet = data;
        this.ctx =ctx;
    }

    @Override
    public OptionViewHolder_fert_view onCreateViewHolder(ViewGroup parent,
                                                         int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bbc_seed_card, parent, false);



        OptionViewHolder_fert_view myViewHolder = new OptionViewHolder_fert_view(view,ctx);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final OptionViewHolder_fert_view holder, final int listPosition)
    {
        holder.bind(dataSet.get(listPosition));



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
