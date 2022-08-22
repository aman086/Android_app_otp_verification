package com.example.hojabhai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

public class MainActivity2 extends AppCompatActivity {

    private EditText e1,e2,e3,e4,e5,e6;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button verify = findViewById(R.id.btnVerify);
        e1 = findViewById(R.id.etC1);
        e2 = findViewById(R.id.etC2);
        e3 = findViewById(R.id.etC3);
        e4 = findViewById(R.id.etC4);
        e5 = findViewById(R.id.etC5);
        e6 = findViewById(R.id.etC6);
        TextView tvMobile = findViewById(R.id.tvMobile);

        editTextInput();

        tvMobile.setText(String.format(
                "+91-%s", getIntent().getStringExtra("mobile")
        ));

        value = getIntent().getStringExtra("otp");

    }

    private void editTextInput() {

        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e6.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

//    }


    public void verification(View view){

        String check = e1.getText().toString().trim() +
                e2.getText().toString().trim() +
                e3.getText().toString().trim() +
                e4.getText().toString().trim() +
                e5.getText().toString().trim() +
                e6.getText().toString().trim();

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(value, check);
        FirebaseAuth
                .getInstance()
                .signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
//                            binding.progressBarVerify.setVisibility(View.VISIBLE);
//                            btnVerify.setVisibility(View.INVISIBLE);
                            Toast.makeText(MainActivity2.this, "Welcome...", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } else {
//                            binding.progressBarVerify.setVisibility(View.GONE);
//                            binding.btnVerify.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity2.this, "OTP is not Valid!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}