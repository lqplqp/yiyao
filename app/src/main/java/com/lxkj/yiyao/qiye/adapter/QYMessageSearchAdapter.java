package com.lxkj.yiyao.qiye.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class QYMessageSearchAdapter extends MBaseAdapter<QYMessageSearchAdapter.ViewHolder> {
    public QYMessageSearchAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {

        //序号
        holder.xuhao.setText("" + result.get("id"));
        //通知类型
        holder.tongzhileixing.setText("" + result.get("tzlx"));
        //通知单位
        holder.tongzhidanwei.setText("" + result.get("tzdw"));
        //发布人
        holder.faburen.setText(""+result.get("fbr"));
        //通知标题
        holder.tongzhibiaoti.setText("" + result.get("tzbt"));
        //培训地点
        holder.peixundidian.setText("" + result.get("pxdd"));
        //培训开始时间
        holder.peixunkaishishijian.setText("" + result.get("pxkssj"));
        //结束时间
        holder.jieshushijian.setText(""+result.get("pxjssj"));
        //查看
        //holder.chakan.setText("" + result.get("chakan"));

    }



    @Override
    protected int getItemLayout() {
        return R.layout.qymessagesearch_item;
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
        @BindView(R.id.jieshushijian)
        TextView jieshushijian;
        @BindView(R.id.chakan)
        TextView chakan;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
