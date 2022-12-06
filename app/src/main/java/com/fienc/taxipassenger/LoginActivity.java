package com.fienc.taxipassenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private Button loginBtn;
    private TextInputEditText email, password;
    private TextView forgotPassword,registerNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();
        iniViews();
    }


    private void iniViews()
    {

        email=findViewById(R.id.email_value_login);
        password=findViewById(R.id.password_value_login);

        loginBtn=findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });


        forgotPassword=findViewById(R.id.forgot_pass);
        registerNew=findViewById(R.id.register_new);
        registerNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Intent intent=new Intent(LoginActivity.this,RegisterNamesActivity.class);
             //   startActivity(intent);

            }
        });
    }


}