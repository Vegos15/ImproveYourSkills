package com.example.db_finder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn_create;
    EditText et_name, et_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_create = findViewById(R.id.create_btn);
        et_name = findViewById(R.id.name_space);
        et_number = findViewById(R.id.phone_space);
        btn_create.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}
