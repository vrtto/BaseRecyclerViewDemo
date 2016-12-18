package com.example.baserecycleviewdemo.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Description：适配所以的RecyclerView.ViewHolder
 * Author：lxl
 * Date： 2016/12/17 16:02
 */
public class RecyclerHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;//集合类,以view的id作为key，value是view对象(SparseArray比HashMap更省内存,只能存储key为int类型的数据)
    public RecyclerHolder(View itemView) {
        super(itemView);
        this.mViews=new SparseArray<View>();
    }

    /**
     * 这种写法代替用findViewById的写法来保存引用在holder对象当中，用SparseArray集合来保存对象引用
     * @param viewId  控件的id
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);//itemView在构造方法传进去了
            mViews.put(viewId, view);
        }
        return (T) view;
    }
    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public RecyclerHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }
    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public RecyclerHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }
    /**
     * 为ImageView设置图片,设置加载时图片
     *
     * @param viewId
     * @param url
     * @return
     */
    public RecyclerHolder setImageResource(int viewId, String url) {
        ImageView view = getView(viewId);
        Glide.with(view.getContext()).load(url).into(view);
        return this;
    }
    /**
     *
     *
     * 类似的方法根据自己需求自己添加
     *
     *
     */
}
