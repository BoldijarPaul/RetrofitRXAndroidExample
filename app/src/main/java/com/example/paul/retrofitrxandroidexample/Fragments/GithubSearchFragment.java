package com.example.paul.retrofitrxandroidexample.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paul.retrofitrxandroidexample.Models.User;
import com.example.paul.retrofitrxandroidexample.Presenter.GithubLoginPresenter;
import com.example.paul.retrofitrxandroidexample.View.GithubLoginView;
import com.example.paul.retrofitrxandroidexample.R;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.view.ViewClickEvent;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * A simple {@link Fragment} subclass.
 */
public class GithubSearchFragment extends Fragment implements GithubLoginView {

    @Bind(R.id.fragment_github_search_login)
    EditText mUserLogin;
    @Bind(R.id.fragment_github_search_button)
    Button mSearchButton;
    @Bind(R.id.fragment_github_search_text)
    TextView mResultTextView;



    private GithubLoginPresenter mPresenter;

    public GithubSearchFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_github_search, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.sleep();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mPresenter == null) {
            mPresenter = new GithubLoginPresenter(this);
        }
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter.wakeUp();
    }

    @Override
    public void showError(@StringRes int id) {
        Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void presentUser(User user) {
        mResultTextView.setText(user.toString());
    }


    @Override
    public Observable<ViewClickEvent> submitClick() {
        return RxView.clickEvents(mSearchButton);
    }

    @Override
    public String getLoginText() {
        return mUserLogin.getText().toString().trim();
    }


}
