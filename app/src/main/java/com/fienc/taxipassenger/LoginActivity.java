package com.fienc.taxipassenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private Button nextBtn;
    private TextInputEditText phone;
    private CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();
        initViews();


    }

    private void initViews() {

        countryCodePicker=findViewById(R.id.country_code_picker_login);
        phone=findViewById(R.id.phone_input_login_value);
        // Country code validation
        countryCodePicker.registerCarrierNumberEditText(phone);

        nextBtn = findViewById(R.id.next_btn_login);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (countryCodePicker.isValidFullNumber()){
                Intent intent = new Intent(LoginActivity.this,
                        LoginPhoneVerificationActivity.class);

                String number=countryCodePicker.getFullNumberWithPlus();
                intent.putExtra("phone-number",number);
                startActivity(intent);
                }
                else {

                    phone.setError(getString(R.string.phone_error_msg));

                }
            }
        });


    }



}