package com.example.xiaoshixunlianxi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private static final int ONE_INDEX=1;
    private static final int TWO_INDEX=2;
    private List<ListBeen.ResultsBean> list=new ArrayList<>();
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void initList(List<ListBeen.ResultsBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public List<ListBeen.ResultsBean> getList() {
        return list;
    }

    public void setdelete(int poss){
        this.list.remove(poss);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case ONE_INDEX:
                View view= LayoutInflater.from(context).inflate(R.layout.one_item,parent,false);
                return new OneViewHolder(view);
            case TWO_INDEX:
                View root=LayoutInflater.from(context).inflate(R.layout.two_item,parent,false);
                return new TwoViewHolder(root);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);
        switch (type){
            case ONE_INDEX:
                ListBeen.ResultsBean resultsBean = list.get(position);
                ((OneViewHolder)holder).titl.setText(resultsBean.getDesc());
                RequestOptions requestOption = new RequestOptions();
                RequestOptions option = requestOption.circleCrop();
                Glide.with(context).load(resultsBean.getUrl()).apply(option).into(((OneViewHolder)holder).imag);
                ((OneViewHolder)holder).itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (clickItem!=null){
                            clickItem.longItem(position);
                        }
                        return false;
                    }
                });
                break;
            case TWO_INDEX:
                ListBeen.ResultsBean bean = list.get(position);
                ((TwoViewHolder)holder).types.setText(bean.getDesc());
                RequestOptions requestOptions = new RequestOptions();
                RequestOptions options = requestOptions.circleCrop();
                Glide.with(context).load(bean.getUrl()).apply(options).into(((TwoViewHolder)holder).images);
                ((TwoViewHolder)holder).itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (clickItem!=null){
                            clickItem.longItem(position);
                        }
                        return false;
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return ONE_INDEX;
        }else {
            return TWO_INDEX;
        }
    }

    public class OneViewHolder extends RecyclerView.ViewHolder {
        ImageView imag;
        TextView titl;
        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            imag=itemView.findViewById(R.id.imag);
            titl=itemView.findViewById(R.id.titl);
        }
    }
    public class TwoViewHolder extends RecyclerView.ViewHolder{
        ImageView images;
        TextView types;
        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            images=itemView.findViewById(R.id.images);
            types=itemView.findViewById(R.id.types);
        }
    }
    ClickItem clickItem;

    public void setClickItem(ClickItem clickItem) {
        this.clickItem = clickItem;
    }

    interface ClickItem{
        void longItem(int pos);
    }
}
