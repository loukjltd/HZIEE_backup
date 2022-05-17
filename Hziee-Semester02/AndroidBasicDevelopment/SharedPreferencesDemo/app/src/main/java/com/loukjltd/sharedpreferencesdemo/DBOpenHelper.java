package com.loukjltd.sharedpreferencesdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "demo.db";
    public static final String TABLE_NAME = "people";
    public static final String COLLUM_ID = "_id";
    public static final String COLLUM_NAME = "name";
    public static final String COLLUM_AGE = "age";
    public static final String COLLUM_HEIGHT = "height";
    public static final String SQL_CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + COLLUM_ID + " integer primary key autoincrement, "
            + COLLUM_NAME + " text not null, "
            + COLLUM_AGE + " integer, "
            + COLLUM_HEIGHT + " float );";
    private SQLiteDatabase database;

    public DBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
