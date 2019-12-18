package com.example.xiaoshixunlianxi;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xiaoshixunlianxi.db.BeanDao;

import java.util.List;

import presenter.NetPresenter;
import view.NetView;

public class PageOneFragment extends Fragment implements NetView {
    int count;
    private RecyclerView mMyrec;
    private MyAdapter adapter;
    private NetPresenter netPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_one_fragment, null);
        netPresenter = new NetPresenter(this);
        initView(view);
        return view;
    }

    private void initView(@NonNull final View itemView) {
        mMyrec = (RecyclerView) itemView.findViewById(R.id.myrec);
        mMyrec.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMyrec.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        adapter = new MyAdapter(getActivity());
        mMyrec.setAdapter(adapter);
        netPresenter.getData();
        registerForContextMenu(mMyrec);
        adapter.setClickItem(new MyAdapter.ClickItem() {
            @Override
            public void longItem(int pos) {
                count=pos;
            }
        });
    }

    @Override
    public void setData(List<ListBeen.ResultsBean> list) {
        adapter.initList(list);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(1,1,1,"收藏");
        menu.add(1,2,2,"删除");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                List<ListBeen.ResultsBean> list = adapter.getList();
                ListBeen.ResultsBean resultsBean = list.get(count);
                BeanDao beanDao = BaseApp.getInstance().getDaoSession().getBeanDao();
                beanDao.insert(new Bean(null,resultsBean.getUrl(),resultsBean.getDesc()));
                Toast.makeText(getActivity(), "收藏成功", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                adapter.setdelete(count);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
