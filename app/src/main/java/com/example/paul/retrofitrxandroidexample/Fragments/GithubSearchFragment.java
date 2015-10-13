package com.example.paul.retrofitrxandroidexample.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paul.retrofitrxandroidexample.Presenter.GithubUserView;
import com.example.paul.retrofitrxandroidexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GithubSearchFragment extends Fragment implements GithubUserView {

    private EditText mUserLogin;
    private Button mSearchButton;
    private TextView mResultTextView;

    public GithubSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_github_search, container, false);
        mUserLogin = (EditText) view.findViewById(R.id.fragment_github_search_login);
        mSearchButton = (Button) view.findViewById(R.id.fragment_github_search_button);
        mResultTextView = (TextView) view.findViewById(R.id.fragment_github_search_text);
        return view;
    }


    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), getActivity().getString(R.string.msg_error_login), Toast.LENGTH_SHORT).show();
    }
}
