package com.example.roomdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button add,reset;
    SharedPreferences sp;

    RecyclerView recyclerView;

    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.textinput);
        add = findViewById(R.id.btn_add);
        reset = findViewById(R.id.btn_reset);
        recyclerView = findViewById(R.id.recycle_view);
        database = RoomDB.getInstance(this);



        sp = getApplicationContext().getSharedPreferences("myUserPrefs", Context.MODE_PRIVATE);

        String newappornot = sp.getString("newappornot","yes");

        if(newappornot.equals("yes")) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("newappornot", "no");
            editor.commit();

            MainData data = new MainData();
            data.setText("Deepak rocks!");
            database.mainDao().insert(data);



        }


        Toast.makeText(this, newappornot, Toast.LENGTH_SHORT).show();




        dataList = database.mainDao().getAll();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MainAdapter(MainActivity.this,dataList);

        recyclerView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sText = editText.getText().toString().trim();

                if(!sText.equals("")){
                    MainData data = new MainData();
                    data.setText(sText);
                    database.mainDao().insert(data);
                    editText.setText("");

                    dataList.clear();
                    dataList.addAll(database.mainDao().getAll());
                    adapter.notifyDataSetChanged();
                }
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.mainDao().reset(dataList);

                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });




    }
}