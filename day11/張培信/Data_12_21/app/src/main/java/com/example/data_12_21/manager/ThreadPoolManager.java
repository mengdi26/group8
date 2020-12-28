package com.example.data_12_21.manager;


import com.example.data_12_21.base.BaseThreadPool;
import com.example.data_12_21.thread.CustomThreadPool;
import com.example.data_12_21.thread.SchduleThreadPool;
import com.example.data_12_21.thread.SingleThreadPool;


public class ThreadPoolManager {
    public static final int CUSTOM_THREADPOOL = 0;
    public static final int SINGLE_THREADPOOL = 1;
    public static final int SCHDULE_THREADPOOL = 2;

    public static BaseThreadPool getThreadPool(int type) {
        switch (type) {
            case CUSTOM_THREADPOOL:
                return CustomThreadPool.getThreadPool();
            case SINGLE_THREADPOOL:
                return SingleThreadPool.getSingleThreaPool();
            case SCHDULE_THREADPOOL:
                return SchduleThreadPool.getmSchduleThreadPool();
        }
        return null;
    }

}