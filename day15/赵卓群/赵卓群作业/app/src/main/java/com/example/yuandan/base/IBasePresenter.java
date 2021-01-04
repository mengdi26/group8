package com.example.yuandan.base;

public interface IBasePresenter<T> {

    void start();
    void start(T... t);

}
