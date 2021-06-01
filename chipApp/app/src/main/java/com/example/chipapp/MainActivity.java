package com.example.chipapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chiplist(View view){

        switch (view.getId()){
            case R.id.chip4:
                Toast.makeText(this, "chip4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chip5:
                Toast.makeText(this, "chip5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chip6:
                Toast.makeText(this, "chip6", Toast.LENGTH_SHORT).show();
                break;
        }

    }

}