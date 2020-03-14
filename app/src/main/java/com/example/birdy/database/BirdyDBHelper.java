package com.example.birdy.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.birdy.database.schemas.BirdyDBSchema;

public class BirdyDBHelper extends SQLiteOpenHelper {
    private static final int DB_VER = 1;
    private static final String DB_NAME = "birdy_db.db";
    private static BirdyDBHelper selfInstance;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + BirdyDBSchema.LibraryTable.NAME + " (" +
                BirdyDBSchema.LibraryTable._ID + " INTEGER PRIMARY KEY," +
                BirdyDBSchema.LibraryTable.ARTIST + " TEXT," +
                BirdyDBSchema.LibraryTable.ITEM_TYPE + " CHAR(1)," +
                BirdyDBSchema.LibraryTable.ITEM_NAME + " TEXT," +
                BirdyDBSchema.LibraryTable.ITEM_GENRE + " TEXT" + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TO DO
    }

    private BirdyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public static BirdyDBHelper getInstance(Context context){
        if(selfInstance == null){
            selfInstance = new BirdyDBHelper(context);
        }
        return selfInstance;
    }
}
