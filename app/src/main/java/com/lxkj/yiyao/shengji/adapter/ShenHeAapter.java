package com.lxkj.yiyao.shengji.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/3.
 */

public class ShenHeAapter extends MBaseAdapter <ShenHeAapter.ViewHolder>{
    public ShenHeAapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //登录用户名
        holder.dengluyonghuming.setText(""+result.getString("dengluyonghuming"));
        //体检机构名
        holder.tijianjigouming.setText(""+result.getString("tijianjigouming"));
        //序号
        holder.xuhao.setText(""+result.getString("xuhao"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.sj_shenhe_item;
    }


    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.dengluyonghuming)
        TextView dengluyonghuming;
        @BindView(R.id.tijianjigouming)
        TextView tijianjigouming;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
