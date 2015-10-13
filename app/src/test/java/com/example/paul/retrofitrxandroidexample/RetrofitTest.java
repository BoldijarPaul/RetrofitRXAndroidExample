package com.example.paul.retrofitrxandroidexample;

import com.example.paul.retrofitrxandroidexample.Models.User;
import com.example.paul.retrofitrxandroidexample.RetrofitApi.GithubServiceApi;

import org.junit.Test;

import static org.junit.Assert.*;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by BoldijarPaul on 13/10/15.
 */
public class RetrofitTest {

    @Test
    public void testGithubService() {
        User user = createServiceApi().getUserByLogin("boldijarpaul");
        assertEquals(user.getName(), "Boldijar Paul");
    }

    private GithubServiceApi createServiceApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(GithubServiceApi.class);
    }
}
