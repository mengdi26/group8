package com.example.day03_exam;

import com.example.day03_exam.bean.PageBean;
import com.example.day03_exam.bean.TextBean;
import com.example.day03_exam.bean.TuijianBean;
import com.example.day03_exam.bean.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL="http://123.56.232.18:8080/";
    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics  沙发—图片
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<PageBean> getPage();

    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video 沙发—视频
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<VideoBean> getVideo();

    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275沙发— 文本
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<TextBean> getText();

    //http://123.56.232.18:8080/serverdemo//tag/queryTagList          发现—推荐
    @GET("serverdemo//tag/queryTagList")
    Observable<TuijianBean> getTuijian();


}
