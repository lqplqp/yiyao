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

public class QYManagerPeixundingdanAdapter extends MBaseAdapter<QYManagerPeixundingdanAdapter.ViewHolder> {
    public QYManagerPeixundingdanAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //查看

        //付款

        //取消

        //交易状态
        holder.jiaoyizhuangtai.setText(""+result.getString("jiaoyizhuangtai"));
        //培训费用
        holder.peixunfeiyong.setText(""+result.getString("peixunfeiyong"));
        //培训项目信息
        holder.peixunxiangmuxinxi.setText(""+result.getString("peixunxiangmuxinxi"));
        //应付款
        holder.yingfukuan.setText(""+result.getString("yingkukuan"));
        //已付款
        holder.yifukuan.setText(""+result.getString("yifukuan"));
        //资料费用
        holder.ziliaofeiyong.setText(""+result.getString("ziliaofeiyong"));
        //学员人数
        holder.xueyuanrenshu.setText(""+result.getString("xueyuanrenshu"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.qy_manager_peixundingdan_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.peixunxiangmuxinxi)
        TextView peixunxiangmuxinxi;
        @BindView(R.id.peixunfeiyong)
        TextView peixunfeiyong;
        @BindView(R.id.ziliaofeiyong)
        TextView ziliaofeiyong;
        @BindView(R.id.xueyuanrenshu)
        TextView xueyuanrenshu;
        @BindView(R.id.yingfukuan)
        TextView yingfukuan;
        @BindView(R.id.yifukuan)
        TextView yifukuan;
        @BindView(R.id.jiaoyizhuangtai)
        TextView jiaoyizhuangtai;
        @BindView(R.id.chakan)
        TextView chakan;
        @BindView(R.id.fukuan)
        TextView fukuan;
        @BindView(R.id.quxiao)
        TextView quxiao;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
