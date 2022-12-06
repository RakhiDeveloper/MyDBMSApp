package com.erinfa.mydbmsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {
public static final String DATABASE_Name = "DemoDp.dp";
    public static final String TABLE_Name = "Student";
    public static final String Col_1 = "ID";
    public static final String Col_2 = "NAME";
    public static final String Col_3 = "PHONE";
    public static final String Col_4 = "ADDRESS";
    public Databasehelper(@Nullable Context context) {
        super(context, DATABASE_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_Name+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PHONE REAL,ADDRESS TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_Name);

        onCreate(db);

    }
    public boolean insertData(String name, String phone, String address){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Col_2,name);
        contentValues.put(Col_3,phone);
        contentValues.put(Col_4,address);
        Long res=db.insert(TABLE_Name,null,contentValues);
        if (res==-1){
            return false;
        }else {
            return true;
        }


    }
}

