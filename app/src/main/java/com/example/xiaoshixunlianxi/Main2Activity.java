package com.example.xiaoshixunlianxi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mPage;
    private PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mPage = (ViewPager) findViewById(R.id.page);
        List<View> list=new ArrayList<>();
        View view1= LayoutInflater.from(this).inflate(R.layout.page1,null);
        View view2= LayoutInflater.from(this).inflate(R.layout.page2,null);
        View view3= LayoutInflater.from(this).inflate(R.layout.page3,null);
        View view4= LayoutInflater.from(this).inflate(R.layout.page4,null);
        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);
        pageAdapter = new PageAdapter(list);
        mPage.setAdapter(pageAdapter);
        Button bt = view4.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}
