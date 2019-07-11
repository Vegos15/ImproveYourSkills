package com.example.user_info;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_name, tv_born, tv_from, tv_location, tv_jobAndStudy, tv_phone, tv_bio;
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
        tv_born = (TextView) findViewById(R.id.field_born);
        tv_from = (TextView) findViewById(R.id.field_from);
        tv_location = (TextView) findViewById(R.id.field_location);
        tv_jobAndStudy = (TextView) findViewById(R.id.field_jobAndStudy);
        tv_phone = (TextView) findViewById(R.id.field_phone);
        tv_bio = (TextView) findViewById(R.id.field_bio);
        main_btnEdit = (Button) findViewById(R.id.main_btnEdit);
        main_btnEdit.setOnClickListener(this);






        String query = "SELECT "
                + DBHelper.KEY_ID + ", "
                + DBHelper.KEY_NAME + ", "
                + DBHelper.KEY_BORN + ", "
                + DBHelper.KEY_FROM + ", "
                + DBHelper.KEY_LOCATION + ", "
                + DBHelper.KEY_STUDY + ", "
                + DBHelper.KEY_PHONE + ", "
                + DBHelper.KEY_BIO +
                " FROM " + DBHelper.TABLE;

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        String name = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
        String born = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_BORN));
        String from = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_FROM));
        String location = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LOCATION));
        String study = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_STUDY));
        String phone = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
        String bio = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_BIO));
        cursor.close();

        tv_name.setText(name);
        tv_born.setText(born);
        tv_from.setText(from);
        tv_location.setText(location);
        tv_jobAndStudy.setText(study);
        tv_phone.setText(phone);
        tv_bio.setText(bio);
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
