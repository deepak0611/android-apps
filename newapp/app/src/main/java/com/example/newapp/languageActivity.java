package com.example.newapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class languageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.MSG);

        ListView mylistview = (ListView) findViewById(R.id.mylistview);

        document doc1 = new document("Document 1");
        document doc2 = new document("Document 2");
        document doc3 = new document("Document 3");

        ArrayList<document> mydoceng = new ArrayList<>();
        mydoceng.add(doc1);
        mydoceng.add(doc2);
        mydoceng.add(doc3);

        document d1 = new document("डाक्यूमेंट 1");
        document d2 = new document("डाक्यूमेंट 2");
        document d3 = new document("डाक्यूमेंट 3");
        ArrayList<document> mydochindi = new ArrayList<>();
        mydochindi.add(d1);
        mydochindi.add(d2);
        mydochindi.add(d3);

        switch (msg) {
            case "hindi": {
                CustomListAdapter adapter = new CustomListAdapter(this, R.layout.adapter_view_layout, mydochindi);
                mylistview.setAdapter(adapter);
                break;
            }
            default: {
                CustomListAdapter adapter = new CustomListAdapter(this, R.layout.adapter_view_layout, mydoceng);
                mylistview.setAdapter(adapter);
                break;
            }
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
}