package com.example.paul.retrofitrxandroidexample.presenters;

/**
 * usage of the RxPresenter in a Fragment
 */
public class ViewFragment extends Fragment  {

    private RxPresenter mPresenter;

    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);

        if (mPresenter == null) {
            mPresenter = new SomePresenter(this, activity.getApplicationContext());
        }
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
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.wakeUp();
    }
}