package com.example.myapplication.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}