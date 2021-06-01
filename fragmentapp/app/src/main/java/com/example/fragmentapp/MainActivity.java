package com.example.fragmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Fragment fr1 = new firstfragment();
        Fragment fr2 = new secondfragment();
        Fragment fr3 = new thirdfragment();

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(false)
                .add(R.id.flfragment, fr1, null)
                .commit();


        BottomNavigationView bottomNavigationMenuView = findViewById(R.id.bottomNavigationView);

        bottomNavigationMenuView.setSelectedItemId(R.id.home);

        bottomNavigationMenuView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction()
                                .setReorderingAllowed(false)
                                .replace(R.id.flfragment, fr1, null)
                                .commit();
                        return true;

                    case R.id.favourite:
                        getSupportFragmentManager().beginTransaction()
                                .setReorderingAllowed(false)
                                .replace(R.id.flfragment, fr2, null)
                                .commit();
                        return true;

                    case R.id.search:
                        getSupportFragmentManager().beginTransaction()
                                .setReorderingAllowed(false)
                                .replace(R.id.flfragment, fr3, null)
                                .commit();
                        return true;

                }

                return false;
            }
        });


    }



}