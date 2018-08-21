package com.test.americanstates.presentation.states.list.di;

import com.test.americanstates.data.states.list.repository.GetStateListRepository;
import com.test.americanstates.data.states.list.repository.IGetStateListRepository;
import com.test.americanstates.domain.states.list.GetStatesListInteractor;
import com.test.americanstates.domain.states.list.IGetStatesListInteractor;
import com.test.americanstates.presentation.basics.annotation.PerFragment;
import com.test.americanstates.presentation.states.list.IStatesListContract;
import com.test.americanstates.presentation.states.list.StatesListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */

@Module
public class StatesListModule {

    @PerFragment
    @Provides
    protected IStatesListContract.IPresenter providePresenter(StatesListPresenter _presenter) {
        return _presenter;
    }

    @PerFragment
    @Provides
    protected IGetStatesListInteractor provideInteractor(GetStatesListInteractor _interactor) {
        return _interactor;
    }

    @PerFragment
    @Provides
    protected IGetStateListRepository provideRepository(GetStateListRepository _repository) {
        return _repository;
    }
}
