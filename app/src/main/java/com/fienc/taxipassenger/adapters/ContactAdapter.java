package com.fienc.taxipassenger.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fienc.taxipassenger.R;
import com.fienc.taxipassenger.models.Driver;


import java.util.ArrayList;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.RouteViewHolder> {

    private final ArrayList<Driver> routes;
    private View.OnClickListener onClickListener;

    public ContactAdapter(View.OnClickListener onClickListener, ArrayList<Driver> routes) {
        this.onClickListener = onClickListener;
        this.routes = routes;
    }

    public ContactAdapter(ArrayList<Driver> routes) {
        this.routes = routes;
    }

    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.contact_widget_card, parent, false);


        RouteViewHolder viewHolder = new RouteViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RouteViewHolder holder, int position) {

       Driver driver = routes.get(position);
       holder.setDriver(driver);


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
        public TextView name,location;
        public Driver driver;

        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.contact_name_list);
            location=itemView.findViewById(R.id.contact_location_list);

        }

        public void setDriver(Driver driver) {
          this.driver=driver;

           name.setText(driver.getName()+" "+driver.getSurname());
           location.setText(driver.getTaxiRank().getName());

        }
    }

}
