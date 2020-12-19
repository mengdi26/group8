package com.example.day04_zy.net;

import com.example.day04_zy.bean.Bean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {
    //http://cdwan.cn:7000/tongpao/
    String Surl = "//http://cdwan.cn:7000/tongpao/";
    @GET("discover/hot_activity.json")
    Flowable<Bean> getData();
}
