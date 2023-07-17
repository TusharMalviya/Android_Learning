package com.example.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Spinner1 extends AppCompatActivity {

    Spinner spinner;
    AutoCompleteTextView actCmp;
    ArrayList<String> arrIds = new ArrayList<>();
    ArrayList<String> arrCity = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        actCmp= findViewById(R.id.actCmp);
        spinner = findViewById(R.id.spinner);


        arrIds.add("Aadhaar card");
        arrIds.add("Pan card");
        arrIds.add("Dl card");
        arrIds.add("Ration card");
        arrIds.add("Crm card");
        arrIds.add("Tenth card");
        arrIds.add("Rbl card");


        arrCity.add("Jaipur");
        arrCity.add("Jodhpur");
        arrCity.add("Jharkhand");
        arrCity.add("Bangalore");
        arrCity.add("Kerala");
        arrCity.add("Kashmir");
        arrCity.add("Delhi");
        arrCity.add("Kanpur");
        arrCity.add("Dharwad");
        arrCity.add("Pune");


        ArrayAdapter<String> spinnerAdpt = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrIds);
        spinner.setAdapter(spinnerAdpt);


        ArrayAdapter<String> atCmpAdpt = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrCity);
        actCmp.setAdapter(atCmpAdpt);

        actCmp.setThreshold(1);
    }
}