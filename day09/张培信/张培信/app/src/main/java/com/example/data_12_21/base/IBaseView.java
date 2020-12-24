package com.example.data_12_21.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}
