package com.example.tableapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<String> data;
    RecyclerView recyclerView;
    MyAdapter adapter;
    GridLayoutManager gridLayoutManager;
    int col=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        data.add("");
        data.add("");
        data.add("");

        adapter = new MyAdapter(this,data);
        recyclerView = findViewById(R.id.myrecyclerview);
        gridLayoutManager = new GridLayoutManager(this,col,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);





        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                col++;
                gridLayoutManager = new GridLayoutManager(MainActivity.this,col,GridLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(gridLayoutManager);






                data.add("cl");
                adapter.notifyDataSetChanged();
            }
        });
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<col;i++){
                    data.add("rw");
                }
                adapter.notifyDataSetChanged();

            }
        });

    }
}