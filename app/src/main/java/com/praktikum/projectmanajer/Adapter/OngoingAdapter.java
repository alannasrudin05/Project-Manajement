package com.praktikum.projectmanajer.Adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.praktikum.projectmanajer.Model.OngoingModel;
import com.praktikum.projectmanajer.R;

import java.util.ArrayList;

public class OngoingAdapter extends RecyclerView.Adapter<OngoingAdapter.Viewholder> {
    private ArrayList<OngoingModel> items;
    private Context context;
    private OnItemClickListener listener;

    public OngoingAdapter(ArrayList<OngoingModel> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OngoingAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflator = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_ongoing,parent,false);
        return new Viewholder(inflator);
    }

    @Override
    public void onBindViewHolder(@NonNull OngoingAdapter.Viewholder holder, int position) {

        OngoingModel item = items.get(position);

        holder.title.setText(items.get(position).getTitle());
        holder.date.setText(items.get(position).getDate());
        holder.progressBarPercent.setText(items.get(position).getProgressPercent()+"%");

        int drawableResource=holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(),"drawable", context.getPackageName());

        Glide.with(context)
                .load(drawableResource)
                .into(holder.pic);

        holder.progressBar.setProgress(items.get(position).getProgressPercent());

        if (position==0){
            holder.layout.setBackgroundResource(R.drawable.dark_background);
            holder.title.setTextColor(context.getColor(R.color.white));
            holder.date.setTextColor(context.getColor(R.color.white));
            holder.progressTxt.setTextColor(context.getColor(R.color.white));
            holder.progressBarPercent.setTextColor(context.getColor(R.color.white));
            holder.pic.setColorFilter (ContextCompat.getColor(context,R.color.white), PorterDuff.Mode.SRC_IN);
            holder.progressBar.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(context,R.color.white)));
        }else {
            holder.layout.setBackgroundResource(R.drawable.light_background);
            holder.title.setTextColor(context.getColor(R.color.dark_blue));
            holder.date.setTextColor(context.getColor(R.color.dark_blue));
            holder.progressTxt.setTextColor(context.getColor(R.color.dark_blue));
            holder.progressBarPercent.setTextColor(context.getColor(R.color.dark_blue));
            holder.pic.setColorFilter (ContextCompat.getColor(context,R.color.dark_blue), PorterDuff.Mode.SRC_IN);
            holder.progressBar.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(context,R.color.dark_blue)));
        }

        holder.itemView.setOnClickListener(v -> listener.onItemClick(item));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView title, date, progressBarPercent, progressTxt;
        ProgressBar progressBar;
        ImageView pic;
        ConstraintLayout layout;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.layout);
            progressTxt=itemView.findViewById(R.id.progressTxt);
            title=itemView.findViewById(R.id.titleTxt);
            date=itemView.findViewById(R.id.dateTxt);
            progressBar=itemView.findViewById(R.id.progressBar);
            progressBarPercent=itemView.findViewById(R.id.percentTxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
