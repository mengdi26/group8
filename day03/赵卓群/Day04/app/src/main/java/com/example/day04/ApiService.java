package com.example.day04;

import com.example.day04.bean.FenleiBean;
import com.example.day04.bean.HotBean;
import com.example.day04.bean.TypeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String BESA_URL="http://cdwan.cn:7000/";
    //http://cdwan.cn:7000/tongpao/discover/news_1.json  //热门

    @GET("tongpao/discover/hot_activity.json")
    Observable<HotBean> getHot();
    // /discover/navigation.json  //分类
    @GET("tongpao/discover/navigation.json")
    Observable<FenleiBean> getFen();

    // /discover/news_1.json
    @GET("/discover/news_{type}.json")
    Observable<TypeBean> getType(@Path("type")int page);
}
