package com.fienc.taxipassenger.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fienc.taxipassenger.R;
import com.fienc.taxipassenger.models.TravelHistory;

import java.util.ArrayList;


public class TravelHistoryAdapter extends RecyclerView.Adapter<TravelHistoryAdapter.RouteViewHolder> {

    private final ArrayList<TravelHistory> routes;
    private View.OnClickListener onClickListener;

    public TravelHistoryAdapter(View.OnClickListener onClickListener, ArrayList<TravelHistory> routes) {
        this.onClickListener = onClickListener;
        this.routes = routes;
    }

    public TravelHistoryAdapter(ArrayList<TravelHistory> routes) {
        this.routes = routes;
    }

    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.travel_history_card, parent, false);


        RouteViewHolder viewHolder = new RouteViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RouteViewHolder holder, int position) {

        TravelHistory route = routes.get(position);
        holder.setRoute(route);

        holder.itemView.setOnClickListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return routes.size();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public static class RouteViewHolder extends RecyclerView.ViewHolder {
        public TextView firstLoc,secLoc, price,date;
        public TravelHistory route;

        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.dates_history);
            firstLoc = itemView.findViewById(R.id.first_location_history);
            secLoc = itemView.findViewById(R.id.second_location_history);
            price = itemView.findViewById(R.id.route_price_history);

        }

        public void setRoute(TravelHistory route) {
            this.route = route;

            date.setText(route.getDate());
            firstLoc.setText(route.getFirstLocation().getName());
            secLoc.setText(route.getSecondLocation().getName());
            price.setText("R"+route.getCost());

        }
    }

}
