package com.example.result;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class Second extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    DBHelper dbHelper;
    EditText field_name;
    Button save;
    ImageView imageView2;
    String url = "https://cdn.allwallpaper.in/wallpapers/1366x768/6239/green-android-1366x768-wallpaper.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //connect Views:
        field_name = (EditText) findViewById(R.id.field_name);
        save = findViewById(R.id.btn_save);
        save.setOnClickListener(this);

        //DB
        dbHelper = new DBHelper(this);
        imageView2 = findViewById(R.id.image_view2);
        MainActivity mainActivity = new MainActivity();
        mainActivity.loadUrl(url, imageView2);
    }

    @Override
    public void onClick(View view) {
        String name = editText.getText().toString();
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (view.getId()){
            case R.id.btn_save:

                contentValues.put(DBHelper.KEY_NAME, name);
                database.insert(DBHelper.TABLE, null, contentValues);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
