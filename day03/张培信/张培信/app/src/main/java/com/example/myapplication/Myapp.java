package com.example.myapplication;

import android.app.Application;


public class Myapp extends Application {
    private static Myapp myapp;

    public static Myapp getMyapp() {
        return myapp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myapp=this;
    }
}
