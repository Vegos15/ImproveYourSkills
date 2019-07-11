package com.example.last_chanse;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userstore.db";
    private static final int SCHEMA = 1;
    static final String TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_YEAR = "year";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_STUDY = "study";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_BIO = "bio";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT, "
                + COLUMN_YEAR + " INTEGER, "
                + COLUMN_CITY + " TEXT, "
                + COLUMN_LOCATION + " TEXT, "
                + COLUMN_STUDY + " TEXT, "
                + COLUMN_PHONE + " INTEGER, "
                + COLUMN_BIO + " TEXT "
                + ")"
        );

        db.execSQL("INSERT INTO " + TABLE + " ("
                + COLUMN_NAME + ", "
                + COLUMN_YEAR + ", "
                + COLUMN_CITY + ", "
                + COLUMN_LOCATION + ", "
                + COLUMN_STUDY + ", "
                + COLUMN_PHONE + ", "
                + COLUMN_BIO
                + ") VALUES ('Vegos', 2000, Novovolynsk, Ternopil, TNEU, 0982511775, creating )"
                + ";");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
}