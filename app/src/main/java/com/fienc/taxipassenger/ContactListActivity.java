package com.fienc.taxipassenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fienc.taxipassenger.adapters.ContactAdapter;
import com.fienc.taxipassenger.adapters.RouteAdapter;
import com.fienc.taxipassenger.adapters.SpaceDecoration;
import com.fienc.taxipassenger.models.Driver;
import com.fienc.taxipassenger.models.Location;
import com.fienc.taxipassenger.models.RouteFare;

import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);


        recyclerView = findViewById(R.id.recycler_view_contact_list);
       contactAdapter=new ContactAdapter(loadContacts());


        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getApplicationContext());


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.addItemDecoration(new SpaceDecoration(5));
    }

    private ArrayList<Driver> loadContacts() {

        ArrayList<Driver> list=new ArrayList<>();

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        list.add(new Driver("Vuyo","Malema","Taxi Driver","0721395664",
                new Location("Ximnhugwe Taxi Rank","")));

        return list;
    }
}