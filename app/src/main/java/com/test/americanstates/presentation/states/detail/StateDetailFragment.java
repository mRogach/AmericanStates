package com.test.americanstates.presentation.states.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.test.americanstates.R;
import com.test.americanstates.data.states.list.model.State;
import com.test.americanstates.presentation.basics.BaseFragment;

import butterknife.BindView;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class StateDetailFragment extends BaseFragment {

    private static String STATE = "state";

    @BindView(R.id.tvCapital_FSD)
    TextView tvCapital;
    @BindView(R.id.tvLargestCity_FSD)
    TextView tvLargestCity;
    @BindView(R.id.tvStateId_FSD)
    TextView tvStateId;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static StateDetailFragment newInstance(State state) {

        Bundle args = new Bundle();
        args.putSerializable(STATE, state);
        StateDetailFragment fragment = new StateDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_state_detail);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        renderUI();
    }

    private void renderUI() {
        State state = (State) getArguments().getSerializable(STATE);
        if (state == null) return;

        tvCapital.setText(state.getCapital());
        tvLargestCity.setText(state.getLargestCity());
        tvStateId.setText(String.valueOf(state.getId()));

        getActivity().setTitle(String.format("%1$s, %2$s, %3$s", state.getName(), state.getCountry(), state.getAbbr()));
    }

    @Override
    protected Toolbar getToolbar() {
        return toolbar;
    }
}
