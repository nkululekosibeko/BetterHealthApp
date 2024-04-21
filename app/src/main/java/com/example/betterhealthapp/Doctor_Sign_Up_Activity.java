package com.example.betterhealthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Doctor_Sign_Up_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get references to the sign-in and sign-up buttons
        Button docsignInButton = findViewById(R.id.Doc_btn_Sign_In);

        // Set click listeners for the buttons
        docsignInButton.setOnClickListener(v -> {
            // Start Sign-In Activity
            Intent docsignInIntent = new Intent(Doctor_Sign_Up_Activity.this, Sign_In_Activity.class);
            startActivity(docsignInIntent);
        });
    }
}