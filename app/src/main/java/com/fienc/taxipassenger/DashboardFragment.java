package com.fienc.taxipassenger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;


public class DashboardFragment extends Fragment {

    View view;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        dashboardCardViews();

        return view;
    }

    private void dashboardCardViews() {
        MaterialCardView travel, fares, messages, history;


        fares = view.findViewById(R.id.faresCardView);
        fares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent intent=new Intent(getContext(),FaresActivity.class);
                //   startActivity(intent);
            }
        });
        history = view.findViewById(R.id.historyCardView);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent=new Intent(getContext(),TravelHistoryActivity.class);
                // startActivity(intent);
            }
        });
    }

}