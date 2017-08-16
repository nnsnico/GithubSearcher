package com.github.intern.yuji.githubsearcher.model;

import java.util.List;

/**
 * Created by nns on 2017/08/13.
 */
public class GithubRepository {
    public List<GithubEntity> items;

    public GithubRepository(List<GithubEntity> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "GithubRepository{" +
                "items=" + items +
                '}';
    }
}
