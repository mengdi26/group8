package com.example.newyear.Base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}