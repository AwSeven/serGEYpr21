package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Store_Page1 extends AppCompatActivity {

    ArrayList<String> category_ID = new ArrayList<>();
    ArrayList<String> category_Name = new ArrayList<>();


    RecyclerView  recyclerCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stor_page);
        recyclerCategory = findViewById(R.id.recycleCategories);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false);
        recyclerCategory.setLayoutManager(linearLayoutManager);

        try{
            JSONObject obj = new JSONObject(loadJSONFromAsset("category.json"));
            JSONArray resultArray=obj.getJSONArray("results");
            for (int i = 0; i < resultArray.length();i++){
                JSONObject resultDetail = resultArray.getJSONObject(i);
                category_ID.add(resultDetail.getString("id"));
                category_Name.add(resultDetail.getString("category"));

            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        CategoryAdapter CategoryAdapter = new CategoryAdapter(Store_Page1.this,category_ID,category_Name);
        recyclerCategory.setAdapter(CategoryAdapter);
    }


    public String loadJSONFromAsset (String path) {
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
