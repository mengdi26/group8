package com.example.sx_day05.callback;

public interface RxCallBack<T> {
    void onSuccessData(T t);
    void onErrorMsg(String msg);
}
