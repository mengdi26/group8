package com.example.data_12_21.callback;

public interface RxObserverCallBack<T> {
    void onSuccessData(T t);
    void onErrorMsg(String msg);
}
