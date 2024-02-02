package com.example.driftdreams.CarsActivities;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.driftdreams.AdapterClasses.CarOverviewAdapter;
import com.example.driftdreams.AdapterClasses.RecAdapter;
import com.example.driftdreams.ModelClass.CarOverview;
import com.example.driftdreams.ModelClass.RecModel;
import com.example.driftdreams.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CarsBuyActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<CarOverview> list;
    String CarCategoryBrand;
    CarOverviewAdapter adapter;

    // text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_buy);
        //text=findViewById(R.id.catid);
        CarCategoryBrand=getIntent().getStringExtra("categoryname");
       // text.setText(getIntent().getStringExtra("categoryname"));
        fetchcars();
    }

    private void fetchcars() {
    recyclerView=findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        adapter= new CarOverviewAdapter(list,getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference reference=firebaseDatabase.getReference("Added Cars").child(CarCategoryBrand);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                if(snapshot.exists()){
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        CarOverview carModel=dataSnapshot.getValue(CarOverview.class);
                        list.add(carModel);
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