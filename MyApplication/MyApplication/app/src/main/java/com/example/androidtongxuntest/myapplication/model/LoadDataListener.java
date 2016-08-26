package com.example.androidtongxuntest.myapplication.model;

import java.util.List;

/**
 * Created by Lenovo on 2016/8/21.
 */
public interface LoadDataListener {
    void  loadSuccess(List<String> data);
    void  loadFaild(String log);
}
