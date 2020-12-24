package com.example.myapplication.theardpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingeThreadPool extends ThreadPool {
    private static SingeThreadPool mSingThread;
    private final ExecutorService executorService;

    private SingeThreadPool() {
        executorService = Executors.newSingleThreadExecutor();
    }

    public static synchronized SingeThreadPool getmSingThread() {
        if (mSingThread == null) {
            synchronized (mSingThread) {
                if (mSingThread == null) {
                    mSingThread = new SingeThreadPool();
                }
            }
        }
        return null;
    }

    @Override
    public void executeTask(Runnable runnable) {
        super.executeTask(runnable);
        if (executorService == null) {
            return;
        }
        executorService.execute(runnable);
    }

    @Override
    public void removeTask() {
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
    }
}
