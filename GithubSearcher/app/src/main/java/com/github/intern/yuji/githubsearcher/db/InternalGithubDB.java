package com.github.intern.yuji.githubsearcher.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by nns on 2017/08/16.
 */
@Database(name = InternalGithubDB.NAME, version = InternalGithubDB.VERSION)
public class InternalGithubDB {
    public static final String NAME = "InternalGithubDB";
    public static final int VERSION = 2;
}
