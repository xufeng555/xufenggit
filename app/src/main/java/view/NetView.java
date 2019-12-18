package view;

import com.example.xiaoshixunlianxi.ListBeen;

import java.util.List;

public interface NetView {
    void setData(List<ListBeen.ResultsBean> list);
    void showToast(String str);
}
