package com.lxkj.yiyao.gerenyonghu.Adapter;

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

public class GeRenPeiXunListAdapter extends MBaseAdapter<GeRenPeiXunListAdapter.ViewHolder> {
    public GeRenPeiXunListAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //操作
        holder.caozuo.setText(""+result.get("caozuo"));
        //订单编号
        holder.dingdanbianhao.setText(""+result.get("dngdanbianhao"));
        //购课人数
        holder.goukerenshu.setText(""+result.get("hgoukerenshu"));
        //序号
        holder.number.setText(""+result.get("xuhao"));
        //培训班类型
        holder.peixunbanleixing.setText(""+result.get("peixunbanleixing"));
        //培训班名称
        holder.peixunbanmingci.setText(""+result.get("peixunbanmingcheng"));
        //培训时间
        holder.peixunshijian.setText(""+result.get("peixunshijian"));
        //时报人数
        holder.shibaorenshu.setText(""+result.get("shibaorenshu"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.qiyemanager_yibao_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.number)
        TextView number;
        @BindView(R.id.dingdanbianhao)
        TextView dingdanbianhao;
        @BindView(R.id.peixunbanmingci)
        TextView peixunbanmingci;
        @BindView(R.id.peixunbanleixing)
        TextView peixunbanleixing;
        @BindView(R.id.peixunshijian)
        TextView peixunshijian;
        @BindView(R.id.shibaorenshu)
        TextView shibaorenshu;
        @BindView(R.id.goukerenshu)
        TextView goukerenshu;
        @BindView(R.id.caozuo)
        TextView caozuo;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
