package com.example.androidtongxuntest.myapplication.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidtongxuntest.myapplication.R;
import com.example.androidtongxuntest.myapplication.model.LoadDataListener;
import com.example.androidtongxuntest.myapplication.presenter.LoadPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity  implements IMainVIew {

    private LoadPresenter loadPresenter;

    ListView listView;
    private ArrayAdapter adapter;
    private  List<String> datas=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listview);
        loadPresenter =new LoadPresenter(this);
        loadPresenter.loadData();


    }



    @Override
    public void loadData(List<String> data) {
        datas=data;
        adapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,datas);

        listView.setAdapter(adapter);

    }

    @Override
    public void loadMore(List<String> data) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void tip(String content) {
        Toast.makeText(this,content,Toast.LENGTH_LONG).show();

    }

    @Override
    public int getCount() {
        //应该是返回某一个view获取的输入值
        return 10;
    }

    @Override
    public int getStart() {
        return 0;
    }

    public  void loadMore(View view){
        loadPresenter.loadMore();
    }
}

