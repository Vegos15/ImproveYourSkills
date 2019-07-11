package com.example.magnis_task;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class Fragment_2 extends Fragment implements View.OnClickListener{

    EditText field_name, field_born, field_from, field_location, field_jobAndStudy, field_phone, field_bio;
    Button save, back;
    ImageView imageView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        field_name = getActivity().findViewById(R.id.field_name);
        field_born = getActivity().findViewById(R.id.field_born);
        field_from = getActivity().findViewById(R.id.field_from);
        field_location = getActivity().findViewById(R.id.field_location);
        field_jobAndStudy = getActivity().findViewById(R.id.field_jobAndStudy);
        field_phone = getActivity().findViewById(R.id.field_phone);
        field_bio = getActivity().findViewById(R.id.field_bio);

        save = getActivity().findViewById(R.id.btn_save);
        back = getActivity().findViewById(R.id.btn_withdrawal);
        save.setOnClickListener(this);
        back.setOnClickListener(this);

        return inflater.inflate(R.layout.fragment_fragment_2, container, false);
    }

    @Override
    public void onClick(View view) {

    }
}
