package com.example.day03.net;

import com.example.day03.bean.Info_Activity;
import com.example.day03.bean.Info_Navgation;
import com.example.day03.bean.Info_Type;
import com.example.day03.bean.bang_1;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String url="http://cdwan.cn:7000/tongpao/";
    //袍子/discover/robe.json
    //热门活动http://cdwan.cn:7000/tongpao/
//分类导航： discover/navigation.json
    @GET("discover/navigation.json")
    Flowable<Info_Navgation>getNav();

    @GET("discover/hot_activity.json")
    Flowable<Info_Activity>getActici();
    ///discover/news_分类的type.json

    @GET("discover/news_{path}.json")
    Flowable<Info_Type>getType(@Path("path")int path);
//
   // 排行榜--等级榜  /discover/rank_level.json
   // 排行榜--签到榜 /discover/rank_sign.json
    //排行榜--土豪榜 /discover/rank_money.json
    @GET("discover/rank_level.json")
    Flowable<bang_1>getb1();

    @GET("discover/rank_sign.json")
    Flowable<bang_1>getb2();

    @GET("discover/rank_money.json")
    Flowable<bang_1>getb3();




}
