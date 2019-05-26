package com.example.sanjayakoju.myapp1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SanjayaKoju on 5/25/2019.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NANE="myapp1_Db";
    public static final String TABLE_NAME="tbl_user";
    public static final String Col_1="id";
    public static final String Col_2="username";
    public static final String Col_3="password";
    public static final String Col_4="mobileNumber";
    public static final String Col_5="email";

    public DBHelper(Context context) {
        super(context, DATABASE_NANE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table " +TABLE_NAME+ "(id integer primary key autoincrement, username text,password text, mobileNumber text, email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if exists user");
        onCreate(db);
    }
}
