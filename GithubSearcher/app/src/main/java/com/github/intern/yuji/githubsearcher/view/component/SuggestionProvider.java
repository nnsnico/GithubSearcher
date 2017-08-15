package com.github.intern.yuji.githubsearcher.view.component;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by nns on 2017/08/15.
 */

public class SuggestionProvider extends ContentProvider {
    List<Object[]> suggest;
    String[] columns;

    @Override
    public boolean onCreate() {
        columns = new String[] {BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1};
        suggest = new ArrayList<>();
        suggest.add(new Object[] {"java"});
        suggest.add(new Object[] {"android"});
        suggest.add(new Object[] {"scala"});
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        // TODO: 2017/08/16 searchViewのテキストが変化するたびにこの関数が呼ばれる．ここでサジェストの表示を行う
        assert selectionArgs != null;
        if(selectionArgs[0].isEmpty()) {
            return null;
        }
        MatrixCursor cursor = new MatrixCursor(columns);
        Collection<Object[]> candidates = Collections2.filter(suggest, input -> {
            assert input != null;
            return ((String) input[1]).contains(selectionArgs[0]);
        });

        for (Object[] candidate: candidates) {
            cursor.addRow(candidate);
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
