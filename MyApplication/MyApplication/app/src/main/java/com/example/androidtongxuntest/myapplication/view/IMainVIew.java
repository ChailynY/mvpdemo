package com.example.androidtongxuntest.myapplication.view;

import com.example.androidtongxuntest.myapplication.model.LoadDataListener;

import java.util.List;

/**
 * Created by Lenovo on 2016/8/21.
 */
public interface IMainVIew {

    /**
     * 提示
     * @param content
     */
    void tip(String content);

    /**
     * 加载数据
     */
    void loadData(List<String> data);

    /**
     * 加载更多

     */
    void loadMore(List<String> data);


    /**
     获取参数
     */
    int getCount();
    int getStart();

}
