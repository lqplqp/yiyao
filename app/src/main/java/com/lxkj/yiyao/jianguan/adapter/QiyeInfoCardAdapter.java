package com.lxkj.yiyao.jianguan.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class QiyeInfoCardAdapter extends MBaseAdapter<QiyeInfoCardAdapter.ViewHolder> {

    public QiyeInfoCardAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {

        //序号
        holder.xuhao.setText("" + result.get("xuhao"));
        //姓名
        holder.xingming.setText("" + result.get("xm"));
        //信息卡编号
        holder.xinxikabianhao.setText("" + result.get("xxkbh"));


    }



    @Override
    protected int getItemLayout() {
        return R.layout.jgqiyeinfocard_item;
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
