package com.test.americanstates.presentation.basics;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public abstract class BaseFragment extends Fragment {

    private int mLayoutRes = -1;
    protected Unbinder mUnBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mLayoutRes == -1)
            throw new RuntimeException("You have to call setContentView!");

        return inflater.inflate(mLayoutRes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnBinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
    }

    protected void setContentView(@LayoutRes int _resLayout) {
        mLayoutRes = _resLayout;
    }
}
