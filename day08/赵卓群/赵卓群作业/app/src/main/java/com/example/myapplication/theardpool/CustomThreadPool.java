package com.example.myapplication.theardpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPool extends ThreadPool {
    private static CustomThreadPool mCustom;
    private final ThreadPoolExecutor executor;

    private CustomThreadPool() {
        executor = new ThreadPoolExecutor(5, 30, 30, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>()
                , Executors.defaultThreadFactory());
    }

    public synchronized static CustomThreadPool getmCustom(){
        if(mCustom==null){
            synchronized (mCustom){
                if(mCustom==null){
                    mCustom=new CustomThreadPool();
                }
            }
        }
        return null;
    }
    @Override
    public void executeTask(Runnable runnable) {
        super.executeTask(runnable);
        if(executor==null){
            return;
        }
        executor.execute(runnable);
    }

    @Override
    public void removeTask() {
        if(executor==null){
            return;
        }
        executor.shutdown();
    }
}
