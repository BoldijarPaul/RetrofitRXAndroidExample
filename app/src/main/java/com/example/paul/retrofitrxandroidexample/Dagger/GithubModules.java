package com.example.paul.retrofitrxandroidexample.Dagger;

import com.example.paul.retrofitrxandroidexample.RetrofitApi.GithubServiceApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by BoldijarPaul on 13/10/15.
 */
@Module
public class GithubModules {


    @Provides
    @Singleton
    public RestAdapter provideRestAdapter() {
        return new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

    }

    @Provides
    @Singleton
    public GithubServiceApi provideGithubServiceApi() {
        return provideRestAdapter().create(GithubServiceApi.class);
    }


}
