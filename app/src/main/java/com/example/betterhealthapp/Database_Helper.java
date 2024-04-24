package com.example.betterhealthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_Helper extends SQLiteOpenHelper {

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
    public static final String COL_9 = "Password";

    public Database_Helper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " +
                COL_3 + " TEXT, " +
                COL_4 + " TEXT, " +
                COL_5 + " TEXT, " +
                COL_6 + " TEXT, " +
                COL_7 + " TEXT, " +
                COL_8 + " TEXT, " +
                COL_9 + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String First_Name, String Middle_Name, String Last_Name, String Date_Of_Birth,
                              String Identity_No, String Gender, String Contact_No, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, First_Name);
        contentValues.put(COL_3, Middle_Name);
        contentValues.put(COL_4, Last_Name);
        contentValues.put(COL_5, Date_Of_Birth);
        contentValues.put(COL_6, Identity_No);
        contentValues.put(COL_7, Gender);
        contentValues.put(COL_8, Contact_No);
        contentValues.put(COL_9, Password);
        long results = db.insert(TABLE_NAME,null,contentValues);
        if (results == -1)
            return false;
        else
            return true;
    }
}
