package com.example.prac18;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.paperdb.Paper;


public class AddActivity extends AppCompatActivity {

EditText mangaName, mangaAuthor;
Button addManga;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Paper.init(this);

        mangaName = findViewById(R.id.manga_name);
        mangaAuthor = findViewById(R.id.manga_author);

        addManga = findViewById(R.id.add_manga);

        PaperDbHelper paperDbHelper = new PaperDbHelper();

        addManga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group group = new Group(mangaName.getText().toString(), mangaAuthor.getText().toString());
                paperDbHelper.addGroup(group);
                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}