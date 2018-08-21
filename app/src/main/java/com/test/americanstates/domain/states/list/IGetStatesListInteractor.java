package com.test.americanstates.domain.states.list;

import com.test.americanstates.data.states.list.model.State;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public interface IGetStatesListInteractor {

    Observable<List<State>> getStates();
}
