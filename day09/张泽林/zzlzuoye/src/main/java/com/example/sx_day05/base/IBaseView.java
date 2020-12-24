package com.example.sx_day05.base;

public interface IBaseView<T> {
    void onSuccess(T t);
    void onError(String msg);
}