package com.example.day06.di.module;

import com.example.day06.mvp.model.api.ApiService;
import com.example.day06.mvp.model.constants.ApiConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

//向外界提供对象
@Module//向外界提供对象的注释
public class OKManager {

    //获取Ok.builder对象 返回的是创建一个ok.builder
   @Singleton
    @Provides
    public OkHttpClient.Builder proBuilder(){
        return new OkHttpClient.Builder();
    }
//用OK对象.build
@Singleton
    @Provides
    public OkHttpClient proOkHttpClient(){
        return proBuilder().build();
    }
    @Singleton
    @Provides

    public Retrofit.Builder proRetroBuilder(){
        return new Retrofit.Builder();
    }
    @Singleton
    @Provides

    public Retrofit proRetrofit(){
        return proRetroBuilder()
                .baseUrl(ApiConstants.RELEASE_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }
    @Singleton
    @Provides
    public ApiService proApiService(){
        return proRetrofit().create(ApiService.class);
    }

}
