package com.lxkj.yiyao.qiye.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class QiyeInfoCardManagerAdapter extends MBaseAdapter<QiyeInfoCardManagerAdapter.ViewHolder> {

    public QiyeInfoCardManagerAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //发卡单位
        holder.fakadanwei.setText(""+result.get("jgdw"));
        //发卡日期
        holder.fakariqi.setText(""+result.get("yxq"));
        //发卡状态
        holder.fakazhuangtai.setText(""+result.get("zt"));
        //岗位
        holder.gangwei.setText(""+result.get("gw"));
        //过期日期
        holder.guoqiriqi.setText(""+result.get("yxq1"));
        //身份证号
        holder.shenfenzhenghao.setText(""+result.get("sfzh"));
        //手机号
        //holder.shoujihao.setText(""+result.get("shoujihao"));
        //姓名
        holder.xingming.setText(""+result.get("xm"));
        //信息卡编号
        holder.xinxikabianhao.setText(""+result.get("xxkbh"));
        //序号
        holder.xuhao.setText(""+result.get("xh"));
        //性别
        holder.xingbie.setText(""+result.get("xb"));
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
        @BindView(R.id.xingbie)
        TextView xingbie;
        @BindView(R.id.xingming)
        TextView xingming;
        @BindView(R.id.xinxikabianhao)
        TextView xinxikabianhao;
        @BindView(R.id.shenfenzhenghao)
        TextView shenfenzhenghao;
        @BindView(R.id.gangwei)
        TextView gangwei;
        @BindView(R.id.fakariqi)
        TextView fakariqi;
        @BindView(R.id.guoqiriqi)
        TextView guoqiriqi;
        @BindView(R.id.fakadanwei)
        TextView fakadanwei;
        @BindView(R.id.fakazhuangtai)
        TextView fakazhuangtai;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
