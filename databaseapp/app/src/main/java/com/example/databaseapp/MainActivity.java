package com.example.databaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button btn;
    ListView list;

    DatabaseHelper databaseHelper;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        btn = findViewById(R.id.btn);
        list = findViewById(R.id.list);

        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);

        arrayList = databaseHelper.getAllText();

        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);

        list.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = name.getText().toString();
                if(!text.isEmpty()){
                    if(databaseHelper.addText(text)){
                        name.setText("");
                        Toast.makeText(MainActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

                        arrayList.clear();
                        arrayList.addAll(databaseHelper.getAllText());

                        arrayAdapter.notifyDataSetChanged();
                        list.invalidateViews();
                        list.refreshDrawableState();

                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Please write something", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}