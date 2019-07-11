package com.example.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class Fragment_1 extends Fragment {

    Fragment_2 frag2;
    FragmentTransaction fTrans;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_1, container, false);

        Button btn_edit = (Button) view.findViewById(R.id.btn_edit);


        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag2 = new Fragment_2();
                fTrans = getFragmentManager().beginTransaction();
                fTrans.replace(R.id.fragment_space, frag2);
                fTrans.commit();
            }
        });

        return view;
    }
}
