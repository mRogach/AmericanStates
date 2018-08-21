package com.test.americanstates.presentation.application.di;

import com.test.americanstates.presentation.application.AmericanStatesApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
@Singleton
@Component()
public interface AppComponent {

    void inject(AmericanStatesApplication _app);
}
