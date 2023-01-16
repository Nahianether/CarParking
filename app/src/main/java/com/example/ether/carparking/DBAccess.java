package com.example.ether.carparking;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DBAccess instance;
    Cursor c=null;

    private DBAccess(Context context){
        this.openHelper=new DBHelper(context);
    }

    public static  DBAccess getInstance(Context context){
        if(instance==null){
            instance=new DBAccess(context);
        }
        return  instance;
    }

    public  void open(){
        this.openHelper.getWritableDatabase();
    }

    public  void  close(){
        if(db!=null){
            this.db.close();
        }
    }

    public int login(String email,String pass) {
        c = db.rawQuery("select Email,Password from userp where Email='" + email + "'", null);
        StringBuffer buffer = new StringBuffer();
        String a, b;
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

            a = c.getString(0);
            b = c.getString(1);
            if (a.equals(email) && b.equals(pass)) {
                return 1;
            }
        }
        return 0;
    }
}
