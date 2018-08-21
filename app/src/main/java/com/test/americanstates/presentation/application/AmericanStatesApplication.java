package com.test.americanstates.presentation.application;

import android.app.Application;

import com.test.americanstates.data.api.client.AmericanStatesRestClient;
import com.test.americanstates.presentation.application.di.DaggerAppComponent;

import javax.inject.Inject;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class AmericanStatesApplication extends Application {

    private static AmericanStatesApplication instance;
    @Inject
    AmericanStatesRestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        inject();
    }

    private void inject() {
        DaggerAppComponent.builder()
                .build()
                .inject(this);
    }

    public static AmericanStatesApplication getApplication() {
        return instance;
    }

    public AmericanStatesRestClient getRestClient() {
        return restClient;
    }
}
