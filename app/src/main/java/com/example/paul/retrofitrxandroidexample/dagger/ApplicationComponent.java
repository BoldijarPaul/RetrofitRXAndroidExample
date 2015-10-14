package com.example.paul.retrofitrxandroidexample.dagger;

import com.example.paul.retrofitrxandroidexample.AppApplication;
import com.example.paul.retrofitrxandroidexample.Modules.GithubModules;

import dagger.Component;

@Component(
        modules = GithubModules.class
)
interface DemoApplicationComponent {
        AppApplication injectApplication(AppApplication application);
}