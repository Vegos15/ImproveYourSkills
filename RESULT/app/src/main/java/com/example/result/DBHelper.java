package com.example.result;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "person_info.db";
    public static final String TABLE = "info";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "names";
    public static final String KEY_BORN = "born";
    public static final String KEY_FROM = "froms";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_STUDY = "study";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_BIO = "bio";



    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT, "
                + KEY_BORN + " TEXT, "
                + KEY_FROM + " TEXT, "
                + KEY_LOCATION + " TEXT, "
                + KEY_STUDY + " TEXT, "
                + KEY_PHONE + " TEXT, "
                + KEY_BIO + " TEXT); "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old_Version, int new_Version) {
        db.execSQL("drop table if exists " + TABLE);
        onCreate(db);
    }
}

