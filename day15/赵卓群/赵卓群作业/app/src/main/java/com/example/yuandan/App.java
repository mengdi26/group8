package com.example.yuandan;

import android.app.Application;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

public class App extends Application {

    private static App myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }

    public static boolean getSP(String key, Boolean value){
         return myApp.getSharedPreferences("app",MODE_PRIVATE).getBoolean(key,value);
    }

    public static void addSP(String key, Boolean value){
        myApp.getSharedPreferences("app",MODE_PRIVATE).edit().putBoolean(key,value).commit();
    }

    public static String getString(String key, String value){
//        myApp.getSharedPreferences("a",MODE_PRIVATE).get
        return myApp.getSharedPreferences("data",MODE_PRIVATE).getString(key,value);
    }

    public static void addString(String key, String value){
        myApp.getSharedPreferences("data",MODE_PRIVATE).edit().putString(key,value).commit();
    }

}
