package com.example.day10.base;

public interface IBasePresenter<T> {

    void start();
    void start(T ... t);

}
