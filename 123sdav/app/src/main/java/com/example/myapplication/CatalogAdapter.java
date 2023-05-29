package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CatalogAdapter extends  RecyclerView.Adapter<CatalogAdapter.MyViewHolder> {
    ArrayList<String> catalog_ID;
    ArrayList<String> catalog_Category;
    ArrayList<String> catalog_Name;
    ArrayList<String> catalog_Description;
    ArrayList<String> catalog_Price;
    ArrayList<String> catalog_Time_result;
    ArrayList<String> catalog_Preparation;
    ArrayList<String> catalog_Bio;
    Context context;

    public CatalogAdapter(Context context, ArrayList<String> catalog_ID, ArrayList<String> catalog_Category,
                          ArrayList<String> catalog_Name, ArrayList<String> catalog_Description,
                          ArrayList<String> catalog_Price, ArrayList<String> catalog_Time_result,
                          ArrayList<String> catalog_Preparation, ArrayList<String> catalog_Bio) {
        this.catalog_ID = catalog_ID;
        this.catalog_Category = catalog_Category;
        this.catalog_Name = catalog_Name;
        this.catalog_Description = catalog_Description;
        this.catalog_Price = catalog_Price;
        this.catalog_Time_result = catalog_Time_result;
        this.catalog_Preparation = catalog_Preparation;
        this.catalog_Bio = catalog_Bio;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_hot,parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CatalogAdapter.MyViewHolder holder,final  int position) {
        holder.Name.setText(catalog_Name.get(position));
        holder.Bio.setText(catalog_Bio.get(position));
        holder.Price.setText(catalog_Price.get(position));

    }

    @Override
    public int getItemCount() {
        return catalog_ID.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ID, Categoty,Name,Description,Price,
        Time_result,Preparation,Bio;
        public MyViewHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.textViewStore1);
            Bio = (TextView) itemView.findViewById(R.id.textViewStore2);
            Price = (TextView) itemView.findViewById(R.id.textViewStore3);

        }
    }
}
