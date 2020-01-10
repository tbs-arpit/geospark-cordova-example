package com.geospark.cordova;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.geospark.cordova.GeoSparkPlugin;

public class ImplicitService extends Service {
    private GeoSparkPlugin.GeoSparkCordovaReceiver mLocationReceiver;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        register();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unRegister();
    }

    private void register() {
        mLocationReceiver = new GeoSparkPlugin.GeoSparkCordovaReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.geospark.android.RECEIVED");
        registerReceiver(mLocationReceiver, intentFilter);
    }

    private void unRegister() {
        if (mLocationReceiver != null) {
            unregisterReceiver(mLocationReceiver);
        }
    }
}
