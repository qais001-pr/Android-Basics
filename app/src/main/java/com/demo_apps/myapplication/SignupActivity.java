package com.demo_apps.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

public class SignupActivity extends ComponentActivity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {

            Toast.makeText(
                    SignupActivity.this,
                    "Login button clicked",
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent = new Intent(
                    SignupActivity.this,
                    Login.class
            );

            startActivity(intent);
        });
    }
}