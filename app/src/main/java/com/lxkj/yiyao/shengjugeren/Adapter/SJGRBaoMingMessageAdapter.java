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

public class SJGRBaoMingMessageAdapter extends MBaseAdapter<SJGRBaoMingMessageAdapter.ViewHolder> {


    public SJGRBaoMingMessageAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //查看

        //企业名称
        holder.qiyemingcheng.setText("" + result.getString("qymc"));
        //已报培训班数量
        holder.yibaopeixungbanshuliang.setText(""+result.getString("ybpxbsl"));
        //总金额
        holder.zongjine.setText(""+result.getString("zje"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.shgr_fragment_person_qiye_baoming_info_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.chakan)
        TextView chakan;
        @BindView(R.id.qiyemingcheng)
        TextView qiyemingcheng;
        @BindView(R.id.yibaopeixungbanshuliang)
        TextView yibaopeixungbanshuliang;
        @BindView(R.id.zongjine)
        TextView zongjine;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
