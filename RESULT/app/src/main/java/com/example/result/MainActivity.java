package com.example.result;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_name;
    Button main_btnEdit;
    DBHelper dbHelper;
    SQLiteDatabase db;
    ImageView imageView;
    String url = "https://cdn.allwallpaper.in/wallpapers/1366x768/6239/green-android-1366x768-wallpaper.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get DB:
        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();

        //Url photo
        imageView = (ImageView) findViewById(R.id.image_view);
        loadUrl(url, imageView);

        //connect Views:
        tv_name = (TextView) findViewById(R.id.field_name);
        main_btnEdit = (Button) findViewById(R.id.main_btnEdit);
        main_btnEdit.setOnClickListener(this);


        String query = "SELECT " + DBHelper.KEY_NAME + " FROM " + DBHelper.DATABASE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToLast();

        String item_content = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
        cursor.close();

        tv_name.setText(item_content);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_btnEdit:
                Intent intent = new Intent(this, Second.class);
                startActivity(intent);
        }
    }

    public void loadUrl(String url, ImageView imageView_target) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView_target, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                    }
                    @Override
                    public void onError() {
                    }
                });
    }
}
