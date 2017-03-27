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

public class QYManagerTongzhiAdapter extends MBaseAdapter <QYManagerTongzhiAdapter.ViewHolder>{
    public QYManagerTongzhiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //查看

        //发布人
        holder.faburen.setText(""+result.getString("faburen"));
        //培训地点
        holder.peixundidian.setText(""+result.getString("peixundidian"));
        //培训开始时间
        holder.peixunkaishishijian.setText(""+result.getString("peixunkaishishijian"));
        //通知标题
        holder.tongzhibiaoti.setText(""+result.getString("tongzhibiaoti"));
        //通知单位
        holder.tongzhidanwei.setText(""+result.getString("tongzhidanwei"));
        //通知类型
        holder.tongzhileixing.setText(""+result.getString("tongzhileixing"));
        //序号
        holder.xuhao.setText(""+result.getString("xuhao"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.qy_manager_tongzhi_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.tongzhileixing)
        TextView tongzhileixing;
        @BindView(R.id.tongzhidanwei)
        TextView tongzhidanwei;
        @BindView(R.id.faburen)
        TextView faburen;
        @BindView(R.id.tongzhibiaoti)
        TextView tongzhibiaoti;
        @BindView(R.id.peixundidian)
        TextView peixundidian;
        @BindView(R.id.peixunkaishishijian)
        TextView peixunkaishishijian;
        @BindView(R.id.chakan)
        TextView chakan;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
