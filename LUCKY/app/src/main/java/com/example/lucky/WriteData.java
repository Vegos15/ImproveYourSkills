package com.example.lucky;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class WriteData extends AppCompatActivity implements View.OnClickListener {

    Button write_button;
    EditText editText;
    DBHelper dbHelper; //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_data);
        write_button = findViewById(R.id.write_button);
        editText = (EditText) findViewById(R.id.write_editText);
    }



    @Override
    public void onClick(View view) {

        String name = editText.getText().toString();
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (view.getId()){
            case R.id.write_button:
                contentValues.put(DBHelper.KEY_NAME, name);
                database.insert(DBHelper.TABLE, null, contentValues);


                Cursor cursor = database.query(DBHelper.TABLE, null, null,
                        null, null, null, null);
                if (cursor.moveToFirst()){
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);


                    do {
                        Log.d("tag", "id: " + cursor.getInt(idIndex) + "\n"
                                + "name: " + cursor.getString(nameIndex) + "\n"
                        );
                    } while (cursor.moveToNext());}


                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }
    }
}
