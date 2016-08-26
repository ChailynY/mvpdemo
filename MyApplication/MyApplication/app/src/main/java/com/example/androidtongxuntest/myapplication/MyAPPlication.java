package com.example.androidtongxuntest.myapplication;

import android.app.Application;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Lenovo on 2016/8/21.
 */
public class MyAPPlication extends Application {
    public static IRetrofitService iRetrofitService;

    public static IRetrofitService getiRetrofitService() {
        return iRetrofitService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iRetrofitService = retrofit.create(IRetrofitService.class);
    }
}
