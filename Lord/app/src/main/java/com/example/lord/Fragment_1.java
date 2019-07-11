package com.example.lord;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class Fragment_1 extends Fragment {

    ImageButton imageButton;

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_1, null);

        imageButton = view.findViewById(R.id.f1_btn_image);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


//        create.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("tag", "Button click in Fragment 1");
//                String that_name = name.getText().toString();
//                String that_password = password.getText().toString();
//                String that_telephone = telephone.getText().toString();
//                SQLiteDatabase database = dbHelper.getWritableDatabase();
//                ContentValues contentValues = new ContentValues();
//
//                contentValues.put(DBHelper.KEY_NAME, that_name);
//                contentValues.put(DBHelper.KEY_PASSWORD, that_password);
//                contentValues.put(DBHelper.KEY_TELEPHONE, that_telephone);
//                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
//
//            }
//        });
        return view;
    }
}
