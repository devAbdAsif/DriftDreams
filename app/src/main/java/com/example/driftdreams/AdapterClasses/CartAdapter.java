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
import com.example.driftdreams.ModelClass.CartModel;
import com.example.driftdreams.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder> {

    ArrayList<CartModel> cartModels;
    Context context;

    public CartAdapter(ArrayList<CartModel> cartModels, Context context) {
        this.cartModels = cartModels;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
        return new CartAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.viewHolder holder, int position) {

        final CartModel cartModel = cartModels.get(position);

        holder.carname.setText(cartModel.getCarname());
        holder.carprice.setText(cartModel.getCarprice());
        holder.carrating.setText(cartModel.getCarrating());
        Glide.with(context.getApplicationContext()).load(cartModel.getImageurlcar()).into(holder.imgurlcar);

    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imgurlcar;
        TextView carname,carprice,carrating;
            public viewHolder(@NonNull View itemView) {
            super(itemView);

                imgurlcar=(itemView).findViewById(R.id.imgcart);
                carname=(itemView).findViewById(R.id.carnamecart);
                carprice=(itemView).findViewById(R.id.carpricecart);
                carrating=(itemView).findViewById(R.id.carratingcart);
        }
    }
}
