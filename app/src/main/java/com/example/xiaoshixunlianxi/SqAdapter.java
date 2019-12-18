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

import java.util.List;

class SqAdapter extends RecyclerView.Adapter<SqAdapter.ViewHolder> {
    private List<Bean> list;
    private Context context;

    public SqAdapter(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sq_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bean bean = list.get(position);
        holder.tv.setText(bean.getTitle());
        Glide.with(context).load(bean.getImagePath()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
