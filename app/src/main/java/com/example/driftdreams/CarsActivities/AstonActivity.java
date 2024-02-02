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

public class AstonActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<CarOverview> list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aston);
        recyclerView=findViewById(R.id.crecviewaston);
        list = new ArrayList<>();
//        list.add(new CarOverview(R.drawable.toyotatundra,"ASTON RAPIDE","$21,750","4.4"));
//        list.add(new CarOverview(R.drawable.toyotaavlon,"ASTON DBX","$22,560","4.1"));
//        list.add(new CarOverview(R.drawable.toyotapruis,"ASTON VALHALLA","$24,750","4.6"));
//        list.add(new CarOverview(R.drawable.toyotacamry,"ASTON VANTAGE","$23,950","4.6"));
//        list.add(new CarOverview(R.drawable.toyotacorolla,"ASTON DB11","$20,000","4.3"));
//        list.add(new CarOverview(R.drawable.toyotarav4,"ASTON LAGONDA","$23,450","4.5"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        CarOverviewAdapter adapter = new CarOverviewAdapter(list); // Assuming your adapter constructor takes a list of data
//        recyclerView.setAdapter(adapter);
    }
}