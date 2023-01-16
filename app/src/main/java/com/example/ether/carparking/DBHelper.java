package com.example.ether.carparking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBHelper extends SQLiteAssetHelper {

    private static final int DB_Version=1;
    private static final String DB_Name="carparking.db";


    public DBHelper(Context context) {
        super(context, DB_Name,null,DB_Version);
    }


}
