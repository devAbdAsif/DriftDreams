package com.example.driftdreams.CarsActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.driftdreams.AdapterClasses.CarOverviewAdapter;
import com.example.driftdreams.ModelClass.CarOverview;
import com.example.driftdreams.R;

import java.util.ArrayList;

public class ToyotaActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<CarOverview> list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyota);
        recyclerView=findViewById(R.id.crecviewtoyota);
        list = new ArrayList<>();
//        list.add(new CarOverview(R.drawable.toyotacamry,"TOYOTA CAMRY","$23,950","4.6"));
//        list.add(new CarOverview(R.drawable.toyotacorolla,"TOYOTA COROLLA","$20,000","4.3"));
//        list.add(new CarOverview(R.drawable.toyotarav4,"TOYOTA RAV4","$23,450","4.5"));
//        list.add(new CarOverview(R.drawable.toyotatundra,"TOYOTA TUNDRA","$21,750","4.4"));
//        list.add(new CarOverview(R.drawable.toyotaavlon,"TOYOTA AVALON","$22,560","4.1"));
//        list.add(new CarOverview(R.drawable.toyotapruis,"TOYOTA PRUIS","$24,750","4.6"));

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        CarOverviewAdapter adapter = new CarOverviewAdapter(list); // Assuming your adapter constructor takes a list of data
//        recyclerView.setAdapter(adapter);

    }
}