package com.example.androidtongxuntest.myapplication.model;

/**
 * Created by Lenovo on 2016/8/21.
 */
public interface IMainModel {

    void loadMore(int start,int count,LoadDataListener listener);
    void loadData(int start,int count,LoadDataListener listener);
}
