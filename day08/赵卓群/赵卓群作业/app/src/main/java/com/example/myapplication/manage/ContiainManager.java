package com.example.myapplication.manage;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.myapplication.base.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContiainManager {
    private volatile static ContiainManager manager;
    //用来两个类之间传递对象
    private Map<String, Object> mMap;
    //定义一个集合存储所有需要添加到集合的Activity
    private Set<Activity> mSet;
    //全局的SP 整个程序都可以用
    private SharedPreferences mSp;

    private ContiainManager() {
        if (mMap == null) {
            mMap = new HashMap<String, Object>();
        }
        if (mSet == null) {
            mSet = new HashSet<Activity>();
        }
        if (mSp == null) {
            mSp = App.context().getSharedPreferences("config",
                    App.MODE_PRIVATE);
        }
    }

    public static synchronized ContiainManager getManager() {
        if (manager == null) {
            synchronized (ContiainManager.class) {
                if (manager == null) {
                    manager = new ContiainManager();
                }
            }
        }
        return manager;
    }

    public void save_str(String key, String value) {
        mSp.edit().putString(key, value).commit();
    }

    public void get_str(String key) {
        mSp.getString(key, "");
    }

    public void save_boolean(String key, Boolean value) {
        mSp.edit().putBoolean(key, value).commit();
    }

    public void get_boolean(String key) {
        mSp.getBoolean(key, false);
    }

    public void addActivity(Activity activity) {
        mSet.add(activity);
    }

    public void clearActivity() {
        for (Activity activity : mSet) {
            if (mSet != null) {
                activity.finish();
                System.exit(0);
            }
        }
    }

    public void putObj(String key, Object object) {
        mMap.put(key, object);
    }

    public Object getObj(String key) {
        Object o = mMap.get(key);
        return o;
    }

}
