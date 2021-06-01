package com.example.themetoggleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch myswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Themetoggleapp2);
        }
        else setTheme(R.style.Theme_Themetoggleapp);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myswitch = findViewById(R.id.switch1);
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            myswitch.setChecked(true);
        }

        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restart();
//                    setTheme(R.style.Theme_Themetoggleapp2);
//                    Toast.makeText(MainActivity.this, "hello night", Toast.LENGTH_SHORT).show();
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restart();
//                    setTheme(R.style.Theme_Themetoggleapp);
                }
            }
        });



    }


    public void restart(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }



}