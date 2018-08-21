package com.test.americanstates.presentation.states.list;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jakewharton.rxrelay2.Relay;
import com.test.americanstates.data.states.list.model.State;

import java.util.List;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public interface IStatesListContract {

    interface IView {
        void setStates(List<State> _states);

        void showLoadingIndicator();
        void hideLoadingIndicator();
        void showError();

        Relay<Boolean> retry();
    }

    interface IPresenter {

        void setView(IView _view);
        void onActivityCreated(@Nullable Bundle _savedInstanceState);
        void onDestroyView();
    }
}
