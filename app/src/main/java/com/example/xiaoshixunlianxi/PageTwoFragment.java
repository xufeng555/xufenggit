package com.example.xiaoshixunlianxi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xiaoshixunlianxi.db.BeanDao;

import java.util.ArrayList;
import java.util.List;

public class PageTwoFragment extends Fragment {
    private RecyclerView mRec;
    private SqAdapter sqAdapter;
    private List<Bean> list;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_two_fragment, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        BeanDao beanDao = BaseApp.getInstance().getDaoSession().getBeanDao();
        List<Bean> list1 = beanDao.loadAll();
        list.clear();
        list.addAll(list1);
        sqAdapter = new SqAdapter(list, getActivity());
        mRec.setAdapter(sqAdapter);
        sqAdapter.notifyDataSetChanged();
    }

    private void initView(@NonNull final View itemView) {
        mRec = (RecyclerView) itemView.findViewById(R.id.rec);
        mRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRec.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }
}
