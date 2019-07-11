package com.example.magnis_task;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    private Fragment_1 fragment_1;
    private Fragment_2 fragment_2;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();


        fragment_1 = new Fragment_1();
        fragment_2 = new Fragment_2();

    }

    private void onClickTransaction(View view){
        transaction = manager.beginTransaction();
        transaction.add(R.id.container, new Fragment_2());
        transaction.commit();
    }
}
