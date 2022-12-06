package com.fienc.taxipassenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fienc.taxipassenger.models.Passenger;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;


public class RegisterActivity extends AppCompatActivity {

    private String name, surname,
            email, phone, password;
    private Button registerBtn;
    private Passenger passenger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Objects.requireNonNull(getSupportActionBar()).hide();

        iniViews();


        Intent getIntent = getIntent();
        name = (String) getIntent.getExtras().get("name");
        surname = (String) getIntent.getExtras().get("surname");


        passenger = new Passenger(name, surname, email, phone);


    }

    private void iniViews() {

        email = ((TextInputEditText) findViewById(R.id.email_new_value)).getText().toString();
        phone = ((TextInputEditText) findViewById(R.id.phone_new_value)).getText().toString();
        password = ((TextInputEditText) findViewById(R.id.password_new_value)).getText().toString();

        registerBtn = findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.putExtra("passenger", passenger);
                startActivity(intent);

            }
        });


    }

}