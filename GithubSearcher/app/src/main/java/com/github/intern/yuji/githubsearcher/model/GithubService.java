package com.github.intern.yuji.githubsearcher.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nns on 2017/08/13.
 */
public interface GithubService {

    /**
     * GithubAPIからリポジトリをGETする
     * スターが多い順（降順）で表示を行う
     * @param query 絞り込みを行う文字列
     * */
    @GET("search/repositories?sort=stars&order=desc")
    Observable<GithubRepository> getRepos(@Query("q") String query);
}
