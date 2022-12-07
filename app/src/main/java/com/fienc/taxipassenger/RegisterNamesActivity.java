package com.fienc.taxipassenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;


public class RegisterNamesActivity extends AppCompatActivity {


    Button signupBtn;
    TextInputEditText name, surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_names);
        Objects.requireNonNull(getSupportActionBar()).hide();
        initViews();


    }

    private void initViews() {
        name = findViewById(R.id.name_signup_vale);
        surname = findViewById(R.id.surname_signup_vale);
        signupBtn = findViewById(R.id.signup_btn_login);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterNamesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}