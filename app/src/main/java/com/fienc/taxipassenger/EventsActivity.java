package com.fienc.taxipassenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fienc.taxipassenger.adapters.EventsAdapter;
import com.fienc.taxipassenger.adapters.SpaceDecoration;
import com.fienc.taxipassenger.models.Event;
import com.fienc.taxipassenger.models.Location;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    EventsAdapter eventsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        setUpRecyclerView();
    }

    private void setUpRecyclerView()
    {
        recyclerView=findViewById(R.id.events_recycler_view);
        eventsAdapter=new EventsAdapter(loadEvents());

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setAdapter(eventsAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SpaceDecoration(5));
    }

    private ArrayList<Event> loadEvents() {

        ArrayList<Event> events=new ArrayList<>();
        events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));
         events.add(new Event("Beta Hall",new Location("Hazyview",""),"",
                "","Mon, 26 Nov 2022","19:00","Caiiro's Birthday"));

        return events;
    }
}