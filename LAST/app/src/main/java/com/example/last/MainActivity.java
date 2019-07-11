package com.example.last;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button;
    DBHelper dbHelper;
    Cursor userCursor;
    SQLiteDatabase db;
    long userId=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button_edit);
        button.setOnClickListener(this);




//
//        userCursor = db.rawQuery("select * from " + DBHelper.TABLE_CONTACTS + " where " +
//                DBHelper.KEY_ID + "=?", new String[]{String.valueOf(userId)});
//        userCursor.moveToFirst();
//        textView.setText(userCursor.getString(1));
//        userCursor.close();



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_edit:
                Intent intent = new Intent(this, Second.class);
                startActivity(intent);
        }
    }
}