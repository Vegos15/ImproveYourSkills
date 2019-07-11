package com.example.real;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_name;
    Button main_btnEdit;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        tv_name = (TextView) findViewById(R.id.field_name);
        main_btnEdit = (Button) findViewById(R.id.main_btnEdit);
        main_btnEdit.setOnClickListener(this);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("person_info.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS info (name TEXT)");

        String query = "SELECT "
                + DBHelper.KEY_ID + ", "
                + DBHelper.KEY_NAME +
                " FROM " + DBHelper.TABLE;

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToLast();
        String name = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
        cursor.close();
        tv_name.setText(name);


    }





    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_btnEdit:
                Intent intent = new Intent(this, Second.class);
                startActivity(intent);
        }
    }
}
