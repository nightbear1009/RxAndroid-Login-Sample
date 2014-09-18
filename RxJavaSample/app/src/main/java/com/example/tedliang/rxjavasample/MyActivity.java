package com.example.tedliang.rxjavasample;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.tedliang.rxjavasample.rxjava.login.NormalLogin;
import com.example.tedliang.rxjavasample.rxjava.login.RxFragment;


public class MyActivity extends Activity implements AdapterView.OnItemClickListener {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyAdapter(this));
        listView.setOnItemClickListener(this);
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 0){
            Log.d("Ted","itemClick");
            getFragmentManager().beginTransaction().add(R.id.main, new RxFragment()).addToBackStack("fragment").commit();
        }else if(i==1){
            getFragmentManager().beginTransaction().add(R.id.main, new NormalLogin()).addToBackStack("fragment").commit();
        }
    }
}
