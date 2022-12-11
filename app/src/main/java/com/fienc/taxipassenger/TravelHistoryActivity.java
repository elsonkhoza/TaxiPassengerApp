package com.fienc.taxipassenger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fienc.taxipassenger.adapters.SpaceDecoration;
import com.fienc.taxipassenger.adapters.TravelHistoryAdapter;
import com.fienc.taxipassenger.models.Driver;
import com.fienc.taxipassenger.models.Location;
import com.fienc.taxipassenger.models.Taxi;
import com.fienc.taxipassenger.models.TravelHistory;

import java.util.ArrayList;


public class TravelHistoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TravelHistoryAdapter routeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_history);

      //  getSupportActionBar().setTitle(getString(R.string.history));

        recyclerView = findViewById(R.id.recycler_view_history);
        ArrayList<TravelHistory> list = loadRoutes();

        routeAdapter = new TravelHistoryAdapter(list);


        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getApplicationContext());


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(routeAdapter);
        recyclerView.addItemDecoration(new SpaceDecoration(5));
    }

    private ArrayList<TravelHistory> loadRoutes() {


        ArrayList<TravelHistory> list = new ArrayList<>();

        list.add(new TravelHistory("Mon, 12 Nov 2022", 23,
                new Location("Thulamahashe", "54fd"),
                new Location("Hazyview", ""), new Taxi(), new Driver()));

        list.add(new TravelHistory("Mon, 12 Nov 2022", 23,
                new Location("Thulamahashe", "54fd"),
                new Location("Hazyview", ""), new Taxi(), new Driver()));

        list.add(new TravelHistory("Mon, 12 Nov 2022", 23,
                new Location("Thulamahashe", "54fd"),
                new Location("Hazyview", ""), new Taxi(), new Driver()));

        list.add(new TravelHistory("Mon, 12 Nov 2022", 23,
                new Location("Thulamahashe", "54fd"),
                new Location("Hazyview", ""), new Taxi(), new Driver()));

        list.add(new TravelHistory("Mon, 12 Nov 2022", 23,
                new Location("Thulamahashe", "54fd"),
                new Location("Hazyview", ""), new Taxi(), new Driver()));

        list.add(new TravelHistory("Mon, 12 Nov 2022", 23,
                new Location("Thulamahashe", "54fd"),
                new Location("Hazyview", ""), new Taxi(), new Driver()));

        list.add(new TravelHistory("Mon, 12 Nov 2022", 23,
                new Location("Thulamahashe", "54fd"),
                new Location("Hazyview", ""), new Taxi(), new Driver()));

        list.add(new TravelHistory("Mon, 12 Nov 2022", 23,
                new Location("Thulamahashe", "54fd"),
                new Location("Hazyview", ""), new Taxi(), new Driver()));

        list.add(new TravelHistory("Mon, 12 Nov 2022", 23,
                new Location("Thulamahashe", "54fd"),
                new Location("Hazyview", ""), new Taxi(), new Driver()));


        return list;
    }
}