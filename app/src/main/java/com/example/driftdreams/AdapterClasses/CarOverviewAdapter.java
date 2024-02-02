package com.example.driftdreams.AdapterClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.driftdreams.ModelClass.CarOverview;
import com.example.driftdreams.R;

import java.util.ArrayList;

public class CarOverviewAdapter extends RecyclerView.Adapter<CarOverviewAdapter.OverViewHolder>{

    ArrayList<CarOverview> carOverviews;

    Context context;

    public CarOverviewAdapter(ArrayList<CarOverview> carOverviews, Context context) {
        this.carOverviews = carOverviews;
        this.context = context;
    }

    @NonNull
    @Override
    public OverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_overview,parent,false);
        return new CarOverviewAdapter.OverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OverViewHolder holder, int position) {
        final CarOverview carOverview = carOverviews.get(position);

        holder.carname.setText(carOverview.getCarname());
        holder.carprice.setText(carOverview.getCarprice());
        holder.carrating.setText(carOverview.getCarrating());
        Glide.with(context.getApplicationContext()).load(carOverview.getImageurlcar()).into(holder.imgurlcar);
    }

    @Override
    public int getItemCount() {
        return carOverviews.size();
    }

    public class OverViewHolder extends RecyclerView.ViewHolder{

        ImageView imgurlcar;
        TextView carname,carprice,carrating;
        public OverViewHolder(@NonNull View itemView) {
            super(itemView);
            imgurlcar=(itemView).findViewById(R.id.imgcar);
            carname=(itemView).findViewById(R.id.carname);
            carprice=(itemView).findViewById(R.id.carprice);
            carrating=(itemView).findViewById(R.id.carrating);

        }
    }
}
