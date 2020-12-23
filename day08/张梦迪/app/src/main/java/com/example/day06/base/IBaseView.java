package com.example.day06.base;

public interface IBaseView<T> {
    void onSuccess (T t);
    void onError (String msg);
}
