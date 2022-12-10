package com.fienc.taxipassenger;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fienc.taxipassenger.adapters.RouteAdapter;
import com.fienc.taxipassenger.adapters.SpaceDecoration;
import com.fienc.taxipassenger.models.Location;
import com.fienc.taxipassenger.models.RouteFare;

import java.util.ArrayList;


public class FaresActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RouteAdapter routeAdapter;

    SearchView fromSearch,toSearch;
    ConstraintLayout toSearchLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fares);
        getSupportActionBar().setTitle(getString(R.string.fare));

        recyclerView = findViewById(R.id.recycler_view);
        routeAdapter = new RouteAdapter(loadRoutes());


        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getApplicationContext());


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(routeAdapter);
        recyclerView.addItemDecoration(new SpaceDecoration(5));

    }


    private void initViews()
    {
        fromSearch=findViewById(R.id.from_search_view_fares);
        toSearchLayout=findViewById(R.id.to_search_layout_fares);

        toSearchLayout.setVisibility(View.VISIBLE);


        toSearch=findViewById(R.id.to_search_view_fares);
    }

    private ArrayList<RouteFare> loadRoutes() {


        ArrayList<RouteFare> list = new ArrayList<>();

        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));
        list.add(new RouteFare("khjvfb", new Location("Ximhungwe", "jjvf"),
                new Location("Thulamahashe", "hghdgd"), 24));


        return list;
    }
}