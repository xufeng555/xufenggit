package com.example.xiaoshixunlianxi;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager mViewPage;
    private TabLayout mTablayout;
    private NavigationView mNavigation;
    private DrawerLayout mDrawer;
    private LinearLayout mContent;
    private VpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initFragment();
    }

    private void initFragment() {
        mViewPage = (ViewPager) findViewById(R.id.viewPage);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new PageOneFragment());
        fragmentList.add(new PageTwoFragment());
        fragmentList.add(new pageThreeFragment());
        adapter = new VpAdapter(getSupportFragmentManager(), fragmentList);
        mViewPage.setAdapter(adapter);
        mTablayout.addTab(mTablayout.newTab().setText("首页"));
        mTablayout.addTab(mTablayout.newTab().setText("收藏"));
        mTablayout.addTab(mTablayout.newTab().setText("地图"));
        mTablayout.setupWithViewPager(mViewPage);
        mTablayout.getTabAt(0).setText("首页");
        mTablayout.getTabAt(1).setText("收藏");
        mTablayout.getTabAt(2).setText("地图");
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigation = (NavigationView) findViewById(R.id.navigation);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        mContent = (LinearLayout) findViewById(R.id.content);

        mToolbar.setTitle("首页");
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open, R.string.close);
        mDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}
