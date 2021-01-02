package com.example.newyear.Base;

import java.io.File;

import okhttp3.RequestBody;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
 

}