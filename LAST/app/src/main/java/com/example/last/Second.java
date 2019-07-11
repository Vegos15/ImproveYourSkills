package com.example.last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Second extends AppCompatActivity implements View.OnClickListener {

    Button button_save;
    EditText editText;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.write_space);
        button_save = findViewById(R.id.button_save);
        button_save.setOnClickListener(this);
        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {

        String name = editText.getText().toString();
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (view.getId()){
            case R.id.button_save:

                contentValues.put(DBHelper.KEY_NAME, name);
                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        dbHelper.close();
    }
}
