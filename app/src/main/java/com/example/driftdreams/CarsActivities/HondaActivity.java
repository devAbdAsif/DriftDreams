package com.example.driftdreams.CarsActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.driftdreams.AdapterClasses.CarOverviewAdapter;
import com.example.driftdreams.ModelClass.CarOverview;
import com.example.driftdreams.R;

import java.util.ArrayList;
import java.util.List;

public class HondaActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<CarOverview> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honda);

        recyclerView=findViewById(R.id.crecviewhonda);
        list = new ArrayList<>();
//        list.add(new CarOverview(R.drawable.hondacivic,"HONDA CIVIC","$23,950","4.5"));
//        list.add(new CarOverview(R.drawable.hondacity,"HONDA CITY","$20,000","4.4"));
//        list.add(new CarOverview(R.drawable.hondafit,"HONDA FIT","$23,450","4.3"));
//        list.add(new CarOverview(R.drawable.hondahrv,"HONDA HR-V","$21,750","4.2"));
//        list.add(new CarOverview(R.drawable.hondacrv,"HONDA CR-V","$22,560","4.1"));
//        list.add(new CarOverview(R.drawable.hondapilot,"HONDA PILOT","$24,750","4.6"));

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        CarOverviewAdapter adapter = new CarOverviewAdapter(list); // Assuming your adapter constructor takes a list of data
//        recyclerView.setAdapter(adapter);


    }
}