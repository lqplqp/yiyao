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

public class QiYeYongHuTongJiAdapter extends MBaseAdapter<QiYeYongHuTongJiAdapter.ViewHolder> {




    public QiYeYongHuTongJiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //地区
        holder.diqu.setText("" + result.getString("fbr"));
        //企业数量
        holder.qiyeshuliang.setText("" + result.getString("pxjssj"));
        //从业人员数量
        holder.congyerenyuanshuliang.setText("" + result.getString("pxkssj"));
        //已报培训企业数量
        holder.yibaopeixunqiyeshuliang.setText("" + result.getString("peixundidian"));
        //已报培训从业人员数
        holder.yibaopeixunrenyuanshu.setText("" + result.getString("tzbt"));
        //企业培训率
        holder.qiyepeixunlv.setText("" + result.getString("tzbt"));
        //从业人员培训率
        holder.congyerenyuanpeixunlv.setText("" + result.getString("tzbt"));
        //人员流入数量
        holder.renyuanliurushuliang.setText("" + result.getString("tzbt"));
        //人员流出数量
        holder.renyuanliuchushuliang.setText("" + result.getString("tzbt"));
        //序号
        holder.xuhao.setText("" + result.getString("id"));

    }

    @Override
    protected int getItemLayout() {
        return R.layout.shengji_qiyeyonghutongji_item;
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
        @BindView(R.id.congyerenyuanshuliang)
        TextView congyerenyuanshuliang;
        @BindView(R.id.yibaopeixunqiyeshuliang)
        TextView yibaopeixunqiyeshuliang;
        @BindView(R.id.yibaopeixunrenyuanshu)
        TextView yibaopeixunrenyuanshu;
        @BindView(R.id.qiyepeixunlv)
        TextView qiyepeixunlv;
        @BindView(R.id.congyerenyuanpeixunlv)
        TextView congyerenyuanpeixunlv;
        @BindView(R.id.renyuanliurushuliang)
        TextView renyuanliurushuliang;
        @BindView(R.id.renyuanliuchushuliang)
        TextView renyuanliuchushuliang;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
