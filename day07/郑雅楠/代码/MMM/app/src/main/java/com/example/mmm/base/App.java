package com.example.mmm.base;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static  Context mContext;
//全都都可以使用
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mContext=this;

    }
    public static Context getontext(){
        return mContext ;

    }
}
