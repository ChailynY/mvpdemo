package com.example.androidtongxuntest.myapplication;


import com.example.androidtongxuntest.myapplication.bean.MovieEntity;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Lenovo on 2016/8/21.
 */
public interface IRetrofitService {
    @GET("top250")
    Call<MovieEntity> getData(@Query("start") int start,@Query("count") int count);


}
