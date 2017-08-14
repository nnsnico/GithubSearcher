package com.github.intern.yuji.githubsearcher.contract;

import com.github.intern.yuji.githubsearcher.model.GithubRepository;

/**
 * Created by nns on 2017/08/15.
 */

public interface MainActivityContract {
    void showRepository(GithubRepository repository);
    void showError(String message);
}
