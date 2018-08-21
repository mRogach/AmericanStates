package com.test.americanstates.data.states.list.repository;

import com.test.americanstates.data.states.list.model.StateListResponse;
import com.test.americanstates.presentation.application.AmericanStatesApplication;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class GetStateListRepository implements IGetStateListRepository {

    @Inject
    public GetStateListRepository() {
    }

    @Override
    public Observable<StateListResponse> getStates() {
        return AmericanStatesApplication.getApplication().getRestClient().getAmericanStatesService().getStates();
    }
}
