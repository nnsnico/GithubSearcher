package com.github.intern.yuji.githubsearcher.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.SearchSuggestionsAdapter;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.github.intern.yuji.githubsearcher.R;
import com.github.intern.yuji.githubsearcher.contract.MainActivityContract;
import com.github.intern.yuji.githubsearcher.databinding.ActivityMainBinding;
import com.github.intern.yuji.githubsearcher.model.GithubClient;
import com.github.intern.yuji.githubsearcher.model.GithubEntity;
import com.github.intern.yuji.githubsearcher.model.GithubRepository;
import com.github.intern.yuji.githubsearcher.model.GithubService;
import com.github.intern.yuji.githubsearcher.view.component.RecyclerAdapter;
import com.github.intern.yuji.githubsearcher.viewmodel.MainActivityViewModel;
import com.raizlabs.android.dbflow.config.FlowManager;

public class MainActivity extends AppCompatActivity implements MainActivityContract {
    private RecyclerAdapter adapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlowManager.init(this);
        GithubService service = GithubClient.githubApiBuilder();
        viewModel = new MainActivityViewModel(this, service);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new RecyclerAdapter();
        binding.recyclerView.setAdapter(adapter);

        setupSearchView();

    }

    private void setupSearchView() {
        viewModel.loadAllRepositories();
        binding.searchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
                Log.d("suggest", searchSuggestion.getBody());
                viewModel.loadRepositoriesInName(searchSuggestion.getBody());
            }

            @Override
            public void onSearchAction(String currentQuery) {
                viewModel.loadRepositories(currentQuery.trim());
            }
        });
        binding.searchView.setOnQueryChangeListener((oldQuery, newQuery) -> {
            if (!oldQuery.equals("") && newQuery.equals("")) {
                binding.searchView.clearSuggestions();
            } else {
                binding.searchView.swapSuggestions(viewModel.query(newQuery));
            }
        });
        binding.searchView.setOnBindSuggestionCallback((suggestionView, leftIcon, textView, item, itemPosition) -> {
            GithubEntity entity = (GithubEntity) item;
            String text = entity.getBody();
            textView.setText(text);
        });
    }

    @Override
    public void showRepository(GithubRepository repository) {
        Log.d(MainActivity.class.getSimpleName(), repository.items.toString());
        adapter.notifyItemChanged(repository.items);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
