package com.test.americanstates.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.americanstates.R;
import com.test.americanstates.presentation.states.list.StatesListFragment;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class MainActivity extends AppCompatActivity {

    public static Intent getCallingIntent(Context _context) {
        return new Intent(_context, MainActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.toolbar));

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer_AM, StatesListFragment.newInstance())
                    .commit();
        }
    }
}
