package com.example.paul.retrofitrxandroidexample.Dagger;

import com.example.paul.retrofitrxandroidexample.Presenter.GithubLoginPresenter;
import com.example.paul.retrofitrxandroidexample.RetrofitApi.GithubServiceApi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by BoldijarPaul on 14/10/15.
 */
@Singleton
@Component(
        modules = GithubModules.class
)
public interface GithubComponent {
    void inject(GithubLoginPresenter githubLoginPresenter);
}
