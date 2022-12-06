package com.fienc.taxipassenger;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniViews();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new DashboardFragment()).commit();
        getSupportActionBar().setTitle(getString(R.string.dashboard));


    }


    private void iniViews() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.profile_menu: {
                        selectedFragment = new ProfileFragment();
                        getSupportActionBar().setTitle(getString(R.string.profile));

                        break;
                    }
                    case R.id.dashboard_menu:
                        _menu:
                        {
                            selectedFragment = new DashboardFragment();
                            getSupportActionBar().setTitle(getString(R.string.dashboard));

                            break;
                        }
                    case R.id.settings_menu:
                        _menu:
                        {
                            selectedFragment = new SettingsFragment();
                            getSupportActionBar().setTitle(getString(R.string.settings));
                            break;
                        }

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
                return true;
            }
        });
    }


}