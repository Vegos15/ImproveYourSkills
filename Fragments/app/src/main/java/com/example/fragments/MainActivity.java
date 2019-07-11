package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_edit, btn_save;
    ImageView imageView2;
    String url = "https://cdn.allwallpaper.in/wallpapers/1366x768/6239/green-android-1366x768-wallpaper.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_edit = findViewById(R.id.btn_edit);
        btn_save = findViewById(R.id.btn_save);

        btn_edit.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Fragment fragment = null;

        switch (view.getId()){
            case R.id.btn_edit:
                fragment = new Fragment_2();
                break;
            case R.id.btn_save:
                fragment = new Fragment_1();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_space, fragment);
        fragmentTransaction.commit();
    }
}
