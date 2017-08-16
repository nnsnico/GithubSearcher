package com.github.intern.yuji.githubsearcher.view.component;

import android.support.v7.widget.RecyclerView;

import com.github.intern.yuji.githubsearcher.databinding.ItemListBinding;

/**
 * Created by nns on 2017/08/15.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public final ItemListBinding binding;

    public RecyclerViewHolder(ItemListBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
