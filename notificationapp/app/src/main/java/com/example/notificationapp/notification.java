package com.example.notificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class notification extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = "hello deepak ";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"My Notification")
                .setSmallIcon(R.drawable.ic_baseline_ac_unit_24)
                .setContentTitle("Deepak")
                .setContentText(message)
                .setAutoCancel(true);
        Intent i = new Intent(context,MainActivity2.class);
        i.putExtra("message",message);

        PendingIntent pd = PendingIntent.getActivity(context,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pd);

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(0,builder.build());
    }
}
