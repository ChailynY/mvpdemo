package com.example.androidtongxuntest.myapplication.presenter;

import com.example.androidtongxuntest.myapplication.model.LoadDataListener;
import com.example.androidtongxuntest.myapplication.model.MainModel;
import com.example.androidtongxuntest.myapplication.view.IMainVIew;

import java.util.List;

/**
 * Created by Lenovo on 2016/8/21.
 */
public class LoadPresenter {

    private IMainVIew iMainVIew ;
    private MainModel mainModel =new MainModel();

    public LoadPresenter(IMainVIew iMainVIew) {
        this.iMainVIew = iMainVIew;
    }

    //加载方法调用model的加载数据
    public void loadData(){
        mainModel.loadData(iMainVIew.getStart(),iMainVIew.getCount(), new LoadDataListener() {
            @Override
            public void loadSuccess(List<String> data) {
                iMainVIew.tip("加载成功");
                iMainVIew.loadData(data);
            }

            @Override
            public void loadFaild(String log) {
                iMainVIew.tip("加载失败"+log);
            }
        });
    }
    public void loadMore(){
        mainModel.loadMore(iMainVIew.getStart(),iMainVIew.getCount(), new LoadDataListener() {
            @Override
            public void loadSuccess(List<String> data) {
                iMainVIew.tip("加载more成功");
                iMainVIew.loadData(data);
            }

            @Override
            public void loadFaild(String log) {
                iMainVIew.tip("加载more失败"+log);
            }


        });
    }
}
