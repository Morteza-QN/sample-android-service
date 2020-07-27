package com.morteza.sampleservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service {
    private static final String  TAG      = "MyService2";
    private              IBinder myBinder = new MyBinder();

    public MyService2() {
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return myBinder;
    }

    public String getMassage() {
        Log.i(TAG, "getMassage: ");
        return "Hello Bound Service";
    }

    public class MyBinder extends Binder {
        public MyService2 getService() {
            Log.i(TAG, "getService: ");
            return MyService2.this;
        }
    }
}
