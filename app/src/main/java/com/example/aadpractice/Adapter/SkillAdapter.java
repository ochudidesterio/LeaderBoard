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
import com.example.aadpractice.util.IQ;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {
    private List<IQ>mIQList;
    private Context mContext;

    public SkillAdapter(List<IQ> IQList, Context context) {
        mIQList = IQList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_skill_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IQ iqItems = mIQList.get(position);
        holder.topSkillName.setText(iqItems.getName());
        holder.topSkillDescription.setText(iqItems.getScore()+" score, "+iqItems.getCountry());
        Picasso.get().load(iqItems.getBadgeUrl()).into(holder.topSkillBadge);
    }

    @Override
    public int getItemCount() {
        return mIQList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView topSkillName;
        private TextView topSkillDescription;
        private ImageView topSkillBadge;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topSkillName = (TextView)itemView.findViewById(R.id.topskill_name);
            topSkillDescription=(TextView)itemView.findViewById(R.id.topskill_description);
            topSkillBadge =(ImageView)itemView.findViewById(R.id.top_skill_badge);
        }
    }
}
