package com.example.newyear.callback;

public interface RxObserverCallBack<T> {
    void onSuccessData(T t);
    void onErrorMsg(String msg);
}