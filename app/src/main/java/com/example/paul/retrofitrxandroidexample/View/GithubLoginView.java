package com.example.paul.retrofitrxandroidexample.View;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;

import com.example.paul.retrofitrxandroidexample.Models.User;
import com.jakewharton.rxbinding.view.ViewClickEvent;

import rx.Observable;

/**
 * Created by Paul on 12/10/15.
 */
public interface GithubLoginView {


    public void showError(@StringRes int messageId);


    public void presentUser(User user);

    public Observable<ViewClickEvent> submitClick();

    public String getLoginText();
}
