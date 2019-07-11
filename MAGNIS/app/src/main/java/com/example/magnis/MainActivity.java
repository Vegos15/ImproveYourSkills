package com.example.magnis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_edit;
    TextView tv_name, tv_born, tv_from, tv_location, tv_jobAndStudy, tv_phone, tv_bio;
    SharedPreferences sharedPreferences;
    //01
    final String SAVED_NAME = "name";
    final String SAVED_BORN = "born";
    final String SAVED_FROM = "from";
    final String SAVED_LOCATION = "location";
    final String SAVED_STUDY = "study";
    final String SAVED_PHONE = "phone";
    final String SAVED_BIO = "bio";

    //02
    final String SAVED_NAME_2 = "name";
    final String SAVED_BORN_2 = "born";
    final String SAVED_FROM_2 = "from";
    final String SAVED_LOCATION_2 = "location";
    final String SAVED_STUDY_2 = "study";
    final String SAVED_PHONE_2 = "phone";
    final String SAVED_BIO_2 = "bio";
    ImageView imageView;
    String url = "https://cdn.allwallpaper.in/wallpapers/1366x768/6239/green-android-1366x768-wallpaper.jpg";

    SharedPreferences sharedPreferencesLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image_view);
        loadUrl(url, imageView);

        tv_name = findViewById(R.id.field_name);
        tv_born = findViewById(R.id.field_born);
        tv_from = findViewById(R.id.field_from);
        tv_location = findViewById(R.id.field_location);
        tv_jobAndStudy = findViewById(R.id.field_jobAndStudy);
        tv_phone = findViewById(R.id.field_phone);
        tv_bio = findViewById(R.id.field_bio);
        btn_edit = (Button) findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(this);
        loadDefault();
    }





    public void onStop() {
        super.onStop();
        saveIt();
        loadIt();
    }


    public void saveIt() {
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String born = intent.getStringExtra("born");
        String from = intent.getStringExtra("from");
        String location = intent.getStringExtra("location");
        String jobAndStudy = intent.getStringExtra("jobAndStudy");
        String phone = intent.getStringExtra("phone");
        String bio = intent.getStringExtra("bio");

        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SAVED_NAME, name);
        editor.putString(SAVED_BORN, born);
        editor.putString(SAVED_FROM, from);
        editor.putString(SAVED_LOCATION, location);
        editor.putString(SAVED_STUDY, jobAndStudy);
        editor.putString(SAVED_PHONE, phone);
        editor.putString(SAVED_BIO, bio);
        editor.apply();
    }
    private void loadIt(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        String savedText = sharedPreferences.getString(SAVED_NAME, "Vegos");
        String savedBorn = sharedPreferences.getString(SAVED_BORN, "Sep 27, 2000");
        String savedFrom = sharedPreferences.getString(SAVED_FROM, "Novovolynsk");
        String savedLocation = sharedPreferences.getString(SAVED_LOCATION, "Ternopil");
        String savedJobAndStudy = sharedPreferences.getString(SAVED_STUDY, "TNEU");
        String savedPhone = sharedPreferences.getString(SAVED_PHONE, "0982511775");
        String savedBio = sharedPreferences.getString(SAVED_BIO, "Programming!");

        tv_name.setText(savedText);
        tv_born.setText(savedBorn);
        tv_from.setText(savedFrom);
        tv_location.setText(savedLocation);
        tv_jobAndStudy.setText(savedJobAndStudy);
        tv_phone.setText(savedPhone);
        tv_bio.setText(savedBio);
    }







    private void loadDefault(){
        sharedPreferencesLast = getPreferences(MODE_PRIVATE);
        String Text = sharedPreferencesLast.getString(SAVED_NAME_2, "*");
        String Born = sharedPreferencesLast.getString(SAVED_BORN_2, "*");
        String From = sharedPreferencesLast.getString(SAVED_FROM_2, "*");
        String Location = sharedPreferencesLast.getString(SAVED_LOCATION_2, "*");
        String JobAndStudy = sharedPreferencesLast.getString(SAVED_STUDY_2, "*");
        String Phone = sharedPreferencesLast.getString(SAVED_PHONE_2, "*");
        String Bio = sharedPreferencesLast.getString(SAVED_BIO_2, "*");

        tv_name.setText(Text);
        tv_born.setText(Born);
        tv_from.setText(From);
        tv_location.setText(Location);
        tv_jobAndStudy.setText(JobAndStudy);
        tv_phone.setText(Phone);
        tv_bio.setText(Bio);
    }
    public void saveDefault() {
        sharedPreferences = getPreferences(MODE_PRIVATE);

        String savedText = sharedPreferences.getString(SAVED_NAME, "*");
        String savedBorn = sharedPreferences.getString(SAVED_BORN, "*");
        String savedFrom = sharedPreferences.getString(SAVED_FROM, "*");
        String savedLocation = sharedPreferences.getString(SAVED_LOCATION, "*");
        String savedJobAndStudy = sharedPreferences.getString(SAVED_STUDY, "*");
        String savedPhone = sharedPreferences.getString(SAVED_PHONE, "*");
        String savedBio = sharedPreferences.getString(SAVED_BIO, "*");

        sharedPreferencesLast = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPreferencesLast.edit();
        editor2.putString(SAVED_NAME_2, savedText);
        editor2.putString(SAVED_BORN_2, savedBorn);
        editor2.putString(SAVED_FROM_2, savedFrom);
        editor2.putString(SAVED_LOCATION_2, savedLocation);
        editor2.putString(SAVED_STUDY_2, savedJobAndStudy);
        editor2.putString(SAVED_PHONE_2, savedPhone);
        editor2.putString(SAVED_BIO_2, savedBio);
        editor2.apply();
    }












    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_edit:
                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("names", tv_name.getText().toString());
                intent.putExtra("borns", tv_born.getText().toString());
                intent.putExtra("froms", tv_from.getText().toString());
                intent.putExtra("locations", tv_location.getText().toString());
                intent.putExtra("jobAndStudys", tv_jobAndStudy.getText().toString());
                intent.putExtra("phones", tv_phone.getText().toString());
                intent.putExtra("bios", tv_bio.getText().toString());
                startActivity(intent);
                break;
        }
    }

    public void onDestroy() {
        saveDefault();
        super.onDestroy();
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
