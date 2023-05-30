package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.time.Instant;
import java.util.ArrayList;

public class NewsAdapter extends  RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    ArrayList<String> news_ID;
    ArrayList<String> news_Name;
    ArrayList<String> news_Description;
    ArrayList<String> news_price;
    Context context;
    ArrayList<String> news_image;

    public NewsAdapter(Context context, ArrayList<String> news_ID, ArrayList<String> news_Name,
                       ArrayList<String> news_Description, ArrayList<String> news_price, ArrayList<String> news_image) {
        this.news_ID = news_ID;
        this.news_Name = news_Name;
        this.news_Description = news_Description;
        this.news_price = news_price;
        this.context = context;
        this.news_image = news_image;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_hot,parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final  int position) {
        holder.Name.setText(news_Name.get(position));
        holder.Description.setText(news_Description.get(position));
        holder.Price.setText(news_price.get(position));

        Picasso.with(context).load(news_image.get(position)).into(holder.Image);



        //Picasso.with(context).load(news_image).into(holder.Image);

    }

    @Override
    public int getItemCount() {
        return news_ID.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ID, Categoty,Name,Description,Price,
        Time_result,Preparation,Bio, image;
        ImageView Image;
        public MyViewHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.textViewStore1);
            Description = (TextView) itemView.findViewById(R.id.textViewStore2);
            Price = (TextView) itemView.findViewById(R.id.textViewStore3);
            Image = (ImageView)itemView.findViewById(R.id.imageView);


        }
    }
}
