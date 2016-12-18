package com.example.baserecycleviewdemo.adapter;

import android.support.v7.widget.RecyclerView;

import com.example.baserecycleviewdemo.R;
import com.example.baserecycleviewdemo.base.BaseRecyclerAdapter;
import com.example.baserecycleviewdemo.base.RecyclerHolder;
import com.example.baserecycleviewdemo.bean.Meizi;

import java.util.Collection;

/**
 * Description：
 * Author：lxl
 * Date： 2016/12/17 18:37
 */
public class ExampleAdapter  extends BaseRecyclerAdapter<Meizi> {
    public ExampleAdapter(RecyclerView v, Collection<Meizi> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }

    @Override
    public void convert(RecyclerHolder holder, Meizi item, int position) {
        holder.setImageResource(R.id.iv_item,item.getUrl());
        holder.setText(R.id.tv_item,item.getWho());
    }
}
