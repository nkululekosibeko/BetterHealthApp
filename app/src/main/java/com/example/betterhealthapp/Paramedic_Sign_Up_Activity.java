package com.example.betterhealthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Paramedic_Sign_Up_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_paramedic_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get references to the sign-in and sign-up buttons
        Button pmsignInButton = findViewById(R.id.PM_btn_Sign_In);

        // Set click listeners for the buttons
        pmsignInButton.setOnClickListener(v -> {
            // Start Sign-In Activity
            Intent pmsignInIntent = new Intent(Paramedic_Sign_Up_Activity.this, Sign_In_Activity.class);
            startActivity(pmsignInIntent);
        });
    }
}