package com.example.custom_dialog_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new Dialog(this);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.rating_layout);
                dialog.setCanceledOnTouchOutside(false);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//                TextView ratelater = dialog.findViewById(R.id.ratelater);
//                ratelater.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });

                dialog.show();
            }
        });


//        final Dialog dialog = new Dialog(MainActivity.this);
//        dialog.setContentView(R.layout.custom_dialog);
//        dialog.setTitle("Title...");

        // set the custom dialog components - text, image and button
//        TextView text = (TextView) dialog.findViewById(R.id.text);
//        text.setText("Android custom dialog example!");
//        ImageView image = (ImageView) dialog.findViewById(R.id.image);
//        image.setImageResource(R.drawable.ic_launcher);

//        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog

//        TextView ratenow = findViewById(R.id.ratenow);
//        TextView ratelater = findViewById(R.id.ratelater);
//
//        ratelater.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });

//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//        Window window = dialog.getWindow();
//
//        dialog.show();








    }
}