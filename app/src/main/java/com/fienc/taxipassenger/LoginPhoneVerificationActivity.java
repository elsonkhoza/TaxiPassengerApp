package com.fienc.taxipassenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class LoginPhoneVerificationActivity extends AppCompatActivity {


    Button verifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone_verification);
        Objects.requireNonNull(getSupportActionBar()).hide();


        verifyBtn = findViewById(R.id.verify_btn_login);
        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginPhoneVerificationActivity.this,
                        RegisterNamesActivity.class);
                startActivity(intent);
            }
        });
    }
}