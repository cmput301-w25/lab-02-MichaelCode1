//package com.example.listcity1;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class MainActivity extends AppCompatActivity {
//
//    // I created:---
//    ListView cityList;
//    ArrayAdapter<String> cityAdapter;
//    ArrayList<String> dataList;
//    //------
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//
//        setContentView(R.layout.activity_main);
//
//
//        cityList = findViewById(R.id.city_list);
//
//        Button button = findViewById(R.id.button);
//
//        String[] cities = {"Edmonton", "Paris", "London"};
//        dataList = new ArrayList<>();
//        dataList.addAll(Arrays.asList(cities));
//        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
//        cityList.setAdapter(cityAdapter);
//
//        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dataList.add("Ottowa");
//                cityAdapter.notifyDataSetChanged();
//            }
//        });
//
//
//    }
//}

package com.example.listcity1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    EditText cityInput;
    Button addButton, deleteButton;
    int selectedCityPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        cityInput = findViewById(R.id.city_input);
        addButton = findViewById(R.id.add_button);
        deleteButton = findViewById(R.id.delete_button);

        String[] cities = {"Edmonton", "Paris", "London"};
        dataList = new ArrayList<>(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                selectedCityPosition = position;
                Toast.makeText(MainActivity.this, "Selected: " + dataList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newCity = cityInput.getText().toString().trim();
                if (!newCity.isEmpty()) {
                    dataList.add(newCity);
                    cityAdapter.notifyDataSetChanged();
                    cityInput.setText("");
                    Toast.makeText(MainActivity.this, "City added: " + newCity, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Enter a city name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedCityPosition >= 0) {
                    String removedCity = dataList.remove(selectedCityPosition);
                    cityAdapter.notifyDataSetChanged();
                    selectedCityPosition = -1;
                    Toast.makeText(MainActivity.this, "City deleted: " + removedCity, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Select a city to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
