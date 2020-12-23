package com.example.day06.base;

public interface IPresenter<T> {
    //发送指令到M层
    void start();
    //发送指令到M层有参
    void start(T... t);
}
