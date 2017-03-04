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

public class QYManagerTiJianBaoGaoAdapter extends MBaseAdapter <QYManagerTiJianBaoGaoAdapter.ViewHolder>{
    public QYManagerTiJianBaoGaoAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //体检报告编号
        holder.tijianbaogaobianhao.setText(""+result.getString("tijianbaogaobianhao"));
        //姓名
        holder.xingming.setText(""+result.getString("xingming"));
        //序号
        holder.xuhao.setText(""+result.getString("xuhao"));
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
        @BindView(R.id.tijianbaogaobianhao)
        TextView tijianbaogaobianhao;
        @BindView(R.id.xingming)
        TextView xingming;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
