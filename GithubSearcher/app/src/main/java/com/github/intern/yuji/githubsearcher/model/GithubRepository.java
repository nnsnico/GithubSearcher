package com.github.intern.yuji.githubsearcher.model;

import java.util.List;

/**
 * Created by nns on 2017/08/13.
 */
public class GithubRepository {
    public final List<GithubEntity> entities;

    public GithubRepository(List<GithubEntity> entities) {
        this.entities = entities;
    }
}
