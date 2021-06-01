package com.example.otp_auto_receiverapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.otp);
        requestPermission();

        new OTPReceiver().setEditText(edt);

    }

    private void requestPermission() {
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECEIVE_SMS)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                    Manifest.permission.RECEIVE_SMS
            },100);
        }
    }
}