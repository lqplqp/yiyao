package com.lxkj.yiyao.qiyemanager.adapter;

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

public class QYManagerTiJianBaoGaoAdapter extends MBaseAdapter<QYManagerTiJianBaoGaoAdapter.ViewHolder> {
    public QYManagerTiJianBaoGaoAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
       //操作
        holder.caozuo.setText(""+result.get("caozuo"));
       //发证单位
        holder.fazhengdanwei.setText(""+result.get("fazhengdanwei"));
       //发证日期
        holder.fazhengriqi.setText(""+result.get("fazhengriqi"));
       //岗位
        holder.gangwei.setText(""+result.get("gangwei"));
       //过期日期
        holder.guoqiriqi.setText(""+result.get("guoqiriqi"));
       //身份证号
        holder.shenfenzhenghao.setText(""+result.get("shenfenzhenghao"));
       //体检报告编号
        holder.tijianbaogaobianhao.setText(""+result.get("tijianbaogaobianhao"));
       //性别
        holder.xingbie.setText(""+result.get("xingbie"));
       //姓名
        holder.xingming.setText(""+result.get("xingming"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.qy_manager_tijianbaogao_item;
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
        @BindView(R.id.tijianbaogaobianhao)
        TextView tijianbaogaobianhao;
        @BindView(R.id.shenfenzhenghao)
        TextView shenfenzhenghao;
        @BindView(R.id.xingbie)
        TextView xingbie;
        @BindView(R.id.gangwei)
        TextView gangwei;
        @BindView(R.id.fazhengriqi)
        TextView fazhengriqi;
        @BindView(R.id.guoqiriqi)
        TextView guoqiriqi;
        @BindView(R.id.fazhengdanwei)
        TextView fazhengdanwei;
        @BindView(R.id.caozuo)
        TextView caozuo;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
