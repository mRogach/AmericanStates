package com.test.americanstates.domain.states.list;

import com.test.americanstates.data.states.list.model.State;
import com.test.americanstates.data.states.list.repository.IGetStateListRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class GetStatesListInteractor implements IGetStatesListInteractor {

    private IGetStateListRepository iGetStateListRepository;

    @Inject
    public GetStatesListInteractor(IGetStateListRepository _iGetStateListRepository) {
        iGetStateListRepository = _iGetStateListRepository;
    }

    @Override
    public Observable<List<State>> getStates() {
        return iGetStateListRepository.getStates()
                .map(stateListResponse -> stateListResponse.getStateList().getStates())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
