package com.example.data_12_18;



import com.example.data_12_18.Bean.RmhdBean;
import com.example.data_12_18.Bean.Typeer;
import com.example.data_12_18.Bean.Typesan;
import com.example.data_12_18.Bean.Typeyi;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String baseUrlrmhd = "http://cdwan.cn:7000/";
    @GET("tongpao//discover/hot_activity.json")
    Observable<RmhdBean> getrmhd();

    String baseUrlrd = "http://cdwan.cn:7000/";
    @GET("tongpao/discover/news_1.json")
    Observable<Typeyi> getyi();

    String baseUrlzb = "http://cdwan.cn:7000/";
    @GET("tongpao/discover/news_2.json")
    Observable<Typeer> geter();

    String baseUrlts = "http://cdwan.cn:7000/";
    @GET("tongpao/discover/news_3.json")
    Observable<Typesan> getsan();
	
	//
}
