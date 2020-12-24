package com.example.sx_day05.manager;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.sx_day05.base.App;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainManager {

    private volatile static ContainManager manager;
    //用来两个类之间传递对象
    private Map<String,Object> map;
    //定义一个集合存储所有需要添加到集合的Activity
    private Set<Activity> set;
    //全局的sp整个程序都可以用
    private SharedPreferences sp;

    private ContainManager(){
        if (map == null){
            map = new HashMap<String, Object>();
        }
        if (set == null){
            set = new HashSet<Activity>();
        }
        if (sp == null){
            App.context().getSharedPreferences("config",App.MODE_PRIVATE);
        }
    }
    public void save_str(String key,String value){
        sp.edit().putString(key,value).commit();
    }
    public String get_str(String key){
        return sp.getString(key,"");
    }
    public void save_boolean(String key,Boolean value){
        sp.edit().putBoolean(key,value).commit();
    }
    public Boolean get_boolean(String key){
        return sp.getBoolean(key,false);
    }
    public void addActivity(Activity activity){
        set.add(activity);
    }
    public void clearActivity(){
        for (Activity activity : set){
            if (activity != null){
                activity.finish();
                System.exit(0);
            }
        }
    }

    public void putObject(String key,Object object){
        map.put(key,object);
    }
    public Object getObject(String key){
        Object o = map.get(key);
        return o;
    }

    public static synchronized ContainManager getManager(){
        if (manager == null){
            synchronized (ContainManager.class){
                if (manager == null){
                    manager = new ContainManager();
                }
            }
        }
        return manager;
    }

}
