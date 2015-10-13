package com.example.paul.retrofitrxandroidexample.View;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.paul.retrofitrxandroidexample.Models.User;

import rx.Observable;

/**
 * Created by Paul on 12/10/15.
 */
public interface GithubLoginView {


    public void showError(String message);

    public void getUser(User user);
}
