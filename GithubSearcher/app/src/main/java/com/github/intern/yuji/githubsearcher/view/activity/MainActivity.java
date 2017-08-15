package com.github.intern.yuji.githubsearcher.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.github.intern.yuji.githubsearcher.R;
import com.github.intern.yuji.githubsearcher.contract.MainActivityContract;
import com.github.intern.yuji.githubsearcher.databinding.ActivityMainBinding;
import com.github.intern.yuji.githubsearcher.model.GithubClient;
import com.github.intern.yuji.githubsearcher.model.GithubRepository;
import com.github.intern.yuji.githubsearcher.model.GithubService;
import com.github.intern.yuji.githubsearcher.view.component.RecyclerAdapter;
import com.github.intern.yuji.githubsearcher.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements MainActivityContract {
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GithubService service = GithubClient.githubApiBuilder();
        MainActivityViewModel viewModel = new MainActivityViewModel(this, service);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new RecyclerAdapter();
        binding.recyclerView.setAdapter(adapter);
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
