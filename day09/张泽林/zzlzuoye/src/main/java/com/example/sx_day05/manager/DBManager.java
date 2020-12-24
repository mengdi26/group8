package com.example.sx_day05.manager;

import org.greenrobot.greendao.annotation.Id;

public class DBManager {
    private volatile static DBManager manager;

    private DBManager(){

    }
    public static synchronized DBManager getManager(){
        if (manager == null){
            synchronized (DBManager.class){
                if (manager == null){
                    manager = new DBManager();
                }
            }
        }
        return manager;
    }
}
