package com.lxkj.yiyao.xianji.adapter;

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

public class QYManagerPersonManagerAdapter extends MBaseAdapter <QYManagerPersonManagerAdapter.ViewHolder>{
    public QYManagerPersonManagerAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //姓名
        holder.xingming.setText(""+result.getString("xingming"));
        //序号
        holder.xuhao.setText(""+result.getString("id"));
        //用户名
        holder.yonghuming.setText(""+result.getString("yonghuming"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.qiye_manager_yuangong_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
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
