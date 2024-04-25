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

public class Common_Info_SignUP_Activity extends AppCompatActivity {

    Database_Helper myDb;

    EditText fName_Sign_Up_TextEdit, mName_Sign_Up_TextEdit, lName_Sign_Up_TextEdit,
            DOB_Sign_Up_TextEdit, IDNum_Sign_Up_TextEdit, Gender_Sign_Up_TextEdit, studentNo_Sign_Up_TextEdit,
            ContactNum_Sign_Up_TextEdit, email_Sign_Up_TextEdit, password_Sign_Up_TextEdit;

    Button Next_btn_Sign_Up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_common_info_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            myDb = new Database_Helper(this);

            fName_Sign_Up_TextEdit = findViewById(R.id.fName_Sign_Up_TextEdit);
            mName_Sign_Up_TextEdit = findViewById(R.id.mName_Sign_Up_TextEdit);
            lName_Sign_Up_TextEdit = findViewById(R.id.lName_Sign_Up_TextEdit);
            DOB_Sign_Up_TextEdit = findViewById(R.id.DOB_Sign_Up_TextEdit);
            IDNum_Sign_Up_TextEdit = findViewById(R.id.IDNum_Sign_Up_TextEdit);
            Gender_Sign_Up_TextEdit = findViewById(R.id.Gender_Sign_Up_TextEdit);
            ContactNum_Sign_Up_TextEdit = findViewById(R.id.ContactNum_Sign_Up_TextEdit);
            email_Sign_Up_TextEdit = findViewById(R.id.email_Sign_Up_TextEdit);
            password_Sign_Up_TextEdit = findViewById(R.id.password_Sign_Up_TextEdit);

            Next_btn_Sign_Up = findViewById(R.id.Next_btn_Sign_Up);

            // Set click listener for the Next button
            Next_btn_Sign_Up.setOnClickListener(v1 -> {
                // Add data to database
                AddData();

                // Start User Type Activity
                Intent signUPNextIntent = new Intent(Common_Info_SignUP_Activity.this, User_Type_Picker_Activity.class);
                startActivity(signUPNextIntent);
            });

            return insets;
        });
    }


    public void AddData() {
        boolean isInserted = myDb.insertData(
                fName_Sign_Up_TextEdit.getText().toString(),
                mName_Sign_Up_TextEdit.getText().toString(),
                lName_Sign_Up_TextEdit.getText().toString(),
                DOB_Sign_Up_TextEdit.getText().toString(),
                IDNum_Sign_Up_TextEdit.getText().toString(),
                Gender_Sign_Up_TextEdit.getText().toString(),
                ContactNum_Sign_Up_TextEdit.getText().toString(),
                email_Sign_Up_TextEdit.getText().toString(),
                password_Sign_Up_TextEdit.getText().toString(),
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "");

        if (isInserted)
            Toast.makeText(Common_Info_SignUP_Activity.this, "Data Capture Successful", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Common_Info_SignUP_Activity.this, "Data Capture Unsuccessful", Toast.LENGTH_SHORT).show();
    }

}
