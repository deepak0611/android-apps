package com.example.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String lang = intent.getStringExtra(MainActivity.MSG);

        TextView textview = findViewById(R.id.orderText);
        textview.setText(lang);


        ListView myListView = (ListView) findViewById(R.id.myListView);
        ArrayList<String> grocery = new ArrayList<>();
        grocery.add("Document 1");
        grocery.add("Document 2");
        grocery.add("Document 3");
        grocery.add("Document 4");
        grocery.add("Document 5");
        grocery.add("Document 6");
        grocery.add("Document 7");
        grocery.add("Document 8");
        grocery.add("Document 9");
        grocery.add("Document 10");
        grocery.add("Document 11");
        grocery.add("Document 12");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,grocery);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

    }
}