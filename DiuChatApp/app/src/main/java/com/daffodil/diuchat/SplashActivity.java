package com.daffodil.diuchat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth auth;  // Declare FirebaseAuth instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize FirebaseAuth
        auth = FirebaseAuth.getInstance();

        // Use new Handler with Looper.getMainLooper() for non-deprecated usage
        new android.os.Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if user is logged in
                if (auth.getCurrentUser() != null) {
                    // If logged in, navigate to MainActivity
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } else {
                    // If not logged in, navigate to LoginActivity
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                finish();  // Close SplashActivity
            }
        }, 1000);
    }
}
