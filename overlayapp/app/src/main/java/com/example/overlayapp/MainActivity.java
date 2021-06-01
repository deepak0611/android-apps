package com.example.overlayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LinearLayout hh1 = findViewById(R.id.hh1);
        ConstraintLayout hh2 = findViewById(R.id.hh2);

//        hh2.setVisibility(View.VISIBLE);
        Button bt = findViewById(R.id.button3);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View  v) {
                hh2.setVisibility(View.VISIBLE);
//                hh2.animate().translationY(0);
//                hh2.animate().alpha(1.0f);
//                Intent i = new Intent(MainActivity.this,MainActivity2.class);
//                startActivity(i);
            }
        });

        hh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                hh2.animate().translationY(hh2.getHeight());
//                hh2.animate().alpha(0.0f).setDuration(2000);
                hh2.setVisibility(View.GONE);
            }
        });

    }
}