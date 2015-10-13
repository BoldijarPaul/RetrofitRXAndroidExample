package com.example.paul.retrofitrxandroidexample.RetrofitApi;

import com.example.paul.retrofitrxandroidexample.Models.User;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Paul on 12/10/15.
 */
public interface GithubServiceApi {

    @GET("/users/{login}")
    public Observable<User> getUserByLogin(@Path("login") String login);
}
