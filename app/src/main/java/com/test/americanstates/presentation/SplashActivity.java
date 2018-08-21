package com.test.americanstates.presentation;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.americanstates.R;


/**
 * Created by
 * Mykhailo on 8/21/2018.
 */

public class SplashActivity extends AppCompatActivity {

    private static final int DELAY = 2000;

    private Handler mHandler = new Handler();

    private Runnable mRunnable = () -> {
        startActivity(MainActivity.getCallingIntent(SplashActivity.this));
        finish();
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mHandler != null) {
            mHandler.postDelayed(mRunnable, DELAY);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
        }
    }
}
