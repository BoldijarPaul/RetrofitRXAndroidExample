package com.example.paul.retrofitrxandroidexample.Dagger;

import android.app.Application;
import android.content.Context;

/**
 * Created by BoldijarPaul on 14/10/15.
 */
public class DaggerApplication extends Application {

    private GithubComponent githubComponent;

    public static DaggerApplication getApplication(Context context) {
        return (DaggerApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        githubComponent = DaggerGithubComponent.builder().build();


    }


    public GithubComponent getGithubComponent() {
        return githubComponent;
    }
}
