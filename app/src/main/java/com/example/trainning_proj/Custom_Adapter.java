package com.example.trainning_proj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {
    Context context;
    ArrayList<String> data;
    int resource;

    public Custom_Adapter(Context c, int x, ArrayList<String> data)
    {
        this.context=c;
        this.data=data;
        this.resource=x;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View v=view;

        if(v==null) {
            v = LayoutInflater.from(context).inflate(resource, null, false);
        }

        TextView tv=v.findViewById(android.R.id.text1);

        String names = (String) getItem(i);

        tv.setText(names);
        return v;
    }
}
