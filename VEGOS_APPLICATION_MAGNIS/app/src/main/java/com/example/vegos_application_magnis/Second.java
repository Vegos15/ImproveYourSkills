package com.example.vegos_application_magnis;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Second extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    DBHelper dbHelper;
    EditText field_name, field_born, field_from, field_location, field_jobAndStudy, field_phone, field_bio;
    Button save, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        field_name = (EditText) findViewById(R.id.field_name);
        field_born = (EditText) findViewById(R.id.field_born);
        field_from = (EditText) findViewById(R.id.field_from);
        field_location = (EditText) findViewById(R.id.field_location);
        field_jobAndStudy = (EditText) findViewById(R.id.field_jobAndStudy);
        field_phone = (EditText) findViewById(R.id.field_phone);
        field_bio = (EditText) findViewById(R.id.field_bio);
        save = findViewById(R.id.btn_save);
        back = findViewById(R.id.btn_withdrawal);
        save.setOnClickListener(this);
        back.setOnClickListener(this);
        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {

        //find data from xml fields:
        String name = editText.getText().toString();
        String born = field_born.getText().toString();
        String from = field_from.getText().toString();
        String location = field_location.getText().toString();
        String study = field_jobAndStudy.getText().toString();
        String phone = field_phone.getText().toString();
        String bio = field_bio.getText().toString();

        //get DB & content:
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        switch (view.getId()){
            case R.id.btn_save:

                contentValues.put(DBHelper.KEY_NAME, name);

                database.insert(DBHelper.TABLE, null, contentValues);

                Cursor cursor = database.query(DBHelper.TABLE, null, null,
                        null, null, null, null);

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;


            case R.id.btn_withdrawal:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
