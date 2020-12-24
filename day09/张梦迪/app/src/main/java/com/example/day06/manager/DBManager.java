package com.example.day06.manager;

public class DBManager {
    private volatile static DBManager mManager;

    public DBManager() {
    }

    public static synchronized DBManager getDbManager() {
        if (mManager == null){
            synchronized (DBManager.class){
                mManager = new DBManager();
            }

        }
        return mManager;
    }
}
