package com.example.day03;

import com.example.day03.bean.FragFxInfos;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    public final String BASE_URL = "http://cdwan.cn:7000/tongpao//";
    public final String BASE_URL1 = "http://cdwan.cn:7000/tongpao/";


    @GET("discover/navigation.json")
    Observable<FragFxInfos> getFxFrag();

    @GET("discover/news_{page}.json")
    Observable<FragFxInfos> getBlank1Fx(@Path("page")int page);
}
