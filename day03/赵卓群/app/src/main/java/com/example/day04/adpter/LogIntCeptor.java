package com.example.day04.adpter;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LogIntCeptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        Log.e("TAG",""+proceed.peekBody(1024).string() );
        return proceed;
    }
}
