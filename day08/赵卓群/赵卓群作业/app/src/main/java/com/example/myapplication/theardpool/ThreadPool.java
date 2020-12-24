package com.example.myapplication.theardpool;

import java.util.concurrent.TimeUnit;

public abstract class ThreadPool {
    public void executeTask(Runnable runnable){

    }
    public void execeteTimeTask(Runnable runnable, long firstTime,long intervelTime,TimeUnit timeUnit){

    }
    public abstract void removeTask();
    public  void removeTask(Runnable runnable){

    }
}
