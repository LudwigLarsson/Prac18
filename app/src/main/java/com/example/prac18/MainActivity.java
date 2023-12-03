package com.example.prac18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity implements RecyclerInterface {

    RecyclerView rv;

    public Button button;
    ArrayList<Group> groups;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.go_to_add);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        Paper.init(this);

        rv = findViewById(R.id.rv);

        rv.setLayoutManager(new GridLayoutManager(this,2));
        rv.setHasFixedSize(true);
        groups = PaperDbHelper.getGroups();
        GroupsAdapter adapter = new GroupsAdapter(this, groups, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent i = new Intent(MainActivity.this, InfoActivity.class);
        i.putExtra("ID", position);
        i.putExtra("mangaName", groups.get(position).getName());
        i.putExtra("mangaAuthor", groups.get(position).getAuthor());
        startActivity(i);
    }
}

