package com.example.android.testdrawer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;


import com.example.android.testdrawer.adapter.ArticleAdapter;
import com.example.android.testdrawer.models.Article;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {

    List<Article> articleList;
    RecyclerView recyclerView;
    ArticleAdapter adapter;

    DatabaseReference dbArticle;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        articleList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArticleAdapter(this,articleList);
        recyclerView.setAdapter(adapter);
        progressBar = findViewById(R.id.progressbar);
        Intent intent =  getIntent();
        final String category = intent.getStringExtra("categoty");
        Toolbar toolbar =findViewById(R.id.toolbar);
        toolbar.setTitle("category");
        setSupportActionBar(toolbar);

        dbArticle = FirebaseDatabase.getInstance().getReference("images")
                .child(category);
        progressBar.setVisibility(View.VISIBLE);
        dbArticle.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressBar.setVisibility(View.GONE);
                if(dataSnapshot.exists()){
                    for(DataSnapshot wallpapersnapshot:dataSnapshot.getChildren()){
                        String id = wallpapersnapshot.getKey();
                        String title = wallpapersnapshot.child("title").getValue(String.class);
                        String desc = wallpapersnapshot.child("desc").getValue(String.class);
                        String url = wallpapersnapshot.child("url").getValue(String.class);

                        Article a =  new Article(id, title, desc, url, category);
                        articleList.add(a);

                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
