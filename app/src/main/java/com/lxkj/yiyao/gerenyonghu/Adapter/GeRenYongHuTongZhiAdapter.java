package com.lxkj.yiyao.gerenyonghu.Adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/19.
 */

public class GeRenYongHuTongZhiAdapter extends MBaseAdapter<GeRenYongHuTongZhiAdapter.ViewHolder>{
    public GeRenYongHuTongZhiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //发布人
        holder.faburen.setText(""+result.get("fbr"));
        //结束时间
        holder.jieshushijian.setText(""+result.get("pxjssj"));
        //开始时间
        holder.kaishishijian.setText(""+result.get("pxkssj"));
        //培训地点
        holder.peixundidian.setText(""+result.get("pxdd"));
        //通知标题
        holder.tongzhibiaoti.setText(""+result.get("tzbt"));
        //通知单位
        holder.tongzhidanwei.setText(""+result.get("tzdw"));
        //通知类型
        holder.tongzhileixing.setText(""+result.get("tzlx"));
        //序号
        holder.xuhao.setText(""+result.get("id"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.gerenyonghu_tongzhixiaoxi_item;
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
