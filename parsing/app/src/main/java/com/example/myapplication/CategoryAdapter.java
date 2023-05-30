package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends  RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    ArrayList<String> category_ID;
    ArrayList<String> category_Name;
    Context context;

    public CategoryAdapter(Context context, ArrayList<String>category_ID,ArrayList<String>category_Name) {
        this.category_ID = category_ID;
        this.category_Name = category_Name;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_hot2,parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder,final  int position) {
        holder.Category.setText(category_Name.get(position));


    }

    @Override
    public int getItemCount() {
        return category_ID.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ID, Category;
        public MyViewHolder(View itemView) {
            super(itemView);
            Category = (TextView) itemView.findViewById(R.id.textName);

        }
    }
}
