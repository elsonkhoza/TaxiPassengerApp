package com.fienc.taxipassenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;


public class RegisterNamesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_names);
        Objects.requireNonNull(getSupportActionBar()).hide();

        TextInputEditText name = findViewById(R.id.name_new_value);
        TextInputEditText surname = findViewById(R.id.surname_new_value);
        Button continueBtn = findViewById(R.id.continue_reg);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterNamesActivity.this,
                        RegisterActivity.class);

                intent.putExtra("name",name.getText().toString());
                intent.putExtra("surname",surname.getText().toString());

                startActivity(intent);

            }
        });


    }
}