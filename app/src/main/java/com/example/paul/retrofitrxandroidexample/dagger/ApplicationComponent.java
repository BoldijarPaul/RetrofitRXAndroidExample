package com.example.paul.retrofitrxandroidexample.dagger;

import com.example.paul.retrofitrxandroidexample.AppApplication;
import com.example.paul.retrofitrxandroidexample.Modules.GithubModules;

import dagger.Component;

/**
 * Created by BoldijarPaul on 14/10/15.
 */
@Component(
        modules = GithubModules.class
)
public interface ApplicationComponent {
    AppApplication injectApplication(AppApplication application);
}