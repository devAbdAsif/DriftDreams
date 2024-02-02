package com.example.driftdreams.AdapterClasses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.driftdreams.CarsActivities.AstonActivity;
import com.example.driftdreams.CarsActivities.BMWActivity;
import com.example.driftdreams.CarsActivities.CarsBuyActivity;
import com.example.driftdreams.CarsActivities.HondaActivity;
import com.example.driftdreams.CarsActivities.KIAActivity;
import com.example.driftdreams.CarsActivities.SuzukiActivity;
import com.example.driftdreams.CarsActivities.ToyotaActivity;
import com.example.driftdreams.ModelClass.RecModel;
import com.example.driftdreams.NavigationActivity;
import com.example.driftdreams.R;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecViewHolder>{
    ArrayList<RecModel> models;
    Context context;

    public RecAdapter(ArrayList<RecModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview,parent,false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        final RecModel recModel = models.get(position);

        holder.carCompany.setText(recModel.getCompanybrand());
        Glide.with(context.getApplicationContext()).load(recModel.getImageUrl()).into(holder.carImg);
//        holder.carImg.setImageResource(recModel.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, CarsBuyActivity.class);
                intent.putExtra("categoryname",recModel.getCompanybrand());
                Toast.makeText(context, "Moved", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);

//                int id =recModel.getId();
//
//                if (id==0){
//                    Intent intent = new Intent(context, ToyotaActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                } else if (id == 1) {
//                    Intent intent = new Intent(context, HondaActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                } else if (id==2) {
//                    Intent intent = new Intent(context, SuzukiActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                } else if (id==3) {
//                    Intent intent = new Intent(context, AstonActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                } else if (id==4) {
//                    Intent intent = new Intent(context, KIAActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }else{
//                    Intent intent = new Intent(context, BMWActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {
        ImageView carImg;
        TextView carCompany;
        public RecViewHolder(@NonNull View itemView) {
            super(itemView);

            carImg = itemView.findViewById(R.id.cimgcar);
            carCompany = itemView.findViewById(R.id.cheadcompany);
        }
    }
}
