package com.example.betterhealthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get references to the sign-in and sign-up buttons
        Button signInButton = findViewById(R.id.Landing_btn_Sign_In);
        Button signUpButton = findViewById(R.id.Landing_btn_Sign_Up);

        // Set click listeners for the buttons
        signInButton.setOnClickListener(v -> {
            // Start Sign-In Activity
            Intent signInIntent = new Intent(MainActivity.this, Sign_In_Activity.class);
            startActivity(signInIntent);
        });

        signUpButton.setOnClickListener(v -> {
            // Start Sign-Up Activity
            Intent signUpIntent = new Intent(MainActivity.this, Common_Info_SignUP_Activity.class);
            startActivity(signUpIntent);
        });
    }
}