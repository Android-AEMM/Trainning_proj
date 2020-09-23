package com.example.trainning_proj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ProjectData3";
    public static final String TABLE_NAME = "registuser";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "name";
    public static final String COL_3 = "email";
    public static final String COL_4 = "phone";
    public static final String COL_5 = "password";


    private static final String CREATE = "CREATE TABLE  'registuser' ( 'ID' INTEGER PRIMARY KEY AUTOINCREMENT , 'name' TEXT not null ," +
            " 'email' TEXT not null unique , 'phone' TEXT not null unique , 'password' TEXT not null) ";
    private static final int DB_VERVSOIN = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERVSOIN);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean insertUser(String name, String email, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, phone);
        contentValues.put(COL_5, password);
        Boolean check = null;
        try {
            long row = db.insert(TABLE_NAME, null, contentValues);
            db.close();
            if (row > 0)
                check = true;
            else
                check = false;
        } catch (SQLiteConstraintException ex) {
        }
        return check;
    }

    public Boolean isLoginUser(String email, String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        //String selection = COL_3 + "=?" + "and" + COL_5 + "=?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.rawQuery("Select * from registuser where email =? and password =? ", selectionArgs);
        //query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

       if (count > 0) {
            return true;
        } else
            return false;
    }

    public Boolean change(String email, String strNewPin1) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("UPDATE " + TABLE_NAME + " SET " + COL_5 + " = '" + strNewPin1 + "' WHERE " + COL_3 + "=?", new String[]{email});

        int count = cur.getCount();
        cur.close();
        db.close();
        if(count>0)
            return  true;
        else
            return false;
    }

    public Boolean forget_pass( String email, String phone) {

        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = { email, phone};
        Cursor cursor = db.rawQuery("Select * from registuser where  email =? and phone =?", selectionArgs);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        if(count>0)
            return true;
        else
            return false;

    }
}
