package com.example.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrName= new ArrayList();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        arrName.add("Tushar");
        arrName.add("Ram");
        arrName.add("Hariom");
        arrName.add("Harsh");
        arrName.add("Aman");
        arrName.add("Sid");
        arrName.add("karan");
        arrName.add("Tushar");
        arrName.add("Ram");
        arrName.add("Hariom");
        arrName.add("Harsh");
        arrName.add("Aman");
        arrName.add("Sid");
        arrName.add("karan");
        arrName.add("Tushar");
        arrName.add("Ram");
        arrName.add("Hariom");
        arrName.add("Harsh");
        arrName.add("Aman");
        arrName.add("Sid");
        arrName.add("karan");


        ArrayAdapter <String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrName);
        listView.setAdapter(adapter);

        Intent nxtView;
        nxtView = new Intent(MainActivity.this, Spinner1.class);

        Intent recyclePg;
        recyclePg = new Intent(MainActivity.this, RecyclerMain.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0){
                    startActivity(nxtView);
                } else if (i==1) {
                    startActivity(recyclePg);
                }

            }
        });



    }
}