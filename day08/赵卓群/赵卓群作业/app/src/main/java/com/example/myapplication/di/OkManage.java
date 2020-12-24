package com.example.myapplication.di;

import com.example.myapplication.mvp.api.ApiService;
import com.example.myapplication.mvp.constants.ApiConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Module//向外提供对象的注解
public class OkManage {

    @Singleton//表示单例
    @Provides//提供
    public OkHttpClient.Builder proBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    public OkHttpClient proOkHttpClient() {
        return proBuilder().build();
    }

    @Singleton
    @Provides
    public Retrofit.Builder proRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    public Retrofit proRetrofit() {
        return proRetrofitBuilder()
                .baseUrl(ApiConstants.DEBUG_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public ApiService proApiService() {
        return proRetrofit().create(ApiService.class);
    }
}
