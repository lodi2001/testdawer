package com.example.android.testdrawer.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.testdrawer.R;
import com.example.android.testdrawer.models.Article;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private Context mCtxt;
    private List<Article> articlesList;

    public ArticleAdapter(Context mCtxt, List<Article> categoryList) {
        this.mCtxt = mCtxt;
        this.articlesList = articlesList;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

       View view = LayoutInflater.from(mCtxt).inflate(R.layout.recyclerview_article , parent,false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article a = articlesList.get(position);
        holder.textView.setText(a.title);
        Glide.with(mCtxt)
                .load(a.url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {


        return articlesList.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;



        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.text_view_title);
            imageView=itemView.findViewById(R.id.image_view);

        }
    }

}
