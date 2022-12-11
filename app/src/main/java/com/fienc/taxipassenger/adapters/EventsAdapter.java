package com.fienc.taxipassenger.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fienc.taxipassenger.R;
import com.fienc.taxipassenger.models.Event;


import java.util.ArrayList;


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.RouteViewHolder> {

    private final ArrayList<Event> events;
    private View.OnClickListener onClickListener;

    public EventsAdapter(View.OnClickListener onClickListener, ArrayList<Event> events) {
        this.onClickListener = onClickListener;
        this.events=events;
    }

    public EventsAdapter(ArrayList<Event> events) {
        this.events=events;
    }

    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.event_widget, parent, false);


        RouteViewHolder viewHolder = new RouteViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RouteViewHolder holder, int position) {

        Event event=events.get(position);
       holder.setEvent(event);


        holder.itemView.setOnClickListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public static class RouteViewHolder extends RecyclerView.ViewHolder {
        public TextView date,name,location;
        public Event event;

        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.event_time_date_list);
            name=itemView.findViewById(R.id.event_name_list);
            location=itemView.findViewById(R.id.event_location_list);

        }

        public void setEvent(Event event) {
          this.event=event;

           date.setText(event.getDate()+","+event.getTime());
           name.setText(event.getName());
           location.setText(event.getLocation().getName());
        }
    }

}
