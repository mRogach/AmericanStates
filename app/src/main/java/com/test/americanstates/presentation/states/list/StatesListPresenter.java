package com.test.americanstates.presentation.states.list;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.test.americanstates.data.states.list.model.State;
import com.test.americanstates.domain.states.list.IGetStatesListInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class StatesListPresenter implements IStatesListContract.IPresenter {

    private IStatesListContract.IView view;
    private IGetStatesListInteractor iGetStatesListInteractor;
    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public StatesListPresenter(IGetStatesListInteractor _iGetStatesListInteractor) {
        iGetStatesListInteractor = _iGetStatesListInteractor;
    }


    @Override
    public void setView(IStatesListContract.IView _view) {
        view = _view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        setUpStream();
    }

    @Override
    public void onDestroyView() {
        disposable.clear();
    }

    @Override
    public void onItemClick(State _state) {
        view.onItemClick(_state);
    }

    private void setUpStream() {
        Observable<List<State>> states = iGetStatesListInteractor.getStates()
                .doOnSubscribe(disposable -> view.showLoadingIndicator())
                .onErrorResumeNext(observer -> {
                    view.hideLoadingIndicator();
                    view.showError();
                });
        Observable<List<State>> retry = view.retry().switchMap(aBoolean -> states);

        disposable.addAll(states.mergeWith(retry).subscribe(statesConsumer));
    }

    private Consumer<List<State>> statesConsumer = states -> {
        view.hideLoadingIndicator();
        view.setStates(states);
    };
}
