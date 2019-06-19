package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Spot;

import java.util.List;

public class SpotListAdapter extends RecyclerView.Adapter<SpotListAdapter.MyViewHolder> {

    private List<Spot> spots;

    public SpotListAdapter(List<Spot> spots) {
        this.spots = spots;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.spot_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(spots.get(position).getId()+"");
        holder.name.setText(spots.get(position).getName());
        holder.latiude.setText(spots.get(position).getLatitude() + "");
        holder.longitude.setText(spots.get(position).getLongitude() + "");
        holder.desc.setText(spots.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return spots.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView id, name, latiude, longitude, desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            latiude = itemView.findViewById(R.id.latitude);
            longitude = itemView.findViewById(R.id.longitude);
            desc = itemView.findViewById(R.id.desc);

        }
    }
}
