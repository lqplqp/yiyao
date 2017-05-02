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

public class QYManagerMessageCad extends MBaseAdapter<QYManagerMessageCad.ViewHolder> {
    public QYManagerMessageCad(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //姓名
        holder.xingming.setText(""+result.getString("xingming"));
        //信息卡编号
        holder.xinxikabianhao.setText(""+result.getString("xinxikabianhao"));
        //序号
        holder.xuhao.setText(""+result.getString("id"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.qiye_manager_xinxika_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.xingming)
        TextView xingming;
        @BindView(R.id.xinxikabianhao)
        TextView xinxikabianhao;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
