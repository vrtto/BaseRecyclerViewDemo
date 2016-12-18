package com.example.baserecycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.baserecycleviewdemo.adapter.ExampleAdapter;
import com.example.baserecycleviewdemo.base.BaseRecyclerAdapter;
import com.example.baserecycleviewdemo.bean.Meizi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BaseRecyclerAdapter.OnItemLongClickListener,BaseRecyclerAdapter.OnItemClickListener {

    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    private ExampleAdapter adapter;
    private List<Meizi> meizis = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initview();
    }


    private void initview() {

        String[] stringArray = getResources().getStringArray(R.array.urls);
        for (int i = 0; i < stringArray.length; i++) {
            Meizi mz = new Meizi(stringArray[i], i + "");
            meizis.add(mz);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvContent.setLayoutManager(layoutManager);
        adapter = new ExampleAdapter(rvContent, meizis, R.layout.item_layout);
        rvContent.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemLongClick(View view, Object data, int position) {
        Toast.makeText(this,"你长点击了"+meizis.get(position).getWho(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClick(View view, Object data, int position) {
        Toast.makeText(this,"你点击了"+meizis.get(position).getWho(),Toast.LENGTH_SHORT).show();
    }
}
