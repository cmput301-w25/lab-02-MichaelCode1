package com.example.listcity1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // I created:---
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    //------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //required lines
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);


        // optional
        setContentView(R.layout.activity_main);


        cityList = findViewById(R.id.city_list);
        String[] cities = {"Edmonton", "Paris", "London"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);
    }
}