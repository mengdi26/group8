package com.example.sx_day05.base;

import android.app.Application;

import android.content.Context;

public class App extends Application {

    //全局的上下文 整个程序都可以用
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        context = this;
    }
    public static Context context(){
        return context;
    }
}
