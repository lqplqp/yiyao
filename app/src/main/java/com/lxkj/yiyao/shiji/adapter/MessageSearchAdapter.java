package com.lxkj.yiyao.shiji.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.*;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class MessageSearchAdapter extends com.lxkj.yiyao.jianguan.adapter.MBaseAdapter<MessageSearchAdapter.ViewHolder> {
    public MessageSearchAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //发布人
        holder.faburen.setText(""+result.get("fbr"));
        //序号
        holder.number.setText(""+result.get("number"));
        //培训开始时间
        holder.peixunDate.setText(""+result.get("pxkssj"));
        //培训地点
        holder.peixundidian.setText(""+result.get("peixundidian"));
        //培训结束时间
        holder.peixunOver.setText(""+result.get("pxjssj"));
        //通知标题
        holder.tongzhibiaoti.setText(""+result.get("tzbt"));
        //通知单位
        holder.tongzhidanwei.setText(""+result.get("tzdw"));
        //通知类型
        holder.tongzhileixing.setText(""+result.get("tzlx"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.messagesearch_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.number)
        TextView number;
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
        @BindView(R.id.peixunDate)
        TextView peixunDate;
        @BindView(R.id.peixunOver)
        TextView peixunOver;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
