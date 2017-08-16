package com.github.intern.yuji.githubsearcher.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nns on 2017/08/15.
 */

public class GithubClient {

    public static GithubService githubApiBuilder() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(HttpClient.createHttpClientBuilder())
                .build()
                .create(GithubService.class);
    }
}
