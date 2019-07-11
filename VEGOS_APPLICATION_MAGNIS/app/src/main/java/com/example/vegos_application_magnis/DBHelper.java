package com.example.vegos_application_magnis;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "person_info.db";
    public static final String TABLE = "info";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "names";



    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT); "
        );

        db.execSQL("INSERT INTO " + TABLE + " ("
                + KEY_NAME + ") "
                + "VALUES ('Vegos');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old_Version, int new_Version) {
        db.execSQL("drop table if exists " + TABLE);
        onCreate(db);
    }
}

