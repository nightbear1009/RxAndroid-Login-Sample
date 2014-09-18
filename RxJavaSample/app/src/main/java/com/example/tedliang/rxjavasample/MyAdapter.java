package com.example.tedliang.rxjavasample;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<String> list;
    private LayoutInflater inflater;
    public MyAdapter(Context context){
        inflater = LayoutInflater.from(context);
        list = new ArrayList<String>();
        list.add("rxJava Login");
        list.add("normal Login");
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.listviewlayout,null);
        TextView txt = (TextView)view.findViewById(R.id.layout_view);
        txt.setText(list.get(i));
        return view;
    }
}
