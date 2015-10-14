package com.example.paul.retrofitrxandroidexample.Modules;

import com.example.paul.retrofitrxandroidexample.Presenter.GithubLoginPresenter;
import com.example.paul.retrofitrxandroidexample.RetrofitApi.GithubServiceApi;
import com.example.paul.retrofitrxandroidexample.View.GithubLoginView;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by BoldijarPaul on 13/10/15.
 */
@Module
public class GithubModules {

    public GithubLoginPresenter provideGithubLoginPresenter(GithubLoginView githubLoginView) {
        return new GithubLoginPresenter(githubLoginView);
    }

    @Provides
    public GithubServiceApi provideGithubServiceApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();
        return restAdapter.create(GithubServiceApi.class);
    }
}
