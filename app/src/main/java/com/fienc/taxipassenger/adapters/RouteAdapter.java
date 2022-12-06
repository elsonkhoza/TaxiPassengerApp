package com.fienc.taxipassenger.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fienc.taxipassenger.R;
import com.fienc.taxipassenger.models.RouteFare;

import java.util.ArrayList;


public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder> {

    private final ArrayList<RouteFare> routes;
    private View.OnClickListener onClickListener;

    public RouteAdapter(View.OnClickListener onClickListener, ArrayList<RouteFare> routes) {
        this.onClickListener = onClickListener;
        this.routes = routes;
    }

    public RouteAdapter(ArrayList<RouteFare> routes) {
        this.routes = routes;
    }

    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.route_fare_card, parent, false);


        RouteViewHolder viewHolder = new RouteViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RouteViewHolder holder, int position) {

        RouteFare route = routes.get(position);
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
        public TextView firstLoc,secLoc, price;
        public RouteFare route;

        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);

            firstLoc = itemView.findViewById(R.id.first_location);
            secLoc = itemView.findViewById(R.id.second_location);
            price = itemView.findViewById(R.id.route_price);
        }

        public void setRoute(RouteFare route) {
            this.route = route;

            firstLoc.setText(route.getFirstLocation().getName());
            secLoc.setText(route.getSecondLocation().getName());
            price.setText("R"+route.getCost());

        }
    }

}
