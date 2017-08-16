package com.github.intern.yuji.githubsearcher.viewmodel;

import android.databinding.ObservableInt;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;

import com.github.intern.yuji.githubsearcher.contract.MainActivityContract;
import com.github.intern.yuji.githubsearcher.db.InternalGithubRepo;
import com.github.intern.yuji.githubsearcher.db.InternalGithubRepo_Table;
import com.github.intern.yuji.githubsearcher.model.GithubEntity;
import com.github.intern.yuji.githubsearcher.model.GithubRepository;
import com.github.intern.yuji.githubsearcher.model.GithubService;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    public final ObservableInt progressBarVisibility = new ObservableInt(View.GONE);
    private GithubService service;
    private MainActivityContract contract;
    private String format;

    public MainActivityViewModel(MainActivityContract contract, GithubService service) {
        this.contract = contract;
        this.service = service;

        // 作成日のフォーマット
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        format = DateFormat.format("yyyy-MM-dd", calendar).toString();
    }

    public void loadAllRepositories() {
        Observable<GithubRepository> repos = service.getRepos("created:>" + format);
        repos
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GithubRepository>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onNext(@NonNull GithubRepository repository) {
                        Delete.table(InternalGithubRepo.class);
                        final InternalGithubRepo table = new InternalGithubRepo();
                        for (GithubEntity items: repository.items) {
                            table.setName(items.name);
                            Log.d("inserted", table.getName());
                            table.insert();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        contract.showError("リポジトリを取得できませんでした");
                    }

                    @Override
                    public void onComplete() {}
                });
    }

    public List<GithubEntity> query(String query) {
        List<InternalGithubRepo> table =
                SQLite.select().from(InternalGithubRepo.class).where(InternalGithubRepo_Table.name.like("%" + query + "%")).queryList();
        List<GithubEntity> list = new ArrayList<>();
        for (InternalGithubRepo t : table) {
            Log.d("db", t.getName());
            GithubEntity entity = new GithubEntity("", null, "", t.getName(), "", "", "", "");
            list.add(entity);
        }
        return list;
    }

    public void loadRepositoriesInName(String keywords) {
        progressBarVisibility.set(View.VISIBLE);

        // 非同期通信でリポジトリを取得
        Observable<GithubRepository> repos = service.getRepos(keywords+ " in:name" + "+" + "created:>" + format);
        repos
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

    public void loadRepositories(String keywords) {
        progressBarVisibility.set(View.VISIBLE);

        // 非同期通信でリポジトリを取得
        Observable<GithubRepository> repos = service.getRepos(keywords + "+" + "created:>" + format);
        repos
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
