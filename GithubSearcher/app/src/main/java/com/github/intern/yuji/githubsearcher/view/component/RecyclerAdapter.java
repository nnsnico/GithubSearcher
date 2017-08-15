package com.github.intern.yuji.githubsearcher.view.component;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.intern.yuji.githubsearcher.databinding.ItemListBinding;
import com.github.intern.yuji.githubsearcher.model.GithubEntity;

import java.util.List;

/**
 * Created by nns on 2017/08/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<GithubEntity> entities;

    public void notifyItemChanged(List<GithubEntity> entities) {
        this.entities = entities;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        GithubEntity entity = entities.get(position);
        holder.binding.setEntity(entity);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (entities != null) {
            return entities.size();
        }
        return 0;
    }
}
