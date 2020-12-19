package com.example.myapplication;



import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServies {
    String s="http://cdwan.cn:7000/tongpao//discover/";
    @GET("hot_activity.json")
    Observable<Remenbean> get();
    String ss="http://cdwan.cn:7000/";
    @GET("tongpao/discover/news_1.json")
    Observable<Redainbean> get1();
    String sss="http://cdwan.cn:7000/";
    @GET("tongpao/discover/news_2.json")
    Observable<ZcBean> get2();
    String ssss="http://cdwan.cn:7000/";
    @GET("tongpao/discover/news_3.json")
    Observable<TsBean> get3();
}
