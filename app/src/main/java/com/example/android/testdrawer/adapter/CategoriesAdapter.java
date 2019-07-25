package com.example.android.testdrawer.adapter;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.testdrawer.ArticleActivity;
import com.example.android.testdrawer.R;
import com.example.android.testdrawer.models.Category;


import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {
    private Context mCtxt;
    private List<Category> categoryList;

    public CategoriesAdapter(Context mCtxt, List<Category> categoryList) {
        this.mCtxt = mCtxt;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

       View view = LayoutInflater.from(mCtxt).inflate(R.layout.recyclerview_categories , parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category c = categoryList.get(position);
        holder.textView.setText(c.name);
        Glide.with(mCtxt)
                .load(c.thumb)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {


        return categoryList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        ImageView imageView;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=(TextView) itemView.findViewById(R.id.text_view_cat);
            imageView=itemView.findViewById(R.id.image_view);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
           int p =  getAdapterPosition();
           Category c = categoryList.get(p);
            Intent intent = new Intent(mCtxt, ArticleActivity.class);
            intent.putExtra("category",c.name);
            mCtxt.startActivity(intent);
        }
    }

}
