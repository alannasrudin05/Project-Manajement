package com.praktikum.projectmanajer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.praktikum.projectmanajer.Model.TeamModel;
import com.praktikum.projectmanajer.R;

import java.util.ArrayList;

public class MyTeamAdapter extends RecyclerView.Adapter<MyTeamAdapter.Viewholder> {
    private ArrayList<TeamModel> items;
    private Context context;

    public MyTeamAdapter(ArrayList<TeamModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyTeamAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflator = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_team,parent,false);
        return new Viewholder(inflator);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTeamAdapter.Viewholder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.status.setText(items.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView title, status;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleTxt);
            status=itemView.findViewById(R.id.statusTxt);
        }
    }
}
