package com.example.cameraapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView myimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myimage = findViewById(R.id.image);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });


    }

    private void takePicture() {
//        Toast.makeText(this, "function called", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
//        Toast.makeText(this, "function started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Toast.makeText(this, "hi there", Toast.LENGTH_SHORT).show();
        if(resultCode==RESULT_OK && requestCode==0){
//            Toast.makeText(this, "image taken", Toast.LENGTH_SHORT).show();
            Bitmap b = (Bitmap) data.getExtras().get("data");
            myimage.setImageBitmap(b);

        }
    }
}