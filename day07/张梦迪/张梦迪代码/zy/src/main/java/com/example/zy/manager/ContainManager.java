package com.example.zy.manager;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.zy.base.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainManager {
    private volatile static ContainManager mManager;
    private Map<String, Object> mMap;
    private Set<Activity> mSet;
    private SharedPreferences mSp;

    private ContainManager() {
        if (mMap == null) {
            mMap = new HashMap<>();
        }
        if (mSet == null) {
            mSet = new HashSet<>();
        }
        if (mSp == null) {
            App.context().getSharedPreferences("config", App.MODE_PRIVATE);
        }
    }

    public void save_str(String key, String value) {
        mSp.edit().putString(key, value).commit();
    }
    public String get_str(String key){
        return mSp.getString(key,"");
    }
    public void save_boolean(String key,Boolean value){
        mSp.edit().putBoolean(key,value).commit();
    }
    public boolean get_boolean(String key){
        return mSp.getBoolean(key,false);
    }
    public void addActivity(Activity activity){
        mSet.add(activity);
    }
    public void clearActivity(){
        for (Activity activity :
               mSet ) {
            if (activity !=null){
                activity.finish();
                System.exit(0);
            }

        }
    }
    public void putObj(String key,Object obj){
        mMap.put(key,obj);
    }
    public Object getObj(String key){
        final Object o = mMap.get(key);
        return o;
    }
    //双重锁
    public static synchronized ContainManager getmManager(){
        if (mManager == null){
            synchronized (ContainManager.class){
                if (mManager == null){
                     mManager = new ContainManager();
                }
            }
        }
        return mManager;
    }

}
