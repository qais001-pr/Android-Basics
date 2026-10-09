package com.demo_apps.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

public class Login extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Button signup = findViewById(R.id.btnSignup);

        signup.setOnClickListener(v -> {

            Toast.makeText(
                    Login.this,
                    "Signup button clicked",
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent = new Intent(
                    Login.this,
                    SignupActivity.class
            );

            startActivity(intent);
        });
    }
}