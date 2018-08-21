package com.test.americanstates.data.api.client;

import com.test.americanstates.data.states.list.model.StateListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public interface AmericanStatesService {

    @GET("state/get/USA/all")
    @Headers("Content-Type: application/json")
    Observable<StateListResponse> getStates();
}
