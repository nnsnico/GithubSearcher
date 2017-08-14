package com.github.intern.yuji.githubsearcher.model;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by nns on 2017/08/15.
 */

public class HttpClient {

    public static OkHttpClient createHttpClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.addInterceptor(getLoggingInterceptor());
        return builder.build();
    }

    private static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> Log.d("API LOG", message));
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return logging;
    }
}
