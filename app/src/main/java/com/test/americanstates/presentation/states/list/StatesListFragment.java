package com.test.americanstates.presentation.states.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import com.test.americanstates.R;
import com.test.americanstates.data.states.list.model.State;
import com.test.americanstates.presentation.application.AmericanStatesApplication;
import com.test.americanstates.presentation.basics.BaseFragment;
import com.test.americanstates.presentation.states.list.adapter.StatesAdapter;
import com.test.americanstates.presentation.states.list.di.DaggerStatesListComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class StatesListFragment extends BaseFragment implements IStatesListContract.IView {

    @BindView(R.id.rvStates_FSL)
    RecyclerView rvStates;
    @BindView(R.id.rbLoading_FSL)
    ProgressBar rbLoading;
    @BindView(R.id.rlError)
    RelativeLayout rlError;
    @Inject
    IStatesListContract.IPresenter presenter;
    @Inject
    StatesAdapter statesAdapter;
    private Relay<Boolean> mRetryRelay = BehaviorRelay.create();

    public static StatesListFragment newInstance() {

        Bundle args = new Bundle();

        StatesListFragment fragment = new StatesListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_states_list);
        inject();
    }

    private void inject() {
        DaggerStatesListComponent.builder()
                .appComponent(AmericanStatesApplication.getApplication().getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(getString(R.string.states));
        setUpAdapter();
        presenter.setView(this);
        presenter.onActivityCreated(savedInstanceState);
    }

    private void setUpAdapter() {
        rvStates.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvStates.setAdapter(statesAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroyView();
    }

    @Override
    public void setStates(List<State> _states) {
        statesAdapter.setStates(_states);
        statesAdapter.notifyDataSetChanged();
        rbLoading.setVisibility(View.GONE);
        rvStates.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoadingIndicator() {
        rvStates.setVisibility(View.GONE);
        rlError.setVisibility(View.GONE);
        rbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        rbLoading.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        rlError.setVisibility(View.VISIBLE);
        rbLoading.setVisibility(View.GONE);
    }

    @Override
    public Relay<Boolean> retry() {
        return mRetryRelay;
    }

    @OnClick(R.id.btnRetry)
    public void onRetryClick() {
        mRetryRelay.accept(true);
    }
}
