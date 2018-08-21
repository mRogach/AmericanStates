package com.test.americanstates.data.states.list.repository;

import com.test.americanstates.data.states.list.model.StateListResponse;

import io.reactivex.Observable;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public interface IGetStateListRepository {

    Observable<StateListResponse> getStates();
}
