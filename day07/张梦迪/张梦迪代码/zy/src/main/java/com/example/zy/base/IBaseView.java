package com.example.zy.base;

public interface IBaseView<T> {
    void onSuccess(T t);
    void onError(String msg);
}
