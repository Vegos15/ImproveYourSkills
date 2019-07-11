package com.example.application;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Fragment_user extends Fragment {

    EditText nameBox;
    EditText yearBox;
    Button delButton;
    Button saveButton;

    DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    long userId = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View views = getView();
        nameBox = (EditText) views.findViewById();
        yearBox = (EditText) views.findViewById(R.id.year);
        delButton = (Button) views.findViewById(R.id.deleteButton);
        saveButton = (Button) views.findViewById(R.id.saveButton);

        sqlHelper = new DatabaseHelper(this);
        db = sqlHelper.getWritableDatabase();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userId = extras.getLong("id");
        }
        // если 0, то добавление
        if (userId > 0) {
            // получаем элемент по id из бд
            userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE + " where " +
                    DatabaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(userId)});
            userCursor.moveToFirst();
            nameBox.setText(userCursor.getString(1));
            yearBox.setText(String.valueOf(userCursor.getInt(2)));
            userCursor.close();
        } else {
            // скрываем кнопку удаления
            delButton.setVisibility(View.GONE);

            return inflater.inflate(R.layout.fragment_fragment_user, container, false);
    }


        public void save (View view){
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_NAME, nameBox.getText().toString());
            cv.put(DatabaseHelper.COLUMN_YEAR, Integer.parseInt(yearBox.getText().toString()));

            if (userId > 0) {
                db.update(DatabaseHelper.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + String.valueOf(userId), null);
            } else {
                db.insert(DatabaseHelper.TABLE, null, cv);
            }
            goHome();
        }








        public void delete (View view){
            db.delete(DatabaseHelper.TABLE, "_id = ?", new String[]{String.valueOf(userId)});
            goHome();
        }
        private void goHome () {
            // закрываем подключение
            db.close();
            // переход к главной activity
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }
}

