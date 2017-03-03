package com.lxkj.yiyao.shiji.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class CompanyUserAdapter extends MBaseAdapter<CompanyUserAdapter.ViewHolder> {
    public CompanyUserAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.messagemind.setText("" + result.get("messagemind"));
        holder.peixunnumber.setText("" + result.get("peixunnumner"));
        holder.sex.setText("" + result.get("sex"));
        holder.tijianhegenumber.setText("" + result.get("tijianhegenumber"));
        holder.youxiaoDate.setText("" + result.get("youxiaoDate"));
        holder.username.setText("" + result.get("username"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.companyuser_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.username)
        TextView username;
        @BindView(R.id.sex)
        TextView sex;
        @BindView(R.id.tijianhegenumber)
        TextView tijianhegenumber;
        @BindView(R.id.peixunnumber)
        TextView peixunnumber;
        @BindView(R.id.youxiaoDate)
        TextView youxiaoDate;
        @BindView(R.id.messagemind)
        TextView messagemind;
        @BindView(R.id.activity_main)
        RelativeLayout activityMain;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
