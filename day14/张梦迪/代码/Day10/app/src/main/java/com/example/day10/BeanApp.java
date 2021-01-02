package com.example.day10;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.example.day10.db.DaoMaster;
import com.example.day10.db.DaoSession;

public class BeanApp extends Application {

    private static BeanApp myBeanApp;
    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);

        myBeanApp = this;

        helper = new DaoMaster.DevOpenHelper(this, "bean.db", null);
        db = helper.getWritableDatabase();
        //Android 9 默认使用了wal模式,需要关闭wal模式
        db.disableWriteAheadLogging();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static BeanApp getMyBeanApp(){
        return myBeanApp;
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}
