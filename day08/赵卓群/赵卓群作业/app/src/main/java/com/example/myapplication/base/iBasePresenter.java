package com.example.myapplication.base;

public interface iBasePresenter<T> {
    void onStart(T t);
    void onStart(T... t);
}
