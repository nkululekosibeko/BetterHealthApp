package com.example.betterhealthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Student_Sign_Up_Activity extends AppCompatActivity {

    Database_Helper myDb;

    EditText studentNo_Sign_Up_TextEdit, program_Major_Sign_Up_TextEdit, LevelOfStudy_Sign_Up_TextEdit,
            faculty_Sign_Up_TextEdit, department_Sign_Up_TextEdit, emergencyRelationship_Sign_Up_TextEdit,
            emergencyFllNames_Sign_Up_TextEdit, emergencyContact_Sign_Up_TextEdit, allergies_Sign_Up_TextEdit,
            Medication_Sign_Up_TextEdit, InsuaranceProviderName_Sign_Up_TextEdit, PolicyNumber_Sign_Up_TextEdit,
            CovarageDetails_Sign_Up_TextEdit, RessName_Sign_Up_TextEdit, Address_Sign_Up_TextEdit, RoomNumber_Sign_Up_TextEdit;

    Button std_btn_Sign_Up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            myDb = new Database_Helper(this);

            studentNo_Sign_Up_TextEdit = findViewById(R.id.studentNo_Sign_Up_TextEdit);
            program_Major_Sign_Up_TextEdit = findViewById(R.id.program_Major_Sign_Up_TextEdit);
            LevelOfStudy_Sign_Up_TextEdit = findViewById(R.id.LevelOfStudy_Sign_Up_TextEdit);
            faculty_Sign_Up_TextEdit = findViewById(R.id.faculty_Sign_Up_TextEdit);
            department_Sign_Up_TextEdit = findViewById(R.id.department_Sign_Up_TextEdit);

            emergencyRelationship_Sign_Up_TextEdit = findViewById(R.id.emergencyRelationship_Sign_Up_TextEdit);
            emergencyFllNames_Sign_Up_TextEdit = findViewById(R.id.emergencyFllNames_Sign_Up_TextEdit);
            emergencyContact_Sign_Up_TextEdit = findViewById(R.id.emergencyContact_Sign_Up_TextEdit);

            allergies_Sign_Up_TextEdit = findViewById(R.id.allergies_Sign_Up_TextEdit);
            Medication_Sign_Up_TextEdit = findViewById(R.id.Medication_Sign_Up_TextEdit);

            InsuaranceProviderName_Sign_Up_TextEdit = findViewById(R.id.InsuaranceProviderName_Sign_Up_TextEdit);
            PolicyNumber_Sign_Up_TextEdit = findViewById(R.id.PolicyNumber_Sign_Up_TextEdit);
            CovarageDetails_Sign_Up_TextEdit = findViewById(R.id.CovarageDetails_Sign_Up_TextEdit);

            RessName_Sign_Up_TextEdit = findViewById(R.id.RessName_Sign_Up_TextEdit);
            Address_Sign_Up_TextEdit = findViewById(R.id.Address_Sign_Up_TextEdit);
            RoomNumber_Sign_Up_TextEdit = findViewById(R.id.RoomNumber_Sign_Up_TextEdit);

            std_btn_Sign_Up = findViewById(R.id.std_btn_Sign_Up);

            // Set click listener for the button
            std_btn_Sign_Up.setOnClickListener(v1 -> {
                // Add data to database
                AddData();

                // Start Sign In  Activity for the Student
                Intent stdsignInIntent = new Intent(Student_Sign_Up_Activity.this, Sign_In_Activity.class);
                startActivity(stdsignInIntent);
            });

            return insets;
        });
    }

    public void AddData() {
        boolean isInserted = myDb.insertData(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                studentNo_Sign_Up_TextEdit.getText().toString(),
                program_Major_Sign_Up_TextEdit.getText().toString(),
                LevelOfStudy_Sign_Up_TextEdit.getText().toString(),
                faculty_Sign_Up_TextEdit.getText().toString(),
                department_Sign_Up_TextEdit.getText().toString(),
                emergencyRelationship_Sign_Up_TextEdit.getText().toString(),
                emergencyFllNames_Sign_Up_TextEdit.getText().toString(),
                emergencyContact_Sign_Up_TextEdit.getText().toString(),
                allergies_Sign_Up_TextEdit.getText().toString(),
                Medication_Sign_Up_TextEdit.getText().toString(),
                InsuaranceProviderName_Sign_Up_TextEdit.getText().toString(),
                PolicyNumber_Sign_Up_TextEdit.getText().toString(),
                CovarageDetails_Sign_Up_TextEdit.getText().toString(),
                RessName_Sign_Up_TextEdit.getText().toString(),
                Address_Sign_Up_TextEdit.getText().toString(),
                RoomNumber_Sign_Up_TextEdit.getText().toString());

        if (isInserted)
            Toast.makeText(Student_Sign_Up_Activity.this, "Data Capture Successful", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Student_Sign_Up_Activity.this, "Data Capture Unsuccessful", Toast.LENGTH_SHORT).show();
    }
}
