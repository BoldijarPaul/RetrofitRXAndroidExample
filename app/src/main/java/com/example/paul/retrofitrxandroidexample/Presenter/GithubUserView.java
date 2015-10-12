package com.example.paul.retrofitrxandroidexample.Presenter;

import android.support.annotation.NonNull;
import android.view.View;

import rx.Observable;

/**
 * Created by Paul on 12/10/15.
 */
public interface GithubUserView {

    @NonNull
    Observable<View> onSearchClick();

    public void showError(String message);

}
