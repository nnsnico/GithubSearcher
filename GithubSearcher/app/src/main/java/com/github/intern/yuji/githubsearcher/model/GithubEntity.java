package com.github.intern.yuji.githubsearcher.model;

/**
 * Created by nns on 2017/08/13.
 */
public class GithubEntity {
    // TODO: 2017/08/13 リストに何を表示させるか
    public final String name;
    public final String description;
    public final String createdDate;

    public GithubEntity(String name, String description, String createdDate) {
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
    }
}
