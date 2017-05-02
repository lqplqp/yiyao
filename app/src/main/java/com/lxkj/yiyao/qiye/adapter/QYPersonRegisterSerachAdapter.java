package com.lxkj.yiyao.qiye.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/3 0003.
 */

public class QYPersonRegisterSerachAdapter extends MBaseAdapter<QYPersonRegisterSerachAdapter.ViewHolder> {


    public QYPersonRegisterSerachAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {

        //序号
        holder.xuhao.setText("" + result.get("id"));
        //姓名
        holder.xingming.setText("" + result.get("xingming")) ;
        //用户名
        holder.yonghuming.setText("" + result.get("yhm"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.qypersonregisterserach_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return null;
    }


    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.yonghuming)
        TextView yonghuming;
        @BindView(R.id.xingming)
        TextView xingming;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
