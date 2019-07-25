package com.example.android.testdrawer.models;

import com.google.firebase.database.Exclude;

public class Article {
    public String desc, title, url;

    @Exclude
    public String id;
    @Exclude
    public String category;

     public Article(String id, String title, String desc, String url, String category) {
         this.id = id;
         this.title = title;
         this.desc = desc;
         this.url = url;
         this.category = category;
    }
}

