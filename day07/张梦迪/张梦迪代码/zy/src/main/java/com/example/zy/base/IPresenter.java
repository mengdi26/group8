package com.example.zy.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}
