package com.diligre.vegos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;


import com.diligre.vegos.shapes.Note;
import com.diligre.vegos.models.NoteViewModel;
import com.squareup.picasso.Picasso;


import java.util.List;


public class MainActivity extends AppCompatActivity {
    String url = "https://cdn.allwallpaper.in/wallpapers/1366x768/6239/green-android-1366x768-wallpaper.jpg";
    public static final int EDIT_NOTE_REQUEST = 2;
    ImageView imageView;
    private NoteViewModel noteViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        loadUrl(url,imageView);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                adapter.setNotes(notes);
            }
        });
        adapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Note note) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);

                intent.putExtra(AddNoteActivity.EXTRA_ID, note.getId());
                intent.putExtra(AddNoteActivity.EXTRA_NAME, note.getName());
                intent.putExtra(AddNoteActivity.EXTRA_BORN, note.getBorn());
                intent.putExtra(AddNoteActivity.EXTRA_FROM, note.getFrom());
                intent.putExtra(AddNoteActivity.EXTRA_LOCATION, note.getLocation());
                intent.putExtra(AddNoteActivity.EXTRA_STUDIES, note.getStudies());
                intent.putExtra(AddNoteActivity.EXTRA_PHONE, note.getPhone());
                intent.putExtra(AddNoteActivity.EXTRA_BIOGRAPHY, note.getBio());
                startActivityForResult(intent, EDIT_NOTE_REQUEST);
            }
        });

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
                        }
                );


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_NOTE_REQUEST && resultCode == RESULT_OK) {
            int id = data.getIntExtra(AddNoteActivity.EXTRA_ID, -1);

            if (id == -1) {
                Toast.makeText(this, "not", Toast.LENGTH_SHORT).show();
                return;
            }

            String name = data.getStringExtra(AddNoteActivity.EXTRA_NAME);
            String born = data.getStringExtra(AddNoteActivity.EXTRA_BORN);
            String from = data.getStringExtra(AddNoteActivity.EXTRA_FROM);
            String location = data.getStringExtra(AddNoteActivity.EXTRA_LOCATION);
            String studies = data.getStringExtra(AddNoteActivity.EXTRA_STUDIES);
            String phone = data.getStringExtra(AddNoteActivity.EXTRA_PHONE);
            String bio = data.getStringExtra(AddNoteActivity.EXTRA_BIOGRAPHY);

            Note note = new Note(1, name, born, from, location, studies, phone, bio);
            note.setId(id);
            noteViewModel.update(note);
            Toast.makeText(this, "note up", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "not save", Toast.LENGTH_SHORT).show();
        }

    }
}
