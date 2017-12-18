package com.halftone;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("andorid", "applicatiom");
        Realm.init(this);
    }
}
