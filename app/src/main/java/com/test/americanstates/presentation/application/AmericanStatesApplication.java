package com.test.americanstates.presentation.application;

import android.app.Application;

import com.test.americanstates.data.api.client.AmericanStatesRestClient;
import com.test.americanstates.presentation.application.di.AppComponent;
import com.test.americanstates.presentation.application.di.AppModule;
import com.test.americanstates.presentation.application.di.DaggerAppComponent;

import javax.inject.Inject;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class AmericanStatesApplication extends Application {

    private static AmericanStatesApplication instance;
    private AppComponent appComponent;
    @Inject
    AmericanStatesRestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createComponent();
    }

    private void createComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        appComponent.inject(this);
    }

    public static AmericanStatesApplication getApplication() {
        return instance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public AmericanStatesRestClient getRestClient() {
        return restClient;
    }
}
