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

public class QYManaYiBaoPeiXunAdapter extends MBaseAdapter <QYManaYiBaoPeiXunAdapter.ViewHolder>{
    public QYManaYiBaoPeiXunAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //查看

        //订单编号
        holder.dingdanbianhao.setText(""+result.getString("dingdanbianhao"));
        //购课人数
        holder.goukerenshu.setText(""+result.getString("goukerenshu"));
        //培训班类型
        holder.peixunbanleixing.setText(""+result.getString("peixunbanleixing"));
        //培训时间
        holder.peixunshijian.setText(""+result.getString("pexunshijian"));
        //培训班名称
        holder.peixunbanmingcheng.setText(""+result.getString("peixunbanmingcheng"));
        //实报人数
        holder.shibaorenshu.setText(""+result.getString("shibaorenshu"));
        //序号
        holder.xuhao.setText(""+result.getString("xuhao"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.qye_manager_yibaopeixunxiangmu_item;
    }


    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.dingdanbianhao)
        TextView dingdanbianhao;
        @BindView(R.id.peixunbanmingcheng)
        TextView peixunbanmingcheng;
        @BindView(R.id.peixunbanleixing)
        TextView peixunbanleixing;
        @BindView(R.id.peixunshijian)
        TextView peixunshijian;
        @BindView(R.id.shibaorenshu)
        TextView shibaorenshu;
        @BindView(R.id.goukerenshu)
        TextView goukerenshu;
        @BindView(R.id.chakan)
        TextView chakan;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
