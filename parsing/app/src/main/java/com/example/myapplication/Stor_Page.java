package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Stor_Page extends AppCompatActivity {

    ArrayList<String> catalog_ID = new ArrayList<>();
    ArrayList<String> catalog_Category = new ArrayList<>();
    ArrayList<String> catalog_Name = new ArrayList<>();
    ArrayList<String> catalog_Description = new ArrayList<>();
    ArrayList<String> catalog_Price = new ArrayList<>();
    ArrayList<String> catalog_Time_result = new ArrayList<>();
    ArrayList<String> catalog_Preparation = new ArrayList<>();
    ArrayList<String> catalog_Bio = new ArrayList<>();
    ArrayList<String> news_ID = new ArrayList<>();
    ArrayList<String> news_Name = new ArrayList<>();
    ArrayList<String> news_Description = new ArrayList<>();
    ArrayList<String> news_price = new ArrayList<>();
    ArrayList<String> category_ID = new ArrayList<>();
    ArrayList<String> category_Name = new ArrayList<>();
    ArrayList<String> news_Image = new ArrayList<>();


    RecyclerView recyclerStor, recyclerCategories, recycler_shop_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stor_page);

        recyclerStor = findViewById(R.id.recycleStore);
        recycler_shop_item = findViewById(R.id.recycle_shop_item);
        recyclerCategories = findViewById(R.id.recycleCategories);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recycler_shop_item.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerCategories.setLayoutManager(linearLayoutManager2);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerStor.setLayoutManager(linearLayoutManager1);

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset("catalog.json"));
            JSONArray resultArray = obj.getJSONArray("results");
            for (int i = 0; i < resultArray.length(); i++) {
                JSONObject resultDetail = resultArray.getJSONObject(i);
                catalog_ID.add(resultDetail.getString("id"));
                catalog_Name.add(resultDetail.getString("name"));
                catalog_Price.add(resultDetail.getString("price"));
                catalog_Time_result.add(resultDetail.getString("time_result"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        CatalogAdapter CatalogAdapter = new CatalogAdapter(Stor_Page.this, catalog_ID, catalog_Name,
                catalog_Time_result, catalog_Price);

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset("news.json"));
            JSONArray resultArray = obj.getJSONArray("results");
            for (int i = 0; i < resultArray.length(); i++) {
                JSONObject resultDetail = resultArray.getJSONObject(i);
                news_ID.add(resultDetail.getString("id"));
                news_Name.add(resultDetail.getString("name"));
                news_Description.add(resultDetail.getString("description"));
                news_price.add(resultDetail.getString("price"));
                news_Image.add(resultDetail.getString("image"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset("category.json"));
            JSONArray resultArray = obj.getJSONArray("results");
            for (int i = 0; i < resultArray.length(); i++) {
                JSONObject resultDetail = resultArray.getJSONObject(i);
                category_ID.add(resultDetail.getString("id"));
                category_Name.add(resultDetail.getString("name"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        NewsAdapter NewsAdapter = new NewsAdapter(Stor_Page.this, news_ID, news_Description, news_Name, news_price,news_Image);
        recycler_shop_item.setAdapter(CatalogAdapter);
        recyclerStor.setAdapter(NewsAdapter);
        CategoryAdapter categoryAdapter = new CategoryAdapter(Stor_Page.this, category_ID, category_Name);
        recyclerCategories.setAdapter(categoryAdapter);
    }


    public String loadJSONFromAsset(String path) {
        String json = null;
        try {
            InputStream is = getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}