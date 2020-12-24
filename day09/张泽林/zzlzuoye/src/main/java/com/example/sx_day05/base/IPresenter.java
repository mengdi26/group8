package com.example.sx_day05.base;

public interface IPresenter<T> {
    void start(T t);
    void start(T... t);
}
