package com.example.driftdreams;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.driftdreams.AdapterClasses.RecAdapter;
import com.example.driftdreams.ModelClass.RecModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class HomeFragment extends Fragment {

ImageSlider imageSlider;
RecyclerView recyclerView;
private RecAdapter adapter;
    ArrayList<RecModel> list;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider= view.findViewById(R.id.imgslider);
        recyclerView=view.findViewById(R.id.recView);
        ArrayList<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.lamborgini, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.rollroyce, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.porche, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.mercdes, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.aston, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        RecViewWork();
        return view;

           }


    private void RecViewWork() {
    list = new ArrayList<>();
        adapter= new RecAdapter(list,getContext());
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayout= new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayout);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference= firebaseDatabase.getReference("Categories")
                .child("cars");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                if(snapshot.exists()){
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        RecModel recModel=dataSnapshot.getValue(RecModel.class);
                        list.add(recModel);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






    }


}











