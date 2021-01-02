package com.example.day10.mvp.model.net;

import com.example.day10.mvp.model.bean.BannerBean;
import com.example.day10.mvp.model.bean.FuLiBean;
import com.example.day10.mvp.model.bean.ItemBean;
import com.example.day10.mvp.model.bean.TitleBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    String url = "https://gank.io/api/";

    @GET("data/%E7%A6%8F%E5%88%A9/20/{page}")
    Flowable<FuLiBean> getFuLi(@Path("page") int page);

    String Wan = "https://www.wanandroid.com/";

    @GET("banner/json")
    Flowable<BannerBean> getBanner();


    @GET("project/tree/json")
    Flowable<TitleBean> getTitle();

    @GET("project/list/1/json")
    Flowable<ItemBean> getItem(@Query("cid") int cid);
}
