package com.test.americanstates.presentation.application.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */

@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context _context) {
        this.mContext = _context;
    }

    @Singleton
    @Provides
    protected Context provideContext() {
        return mContext;
    }
}
