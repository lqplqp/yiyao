package com.lxkj.yiyao.qiye.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/3 0003.
 */

public class QYTrainOrderAdapter extends MBaseAdapter<QYTrainOrderAdapter.ViewHolder> {


    public QYTrainOrderAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //培训项目信息
        holder.peixunxiangmuxinxi.setText("" + result.get("pxxmxx"));
        //培训费用
        holder.peixunfeiyong.setText("" + result.get("pxfy"));
        //资料费用
        holder.ziliaofeiyong.setText("" + result.get("zlfy"));
        //学员人数
        holder.xueyuanrenshu.setText("" + result.get("xyrs"));
        //已付款
        holder.yifukuan.setText("" + result.get("yfk"));
        //应付款
        holder.yingfukuan.setText("" + result.get("yingfukuan"));
        //交易状态
        holder.jiaoyizhuangtai.setText("" + result.get("jyzt"));
        //查看
        holder.chakan.setText("" + result.get("chakan"));
        //付款
        holder.fukuan.setText("" + result.get("fukuan"));
        //取消
        holder.quxiao.setText("" + result.get("quxiao"));

    }

    @Override
    protected int getItemLayout() {
        return R.layout.qytrainorder_item;
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
