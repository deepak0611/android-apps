package com.example.imagecreatorapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout rr = findViewById(R.id.image);
        LinearLayout bt = findViewById(R.id.sharebtn);
        bt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {

//                File dir = new File(Environment.getStorageDirectory().getPath() + "/folderDirDeepak/");
//                dir.mkdirs();
//
//                if(!dir.exists()){
//                    Toast.makeText(MainActivity.this, "file created", Toast.LENGTH_SHORT).show();
//                }

                try {
                    Bitmap bitmap = getBitmapFromView(rr);

                    File cachePath = new File(MainActivity.this.getCacheDir(), "images");
                    cachePath.mkdirs(); // don't forget to make the directory
                    FileOutputStream stream = new FileOutputStream(cachePath + "/image.png"); // overwrites this image every time
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    stream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                File imagePath = new File(MainActivity.this.getCacheDir(), "images");
                File newFile = new File(imagePath, "image.png");
                Uri contentUri = FileProvider.getUriForFile(MainActivity.this, "com.example.imagecreatorapp.fileprovider", newFile);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); // temp permission for receiving app to read this file
                intent.setDataAndType(contentUri, getContentResolver().getType(contentUri));
                intent.putExtra(Intent.EXTRA_STREAM, contentUri);
                startActivity(intent);


            }
        });

    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }

}