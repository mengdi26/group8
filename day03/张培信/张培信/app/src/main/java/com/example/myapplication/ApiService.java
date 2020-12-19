package com.example.myapplication;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.GET;

public interface ApiService {
    String s="http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<ShafaBean> get();
    String ss="http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<ShipingJava> get2();
    String sss="http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<TextJava> get3();
    String ssss="http://123.56.232.18:8080/";
    @GET("serverdemo//tag/queryTagList")
    Observable<MyBean> get4();
}
