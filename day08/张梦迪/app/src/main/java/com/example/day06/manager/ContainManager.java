package com.example.day06.manager;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.day06.base.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainManager {
    //volatile用来保证对象的唯一性关键字
    private volatile static ContainManager mManager;
  //用来两个类之间传递数据
    private Map<String,Object> mMap;
    //定义一个集合存储所有需要添加到集合的activity
    private Set<Activity> mSet;
    //全聚德sp，整个程序都可以用
    private SharedPreferences mSp;


    public ContainManager() {
        //判断map集合是否为空 若为空就创建HashMap
        if (mMap == null){
         mMap = new HashMap<>();
        }
        //判断activity Map集合是否为空 若为空就创建空集合
        if (mSet == null){
             mSet = new HashSet<>();
        }
        //如果sp为空就获取
        if (mSp == null){
             mSp = App.context().getSharedPreferences("config", App.MODE_PRIVATE);
        }

    }
    //创建sp泛型为String类型的构造方法
    public void save_str(String key,String value){
        mSp.edit().putString(key,value).commit();
    }
    //创建通过键取值的方法
    public String get_str(String key){
        return mSp.getString(key,"");
    }
    //创建boolean类型的sp构造方法
    public void save_boolean(String key,Boolean value){
        mSp.edit().putBoolean(key,value).commit();
    }
    //创建获取boolean类型的构造
    public boolean get_boolean(String key){
        return mSp.getBoolean(key,false);
    }
    //创建activity集合构造
    public void addActivity(Activity activity){
        mSet.add(activity);
    }
    public void clearActivity(){
        for (Activity activity :
                mSet) {
            if (activity !=null){
                //关闭当前界面
                activity.finish();
                //退出程序
                System.exit(0);
            }
        }
    }
    public void putObj(String key,Object obj){
        mMap.put(key,obj);
    }
    public Object getObj(String key){
        final Object object = mMap.get(key);
        return object;
    }
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
