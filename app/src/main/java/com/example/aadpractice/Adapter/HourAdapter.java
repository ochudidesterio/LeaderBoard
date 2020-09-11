package com.example.aadpractice.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aadpractice.R;
import com.example.aadpractice.util.Hours;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.ViewHolder> {

   private List<Hours>mHoursList;
   private Context mContext;

    public HourAdapter(List<Hours> hoursList, Context context) {
        mHoursList = hoursList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_learner_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hours hoursItem = mHoursList.get(position);
        holder.textName.setText(hoursItem.getName());
        holder.textDescription.setText(hoursItem.getHours()+" learning hours, "+hoursItem.getCountry());
        Picasso.get().load(hoursItem.getBadgeUrl()).into(holder.topLearnerBagde);
    }

    @Override
    public int getItemCount() {
        return mHoursList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textName;
        public TextView textDescription;
        public ImageView topLearnerBagde;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName =(TextView)itemView.findViewById(R.id.learner_name);
            textDescription =(TextView)itemView.findViewById(R.id.learner_description);
            topLearnerBagde = (ImageView)itemView.findViewById(R.id.top_learner_badge);

        }
    }
}
