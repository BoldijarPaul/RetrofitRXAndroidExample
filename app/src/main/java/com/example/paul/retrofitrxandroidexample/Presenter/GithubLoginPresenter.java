package com.example.paul.retrofitrxandroidexample.Presenter;

import android.view.View;

import com.example.paul.retrofitrxandroidexample.Models.User;
import com.example.paul.retrofitrxandroidexample.R;
import com.example.paul.retrofitrxandroidexample.RetrofitApi.GithubServiceApi;
import com.example.paul.retrofitrxandroidexample.View.GithubLoginView;
import com.jakewharton.rxbinding.view.ViewClickEvent;

import java.io.IOException;


import javax.inject.Inject;

import retrofit.RestAdapter;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by BoldijarPaul on 13/10/15.
 */
public class GithubLoginPresenter extends RxPresenter<GithubLoginView> {


    public GithubLoginPresenter(GithubLoginView githubLoginView) {
        super(githubLoginView);
    }

    @Inject
    private GithubServiceApi githubServiceApi;

    @Override
    public void wakeUp() {
        super.wakeUp();
        Subscription subscription = getView().submitClick().subscribe(new Action1<ViewClickEvent>() {

            @Override
            public void call(ViewClickEvent viewClickEvent) {

                if (getView().getLoginText().isEmpty()) {
                    getView().showError(R.string.msg_empty_et);
                } else {
                    doRequestForUser();
                }

            }
        });
        manageViewSubscription(subscription);

    }

    private void doRequestForUser() {
        getUser().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(R.string.msg_server_error);
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(User user) {
                        getView().presentUser(user);
                    }
                });
    }

    public Observable<User> getUser() {
        return githubServiceApi.getUserByLogin(getView().getLoginText());
    }


}
