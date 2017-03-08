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
        //操作
        holder.caozuo.setText("" + result.get("caozuo"));
        //购买时间
        holder.goumaishijian.setText("" + result.get("cjsj"));
        //序号
        holder.number.setText("" + result.get("number"));
        //培训班类型
        holder.peixunbanleixing.setText("" + result.get(" pxlx"));
        //培训班名次
        holder.peixunbanmingci.setText("" + result.get("pxbmc"));
        //培训时间
        holder.peixuntime.setText("" + result.get("pxkssj"));
        //学习进度
        holder.xuexijindu.setText("" + result.get("xxjd"));
        //证书名称
        holder.zhengshumingcheng.setText("" + result.get("pxbt"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.peixunlist_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.number)
        TextView number;
        @BindView(R.id.peixunbanmingci)
        TextView peixunbanmingci;
        @BindView(R.id.peixunbanleixing)
        TextView peixunbanleixing;
        @BindView(R.id.peixuntime)
        TextView peixuntime;
        @BindView(R.id.zhengshumingcheng)
        TextView zhengshumingcheng;
        @BindView(R.id.goumaishijian)
        TextView goumaishijian;
        @BindView(R.id.xuexijindu)
        TextView xuexijindu;
        @BindView(R.id.caozuo)
        TextView caozuo;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
