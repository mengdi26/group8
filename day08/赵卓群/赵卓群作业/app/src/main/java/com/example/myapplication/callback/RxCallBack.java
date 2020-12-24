package com.example.myapplication.callback;

public interface RxCallBack<T> {
  void onSuccessData(T t);
  void onError(String Msg);
}
