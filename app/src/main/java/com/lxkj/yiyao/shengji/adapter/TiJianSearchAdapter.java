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

public class TiJianSearchAdapter extends MBaseAdapter<TiJianSearchAdapter.ViewHolder> {
    public TiJianSearchAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //工作单位
        holder.gongzuodanwei.setText(""+result.get("gongzuodanwei"));
        //身份证号
        holder.shenfenzhenghao.setText(""+result.get("shenfenzhenghao"));
        //是否合格
        holder.shifouhege.setText(""+result.get("shifouhege"));
        //体检报告编号
        holder.tijianbaogaobianhao.setText(""+result.get("tijianbaogaobianhao"));
        //体检时间
        holder.tijianshijian.setText(""+result.get("tijianshijian"));
        //体检医院
        holder.tijianyiyuan.setText(""+result.get("tijianyiyuan"));
        //性别
        holder.xingbie.setText(""+result.get("xingbie"));
        //姓名
        holder.xingming.setText(""+result.get("xingming"));
        //序号
        holder.xuhao.setText(""+result.get("xuhao"));
        // 主治医生
        holder.zhuzhiyisheng.setText(""+result.get("zhuzhiyisheng"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.shengji_tijian_search_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.tijianbaogaobianhao)
        TextView tijianbaogaobianhao;
        @BindView(R.id.xingming)
        TextView xingming;
        @BindView(R.id.shenfenzhenghao)
        TextView shenfenzhenghao;
        @BindView(R.id.xingbie)
        TextView xingbie;
        @BindView(R.id.gongzuodanwei)
        TextView gongzuodanwei;
        @BindView(R.id.tijianyiyuan)
        TextView tijianyiyuan;
        @BindView(R.id.zhuzhiyisheng)
        TextView zhuzhiyisheng;
        @BindView(R.id.tijianshijian)
        TextView tijianshijian;
        @BindView(R.id.shifouhege)
        TextView shifouhege;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
