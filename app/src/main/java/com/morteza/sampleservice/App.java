package com.morteza.sampleservice;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

class App extends Application {
    public static final String KEY_ID_CHANNEL   = "ID_CHANNEL";
    public static final String KEY_NAME_CHANNEL = "NAME_CHANNEL";

    @Override
    public void onCreate() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel =
                    new NotificationChannel(KEY_ID_CHANNEL, KEY_NAME_CHANNEL, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("service");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        super.onCreate();
    }
}
