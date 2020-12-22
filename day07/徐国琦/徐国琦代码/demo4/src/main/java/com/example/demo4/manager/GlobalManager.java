package com.example.demo4.manager;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.demo4.base.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GlobalManager {
    private volatile static GlobalManager mManager;
    private static Map<String, Object> mMap;
    private static Set<Activity> mSet;
    private static SharedPreferences mSp;

    private GlobalManager() {
        if (mMap == null) mMap = new HashMap<String, Object>();
        if (mSet == null) mSet = new HashSet<Activity>();
        if (mSp == null) mSp = App.getmContext().getSharedPreferences("config", App.MODE_PRIVATE);
    }

    public synchronized static GlobalManager getmManager() {
        if (mManager == null) {
            synchronized (GlobalManager.class) {
                if (mManager == null) {
                    mManager = new GlobalManager();
                }
            }
        }
        return mManager;
    }


    public void putMap(String key, Object value) {
        mMap.put(key, value);
    }

    public Object getMap(String key) {
        Object value = mMap.get(key);
        return value;
    }

    public void addActivity(Activity activity) {
        mSet.add(activity);
    }

    public void finshActivity() {
        for (int i = 0; i < mSet.size(); i++) {

        }
    }

    public void save_str(String key, String value) {
        mSp.edit().putString(key, value).commit();
    }

    public String getStr(String key) {
        return mSp.getString(key, "");
    }

    public void save_boolean(String key, Boolean value) {
        mSp.edit().putBoolean(key, value).commit();
    }

    public Boolean getBoolean(String key) {
        return mSp.getBoolean(key, false);
    }

    public void save_int(String key, int value) {
        mSp.edit().putInt(key, value).commit();
    }

    public int getInt(String key) {
        return mSp.getInt(key, 0);
    }
}
