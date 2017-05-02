package com.lxkj.yiyao.shengjugeren.Adapter;

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

public class SJGRMessageSearchAdapter extends MBaseAdapter<SJGRMessageSearchAdapter.ViewHolder> {
    public SJGRMessageSearchAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //发布人
        holder.faburen.setText(""+result.getString("fbr"));
        //结束时间
        holder.jieshushijian.setText(""+result.getString("pxjssj"));
        //开始时间
        holder.kaishishijian.setText(""+result.getString("pxkssj"));
        //培训地点
        holder.peixundidian.setText(""+result.getString("peixundidian"));
        //通知标题
        holder.tongzhibiaoti.setText(""+result.getString("tzbt"));
        //通知单位
        holder.tongzhidanwei.setText(""+result.getString("tzdw"));
        //通知类型
        holder.tongzhileixing.setText(""+result.getString("tzlx"));
        //序号
        holder.xuhao.setText(""+result.getString("id"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_message_search_item;
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
        @BindView(R.id.kaishishijian)
        TextView kaishishijian;
        @BindView(R.id.jieshushijian)
        TextView jieshushijian;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
