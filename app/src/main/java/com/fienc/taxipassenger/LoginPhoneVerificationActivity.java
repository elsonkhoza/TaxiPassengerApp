package com.fienc.taxipassenger;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.UserInfo;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LoginPhoneVerificationActivity extends AppCompatActivity {


    private Button verifyBtn;
    TextInputEditText digit_1, digit_2, digit_3, digit_4, digit_5, digit_6;
    String code;

    private String phoneNumber;

    CircularProgressIndicator progressIndicator;

    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone_verification);
        Objects.requireNonNull(getSupportActionBar()).hide();
        initViews();


        FirebaseApp.initializeApp(this);
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(
                PlayIntegrityAppCheckProviderFactory.getInstance());

        mAuth = FirebaseAuth.getInstance();


        // Get number
        Intent intent = getIntent();
        if (intent != null) {
            phoneNumber = (String) intent.getExtras().get("phone-number");
            // Send verification code
           sendVerificationCode();
        }

    }

    private void initViews() {


        digit_1 = findViewById(R.id.digit_1_code_verify);
        digit_2 = findViewById(R.id.digit_2_code_verify);
        digit_3 = findViewById(R.id.digit_3_code_verify);
        digit_4 = findViewById(R.id.digit_4_code_verify);
        digit_5 = findViewById(R.id.digit_5_code_verify);
        digit_6 = findViewById(R.id.digit_6_code_verify);
        moveToNextCodeField();

        progressIndicator=findViewById(R.id.progress_circular_verify);
        progressIndicator.show();


        verifyBtn = findViewById(R.id.verify_btn_login);
        verifyBtn.setEnabled(false); // Button disabled
    }

    private void sendVerificationCode() {

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                @Override
                public void onVerificationCompleted(PhoneAuthCredential credential) {

                    String code = credential.getSmsCode();

                    if (code != null) {
                        digit_1.setText(code.charAt(0));
                        digit_2.setText(code.charAt(1));
                        digit_3.setText(code.charAt(2));
                        digit_4.setText(code.charAt(3));
                        digit_5.setText(code.charAt(4));
                        digit_6.setText(code.charAt(5));
                    }

                    signInWithPhoneAuthCredential(credential);
                }

                @Override
                public void onVerificationFailed(FirebaseException e) {

                    if (e instanceof FirebaseAuthInvalidCredentialsException) {

                    } else if (e instanceof FirebaseTooManyRequestsException) {

                    }
                }

                @Override
                public void onCodeSent(@NonNull String verificationId,
                                       @NonNull PhoneAuthProvider.ForceResendingToken token) {


                    ((TextView)findViewById(R.id.verify_heading_login))
                            .setText(getString(R.string.phone_verify));

                    ((TextView)findViewById(R.id.verify_login_text))
                            .setText(getString(R.string.code_was_sent));

                    progressIndicator.hide();


                   verifyBtn.setEnabled(true);
                    mVerificationId = verificationId;
                    mResendToken = token;
                }
            };


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = task.getResult().getUser();

                            Intent intent=new Intent(LoginPhoneVerificationActivity.this,
                                    MainActivity.class);
                            startActivity(intent);

                            // Update UI
                        } else {
                            // Sign in failed, display a message and update the UI
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(LoginPhoneVerificationActivity.this,
                                        "Failed, Invalid Code",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    public void onVerifyButtonClicked(View view) {


        Intent intent=new Intent(LoginPhoneVerificationActivity.this,
                MainActivity.class);
        startActivity(intent);

        // Line 72,155,195


        this.code=getCode();
        if(code.length()==6) {
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
            signInWithPhoneAuthCredential(credential);
        }
        else Toast.makeText(LoginPhoneVerificationActivity.this,
                "Enter the full code",Toast.LENGTH_SHORT).show();

    }

    private String getCode() {

        return digit_1.getText().toString() + digit_2.getText().toString()
                + digit_3.getText().toString() + digit_4.getText().toString()
                + digit_5.getText().toString() + digit_6.getText().toString();

    }

    private void moveToNextCodeField()
    {

        digit_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (digit_1.getText().toString().length()==1)
                    digit_2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        digit_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (digit_2.getText().toString().length()==1)
                    digit_3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        digit_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (digit_3.getText().toString().length()==1)
                    digit_4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        digit_4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (digit_4.getText().toString().length()==1)
                    digit_5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        digit_5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (digit_5.getText().toString().length()==1)
                    digit_6.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }



}