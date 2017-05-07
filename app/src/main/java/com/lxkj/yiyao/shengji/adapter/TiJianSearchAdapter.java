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

        if(result.get("gongzuodanwei")!=null)

        //工作单位
        holder.gongzuodanwei.setText(""+result.get("gongzuodanwei"));
        if(result.get("shenfenzhenghao")!=null)
        //身份证号
        holder.shenfenzhenghao.setText(""+result.get("shenfenzhenghao"));
        if(result.get("shifouhege")!=null)
        //是否合格
        holder.shifouhege.setText(""+result.get("shifouhege"));
        if(result.get("tijianbaogaobianhao")!=null)
        //体检报告编号
        holder.tijianbaogaobianhao.setText(""+result.get("tijianbaogaobianhao"));
        if(result.get("tijianshijian")!=null)
        //体检时间
        holder.tijianshijian.setText(""+result.get("tijianshijian"));
        if(result.get("tijianyiyuan")!=null)
        //体检医院
        holder.tijianyiyuan.setText(""+result.get("tijianyiyuan"));
        if(result.get("xingbie")!=null)
        //性别
        holder.xingbie.setText(""+result.get("xingbie"));
        if(result.get("xingming")!=null)
        //姓名
        holder.xingming.setText(""+result.get("xingming"));
        if(result.get("id")!=null)
        //序号
        holder.xuhao.setText(""+result.get("id"));
        if(result.get("zhuzhiyisheng")!=null)
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
