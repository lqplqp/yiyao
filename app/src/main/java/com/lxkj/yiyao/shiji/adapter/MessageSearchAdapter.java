package com.lxkj.yiyao.shiji.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class MessageSearchAdapter extends MBaseAdapter<MessageSearchAdapter.ViewHolder> {
    public MessageSearchAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.faburen.setText(""+result.get("faburen"));
        holder.number.setText(""+result.get("number"));
        holder.peixunDate.setText(""+result.get("peixunDate"));
        holder.peixundidian.setText(""+result.get("peixundidian"));
        holder.peixunOver.setText(""+result.get("peixunOver"));
        holder.tongzhibiaoti.setText(""+result.get("tongzhibiaoti"));
        holder.tongzhidanwei.setText(""+result.get("tongzhidanwei"));
        holder.wangshangpeixun.setText(""+result.get("wangshangpeixun"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.messagesearch_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.number)
        TextView number;
        @BindView(R.id.wangshangpeixun)
        TextView wangshangpeixun;
        @BindView(R.id.tongzhidanwei)
        TextView tongzhidanwei;
        @BindView(R.id.faburen)
        TextView faburen;
        @BindView(R.id.tongzhibiaoti)
        TextView tongzhibiaoti;
        @BindView(R.id.peixundidian)
        TextView peixundidian;
        @BindView(R.id.peixunDate)
        TextView peixunDate;
        @BindView(R.id.peixunOver)
        TextView peixunOver;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
