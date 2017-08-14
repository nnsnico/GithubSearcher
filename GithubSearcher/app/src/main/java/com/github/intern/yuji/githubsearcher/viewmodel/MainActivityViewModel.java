package com.github.intern.yuji.githubsearcher.viewmodel;

import android.databinding.ObservableInt;
import android.text.format.DateFormat;
import android.view.View;

import com.github.intern.yuji.githubsearcher.contract.MainActivityContract;
import com.github.intern.yuji.githubsearcher.model.GithubRepository;
import com.github.intern.yuji.githubsearcher.model.GithubService;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Calendar;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by nns on 2017/08/15.
 */

public class MainActivityViewModel {
    public final ObservableInt progressBarVisibility = new ObservableInt(View.VISIBLE);
    private GithubService service;
    private MainActivityContract contract;

    public MainActivityViewModel(MainActivityContract contract, GithubService service) {
        this.contract = contract;
        this.service = service;
    }

    private void loadRepositories(String keywords) {
        progressBarVisibility.set(View.VISIBLE);
        // 作成日のフォーマット
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        String text = DateFormat.format("yyyy-MM-dd", calendar).toString();
        // 非同期通信でリポジトリを取得
        Observable<GithubRepository> observable = service.getRepos(keywords + " " + "created:>" + text);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GithubRepository>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull GithubRepository githubRepository) {
                        progressBarVisibility.set(View.GONE);
                        contract.showRepository(githubRepository);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        contract.showError("リポジトリを取得できませんでした");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
