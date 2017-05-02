package com.lxkj.yiyao.shiji.adapter;

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

public class PeiXunListAdapter extends MBaseAdapter<PeiXunListAdapter.ViewHolder> {
    public PeiXunListAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //序号
        holder.number.setText(""+result.get("id"));
        //培训班名称
        holder.dingdanbianhao.setText(""+result.get("pxbmc"));
        //培训班类型
        holder.peixunbanmingci.setText(""+result.get("pxlx"));

        //培训班时间
        holder.peixunbanleixing.setText(""+result.get("pxkssj"));

        //证书名称
        holder.peixunshijian.setText(""+result.get("pxbt"));

        //购买时间
        holder.shibaorenshu.setText(""+result.get("cjsj"));

        //学习进度
        holder.goukerenshu.setText(""+result.get("xxjd"));
        //操作
        holder.caozuo.setText(""+result.get("caozuo"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.qiyemanager_yibao_item;
    }

    @Override
    protected PeiXunListAdapter.ViewHolder getHolder(View view) {
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
