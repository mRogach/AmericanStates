package com.test.americanstates.presentation.states.list.di;

import com.test.americanstates.presentation.application.di.AppComponent;
import com.test.americanstates.presentation.basics.annotation.PerFragment;
import com.test.americanstates.presentation.states.list.StatesListFragment;

import dagger.Component;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
@PerFragment
@Component(dependencies = AppComponent.class, modules = StatesListModule.class)
public interface StatesListComponent {
    void inject(StatesListFragment _fragment);
}
