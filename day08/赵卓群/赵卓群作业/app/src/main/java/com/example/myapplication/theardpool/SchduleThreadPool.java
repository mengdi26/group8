package com.example.myapplication.theardpool;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchduleThreadPool extends ThreadPool {
    private static SchduleThreadPool mMchdule;
    private ScheduledExecutorService executor;

    @Override
    public void execeteTimeTask(Runnable runnable, long firstTime, long intervelTime, TimeUnit timeUnit) {

        executor.scheduleAtFixedRate(runnable, firstTime, intervelTime, timeUnit);
    }

    private SchduleThreadPool() {
        executor = Executors.newSingleThreadScheduledExecutor();
    }

    public synchronized static SchduleThreadPool getmMchdule() {
        if (mMchdule == null) {
            synchronized (mMchdule) {
                if (mMchdule == null) {
                    mMchdule = new SchduleThreadPool();
                }
            }
        }
        return mMchdule;
    }

    @Override
    public void removeTask() {

    }
}
