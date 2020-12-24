package com.example.myapplication.theardpool;

public class ThreadPoolFactory {
    public static final int SCHDULE_THREADPOOL=0;
    public static final int SINGE_THREADPOOL=1;
    public static final int CUSTOM_THREADPOOL=2;
    public static ThreadPool getThreadPool(int type){
        switch (type){
            case SCHDULE_THREADPOOL:
                return SchduleThreadPool.getmMchdule();
            case SINGE_THREADPOOL:
                return SingeThreadPool.getmSingThread();
            case CUSTOM_THREADPOOL:
                return CustomThreadPool.getmCustom();
        }
        return null;
    }
}
