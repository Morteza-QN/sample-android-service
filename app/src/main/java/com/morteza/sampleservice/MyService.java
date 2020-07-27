package com.morteza.sampleservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");

        startForeground(1001, createNotification());
        try {
            Thread.sleep(3000);
            stopSelf();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        stopForeground(true);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return null;
    }


    private Notification createNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel("KEY_ID_CHANNEL", "KEY_NAME_CHANNEL", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("service");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return new NotificationCompat.Builder(this, "KEY_ID_CHANNEL").setSmallIcon(android.R.drawable.stat_notify_chat)
                                                                     .setContentTitle("service").setContentText("foreground")
                                                                     .build();
    }
}
