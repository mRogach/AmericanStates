package com.test.americanstates.data.api.client;


import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;



/**
 * Created by
 * Mykhailo on 8/21/2018.
 */

@Singleton
public class AmericanStatesRestClient extends BaseRestClient {

    private AmericanStatesService americanStatesService;

    @Inject
    public AmericanStatesRestClient() {
        setupLandmarkRestClient();
    }

    private void setupLandmarkRestClient() {
        Retrofit retrofit = getRetrofitBuilder().client(getOkHttpClient()).build();
        americanStatesService = retrofit.create(AmericanStatesService.class);
    }

    public AmericanStatesService getAmericanStatesService() {
        return americanStatesService;
    }
}
