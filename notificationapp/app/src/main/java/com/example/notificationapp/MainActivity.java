package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }



        Button bt = findViewById(R.id.button);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String message = "Give your daughter in marriage to a good family, engage your son in learning, see that your enemy comes to grief, and engage your friends in dharma. (Krsna consciousness).";
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification")
//                        .setSmallIcon(R.drawable.ic_baseline_ac_unit_24)
//                        .setContentTitle("Deepak")
//                        .setContentText(message)
//                        .setAutoCancel(true);
//                Intent i = new Intent(MainActivity.this,MainActivity2.class);
//                i.putExtra("message",message);
//
//                PendingIntent pd = PendingIntent.getActivity(MainActivity.this,0,i,0);
//                builder.setContentIntent(pd);
//
//                Toast.makeText(MainActivity.this, "reached here", Toast.LENGTH_SHORT).show();
//
//                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);
//                notificationManagerCompat.notify(0,builder.build());
//            }
//        });


        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(this,notification.class);


        PendingIntent pd = PendingIntent.getBroadcast(this,0,i,0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(), 1000 * 60,pd);



    }
}