package com.example.betterhealthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_Helper extends SQLiteOpenHelper {

    // Common_Info table columns
    public static final String DATABASE_NAME = "Better_Health.db";
    public static final String TABLE_NAME = "Common_Info";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "First_Name";
    public static final String COL_3 = "Middle_Name";
    public static final String COL_4 = "Last_Name";
    public static final String COL_5 = "Date_Of_Birth";
    public static final String COL_6 = "Identity_No";
    public static final String COL_7 = "Gender";
    public static final String COL_8 = "Contact_No";
    public static final String COL_9 = "Email";
    public static final String COL_10 = "Password";

    // Student table columns
    public static final String TABLE_NAME1 = "Student";
    public static final String STUDENT_COL_1 = "ID";
    public static final String STUDENT_COL_2 = "Student_No";
    public static final String STUDENT_COL_3 = "Program_Major";
    public static final String STUDENT_COL_4 = "Level_Of_Study";
    public static final String STUDENT_COL_5 = "Faculty";
    public static final String STUDENT_COL_6 = "Department";
    public static final String STUDENT_COL_7 = "Relationship";
    public static final String STUDENT_COL_8 = "Full_Names";
    public static final String STUDENT_COL_9 = "EM_Contact_No";
    public static final String STUDENT_COL_10 = "Allergies";
    public static final String STUDENT_COL_11 = "Medications";
    public static final String STUDENT_COL_12 = "Insurance_Provider_Name";
    public static final String STUDENT_COL_13 = "Policy_Number";
    public static final String STUDENT_COL_14 = "Coverage_Details";
    public static final String STUDENT_COL_15 = "Residence_Name";
    public static final String STUDENT_COL_16 = "Address";
    public static final String STUDENT_COL_17 = "Room_No";

    // Foreign key column
    public static final String FOREIGN_KEY_COL = "Common_Info_ID";

    public Database_Helper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Common_Info table
        String createCommonInfoTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " +
                COL_3 + " TEXT, " +
                COL_4 + " TEXT, " +
                COL_5 + " TEXT, " +
                COL_6 + " TEXT, " +
                COL_7 + " TEXT, " +
                COL_8 + " TEXT, " +
                COL_9 + " TEXT, " +
                COL_10 + " TEXT)";
        db.execSQL(createCommonInfoTableQuery);

        // Create Student table with foreign key
        String createStudentTableQuery = "CREATE TABLE " + TABLE_NAME1 + " (" +
                STUDENT_COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                STUDENT_COL_2 + " TEXT, " +
                STUDENT_COL_3 + " TEXT, " +
                STUDENT_COL_4 + " TEXT, " +
                STUDENT_COL_5 + " TEXT, " +
                STUDENT_COL_6 + " TEXT, " +
                STUDENT_COL_7 + " TEXT, " +
                STUDENT_COL_8 + " TEXT, " +
                STUDENT_COL_9 + " TEXT, " +
                STUDENT_COL_10 + " TEXT, " +
                STUDENT_COL_11 + " TEXT, " +
                STUDENT_COL_12 + " TEXT, " +
                STUDENT_COL_13 + " TEXT, " +
                STUDENT_COL_14 + " TEXT, " +
                STUDENT_COL_15 + " TEXT, " +
                STUDENT_COL_16 + " TEXT, " +
                STUDENT_COL_17 + " TEXT, " +
                FOREIGN_KEY_COL + " INTEGER, " +
                "FOREIGN KEY (" + FOREIGN_KEY_COL + ") REFERENCES " + TABLE_NAME + "(" + COL_1 + "))";
        db.execSQL(createStudentTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }


    public boolean insertData(String First_Name, String Middle_Name, String Last_Name, String Date_Of_Birth,
                              String Identity_No, String Gender, String Contact_No, String Email, String Password,

                              String Student_No, String Program_Major, String Level_Of_Study, String Faculty, String Department,

                              String Relationship, String Full_Names, String EM_Contact_No,

                              String Allergies, String Medications,

                              String Insurance_Provider_Name, String Policy_Number, String Coverage_Details,

                              String Residence_Name, String Address, String Room_No) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            // Insert into Common_Info table
            ContentValues commonInfoValues = new ContentValues();
            commonInfoValues.put(COL_2, First_Name);
            commonInfoValues.put(COL_3, Middle_Name);
            commonInfoValues.put(COL_4, Last_Name);
            commonInfoValues.put(COL_5, Date_Of_Birth);
            commonInfoValues.put(COL_6, Identity_No);
            commonInfoValues.put(COL_7, Gender);
            commonInfoValues.put(COL_8, Contact_No);
            commonInfoValues.put(COL_9, Email);
            commonInfoValues.put(COL_10, Password);
            long commonInfoResult = db.insert(TABLE_NAME, null, commonInfoValues);

            // Insert into Student table
            ContentValues studentValues = new ContentValues();
            studentValues.put(STUDENT_COL_2, Student_No);
            studentValues.put(STUDENT_COL_3, Program_Major);
            studentValues.put(STUDENT_COL_4, Level_Of_Study);
            studentValues.put(STUDENT_COL_5, Faculty);
            studentValues.put(STUDENT_COL_6, Department);
            studentValues.put(STUDENT_COL_7, Relationship);
            studentValues.put(STUDENT_COL_8, Full_Names);
            studentValues.put(STUDENT_COL_9, EM_Contact_No);
            studentValues.put(STUDENT_COL_10, Allergies);
            studentValues.put(STUDENT_COL_11, Medications);
            studentValues.put(STUDENT_COL_12, Insurance_Provider_Name);
            studentValues.put(STUDENT_COL_13, Policy_Number);
            studentValues.put(STUDENT_COL_14, Coverage_Details);
            studentValues.put(STUDENT_COL_15, Residence_Name);
            studentValues.put(STUDENT_COL_16, Address);
            studentValues.put(STUDENT_COL_17, Room_No);
            studentValues.put(FOREIGN_KEY_COL, commonInfoResult); // Set foreign key value
            long studentResult = db.insert(TABLE_NAME1, null, studentValues);

            // Commit transaction if successful
            if (commonInfoResult != -1 && studentResult != -1) {
                db.setTransactionSuccessful();
                return true;
            } else {
                return false;
            }
        } finally {
            db.endTransaction();
        }
    }

}
