package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.MyViewHolder> {
    ArrayList<String> catalog_ID;
    ArrayList<String> catalog_Name;
    ArrayList<String> catalog_Price;
    ArrayList<String> catalog_Time_result;
    Context context;

    public CatalogAdapter(Context context, ArrayList<String> catalog_ID,
                          ArrayList<String> catalog_Name,
                          ArrayList<String> catalog_Time_result, ArrayList<String> catalog_Price) {
        this.catalog_ID = catalog_ID;
        this.catalog_Name = catalog_Name;
        this.catalog_Time_result = catalog_Time_result;
        this.catalog_Price = catalog_Price;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_category, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CatalogAdapter.MyViewHolder holder, final int position) {
        holder.Name.setText(catalog_Name.get(position));
        holder.Time_result.setText(catalog_Time_result.get(position));
        holder.Price.setText(catalog_Price.get(position));

    }

    @Override
    public int getItemCount() {
        return catalog_ID.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Price, Time_result;

        public MyViewHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.name);
            Time_result = (TextView) itemView.findViewById(R.id.time);
            Price = (TextView) itemView.findViewById(R.id.price);

        }
    }
}
