package com.example.data_12_21.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}
