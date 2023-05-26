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

public class Stor_Page extends AppCompatActivity {

    ArrayList<String> catalog_ID = new ArrayList<>();
    ArrayList<String> catalog_Category = new ArrayList<>();
    ArrayList<String> catalog_Name = new ArrayList<>();
    ArrayList<String> catalog_Description = new ArrayList<>();
    ArrayList<String> catalog_Price = new ArrayList<>();
    ArrayList<String> catalog_Time_result = new ArrayList<>();
    ArrayList<String> catalog_Preparation = new ArrayList<>();
    ArrayList<String> catalog_Bio = new ArrayList<>();

    RecyclerView recyclerStor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stor_page);
        recyclerStor = findViewById(R.id.recycleStore);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false);
        recyclerStor.setLayoutManager(linearLayoutManager);

        try{
            JSONObject obj = new JSONObject(loadJSONFromAsset("catalog.json"));
            JSONArray resultArray=obj.getJSONArray("results");
            for (int i = 0; i < resultArray.length();i++){
                JSONObject resultDetail = resultArray.getJSONObject(i);
                catalog_ID.add(resultDetail.getString("id"));
                catalog_Category.add(resultDetail.getString("category"));
                catalog_Name.add(resultDetail.getString("name"));
                catalog_Description.add(resultDetail.getString("description"));
                catalog_Price.add(resultDetail.getString("price"));
                catalog_Time_result.add(resultDetail.getString("time_result"));
                catalog_Preparation.add(resultDetail.getString("preparation"));
                catalog_Bio.add(resultDetail.getString("bio"));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        CatalogAdapter CatalogAdapter = new CatalogAdapter(Stor_Page.this,catalog_ID,catalog_Category,catalog_Name,catalog_Description,catalog_Price,
                catalog_Time_result,catalog_Preparation,catalog_Bio);
        recyclerStor.setAdapter(CatalogAdapter);
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
