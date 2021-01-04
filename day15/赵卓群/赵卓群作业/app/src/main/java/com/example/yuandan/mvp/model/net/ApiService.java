package com.example.yuandan.mvp.model.net;

import com.example.yuandan.mvp.model.bean.HomeBannerBean;
import com.example.yuandan.mvp.model.bean.HomeTopIcBean;
import com.example.yuandan.mvp.model.bean.VwvBean;
import com.google.gson.JsonObject;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService{

    String Url = "https://www.chuanzhiwang.cn/";

    @FormUrlEncoded
    @POST("api/index")
    Flowable<VwvBean> getData(@Field("device") String device);


    String Home = "http://cdwan.cn:7000/tongpao/";

    @GET("home/banner.json")
    Flowable<HomeBannerBean> getHomeBanner();

    @GET("home/topic_discussed.json")
    Flowable<HomeTopIcBean> getHomeTop();

}
