package com.example.myapplication.base;

public interface iBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}
