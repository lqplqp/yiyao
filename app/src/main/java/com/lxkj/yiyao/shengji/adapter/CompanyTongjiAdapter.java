package com.lxkj.yiyao.shengji.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class CompanyTongjiAdapter extends MBaseAdapter <CompanyTongjiAdapter.ViewHolder>{
    public CompanyTongjiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //企业数量
        holder.qiyeshuliang.setText(""+result.getString("qysl"));
        //序号
        holder.xuhao.setText(""+result.getString("id"));
        //地区
        holder.diqu.setText(""+result.getString("dq"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_qiye_yonghu_tongji_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.diqu)
        TextView diqu;
        @BindView(R.id.qiyeshuliang)
        TextView qiyeshuliang;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
