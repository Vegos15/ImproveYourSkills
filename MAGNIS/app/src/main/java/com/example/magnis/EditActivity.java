package com.example.magnis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    EditText field_name, field_born, field_from, field_location, field_jobAndStudy, field_phone, field_bio;
    Button save, back;
    ImageView imageView2;
    String url = "https://cdn.allwallpaper.in/wallpapers/1366x768/6239/green-android-1366x768-wallpaper.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        field_name = findViewById(R.id.field_name);
        field_born = findViewById(R.id.field_born);
        field_from = findViewById(R.id.field_from);
        field_location = findViewById(R.id.field_location);
        field_jobAndStudy = findViewById(R.id.field_jobAndStudy);
        field_phone = findViewById(R.id.field_phone);
        field_bio = findViewById(R.id.field_bio);


        save = findViewById(R.id.btn_save);
        back = findViewById(R.id.btn_withdrawal);
        save.setOnClickListener(this);
        back.setOnClickListener(this);
        imageView2 = findViewById(R.id.image_view2);
        MainActivity mainActivity = new MainActivity();
        mainActivity.loadUrl(url, imageView2);
    }






    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String name = intent.getStringExtra("names");
        String born = intent.getStringExtra("borns");
        String from = intent.getStringExtra("froms");
        String location = intent.getStringExtra("locations");
        String jobAndStudy = intent.getStringExtra("jobAndStudys");
        String phone = intent.getStringExtra("phones");
        String bio = intent.getStringExtra("bios");

        field_name.setText(name + "\n");
        field_born.setText(born + "\n");
        field_from.setText(from + "\n");
        field_location.setText(location + "\n");
        field_jobAndStudy.setText(jobAndStudy + "\n");
        field_phone.setText(phone + "\n");
        field_bio.setText(bio + "\n");
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("name", field_name.getText().toString());
                intent.putExtra("born", field_born.getText().toString());
                intent.putExtra("from", field_from.getText().toString());
                intent.putExtra("location", field_location.getText().toString());
                intent.putExtra("jobAndStudy", field_jobAndStudy.getText().toString());
                intent.putExtra("phone", field_phone.getText().toString());
                intent.putExtra("bio", field_bio.getText().toString());
                this.finish();
                startActivity(intent);
                break;

            case R.id.btn_withdrawal:
                startActivity(new Intent(this, MainActivity.class));
        }
    }
}
