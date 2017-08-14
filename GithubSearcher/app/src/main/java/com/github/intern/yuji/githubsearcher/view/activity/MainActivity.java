package com.github.intern.yuji.githubsearcher.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.intern.yuji.githubsearcher.R;
import com.github.intern.yuji.githubsearcher.contract.MainActivityContract;
import com.github.intern.yuji.githubsearcher.databinding.ActivityMainBinding;
import com.github.intern.yuji.githubsearcher.model.GithubClient;
import com.github.intern.yuji.githubsearcher.model.GithubRepository;
import com.github.intern.yuji.githubsearcher.model.GithubService;
import com.github.intern.yuji.githubsearcher.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements MainActivityContract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GithubService service = GithubClient.githubApiBuilder();
        MainActivityViewModel viewModel = new MainActivityViewModel(this, service);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(viewModel);
    }

    @Override
    public void showRepository(GithubRepository repository) {

    }

    @Override
    public void showError(String message) {

    }
}
