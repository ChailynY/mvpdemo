package com.example.androidtongxuntest.myapplication.model;

import android.util.Log;

import com.example.androidtongxuntest.myapplication.MyAPPlication;
import com.example.androidtongxuntest.myapplication.bean.MovieEntity;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Lenovo on 2016/8/21.
 * 数据逻辑层
 */
public class MainModel implements IMainModel{
    List<String> data=new ArrayList<String>();//模拟加载后的数据
    @Override
    public void loadMore(int start,int count, final LoadDataListener listener) {
        Call<MovieEntity> loadMoreData = MyAPPlication.getiRetrofitService().getData(start,count);
        loadMoreData.enqueue(new Callback<MovieEntity>() {
            @Override
            public void onResponse(Response<MovieEntity> response, Retrofit retrofit) {



                MovieEntity entity= response.body();
                for (int i = 0; i < entity.getSubjects().size(); i++) {
                    MovieEntity.SubjectsBean  subject=entity.getSubjects().get(i);
                    data.add(subject.getTitle()+"_more");
                }


                listener.loadSuccess(data);

            }

            @Override
            public void onFailure(Throwable t) {
                //加载失败


                listener.loadFaild(t.getMessage());
            }
        });


    }

    @Override
    public void loadData(int start,int count,final LoadDataListener listener) {
        Call<MovieEntity> loadMoreData = MyAPPlication.iRetrofitService.getData(start,count);
        loadMoreData.enqueue(new Callback<MovieEntity>() {
            @Override
            public void onResponse(Response<MovieEntity> response, Retrofit retrofit) {
                MovieEntity entity= response.body();
                Log.i("yqy","加载成功"+entity.getCount()+"");
                for (int i = 0; i < entity.getSubjects().size(); i++) {
                    MovieEntity.SubjectsBean  subject=entity.getSubjects().get(i);
                    data.add(subject.getTitle());
                }
                listener.loadSuccess(data);

            }

            @Override
            public void onFailure(Throwable t) {
                listener.loadFaild(t.getMessage());
                Log.i("yqy",""+t.getMessage());
            }
        });
    }
}
