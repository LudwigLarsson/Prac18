package com.example.prac18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.paperdb.Paper;

public class InfoActivity extends AppCompatActivity {
    TextView name;
    TextView author;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        name = findViewById(R.id.i_manga_name);
        author = findViewById(R.id.i_manga_author);
        delete = findViewById(R.id.delete_manga);
        Paper.init(this);

        Bundle args = getIntent().getExtras();
        name.setText(args.get("mangaName").toString());
        author.setText(args.get("mangaAuthor").toString());

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaperDbHelper.deleteGroupById((Integer) args.get("ID"));
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}