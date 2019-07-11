package com.example.magnis_task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment_1 extends Fragment implements View.OnClickListener {

    Button btn_edit;
    TextView tv_name, tv_born, tv_from, tv_location, tv_jobAndStudy, tv_phone, tv_bio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {

        View view = getView();
        tv_name = (TextView) view.findViewById(R.id.field_name);
        tv_born = view.findViewById(R.id.field_born);
        tv_from = view.findViewById(R.id.field_from);
        tv_location = view.findViewById(R.id.field_location);
        tv_jobAndStudy = view.findViewById(R.id.field_jobAndStudy);
        tv_phone = view.findViewById(R.id.field_phone);
        tv_bio = view.findViewById(R.id.field_bio);
        btn_edit = (Button) view.findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(this);

        return inflater.inflate(R.layout.fragment_fragment_1, container, false);
    }

    @Override
    public void onClick(View view) {


    }
}
