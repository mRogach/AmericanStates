package com.test.americanstates.data.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.americanstates.data.api.client.ApiConstants.READTIMEOUT;
import static com.test.americanstates.data.api.client.ApiConstants.WRITETIMEOUT;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */

public abstract class BaseRestClient {

    protected Retrofit.Builder getRetrofitBuilder() {

        Gson gson = new GsonBuilder()
                .create();

        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    protected OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .writeTimeout(WRITETIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READTIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(READTIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

}
