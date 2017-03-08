package com.lxkj.yiyao.shengjugeren.Adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import master.flame.danmaku.danmaku.model.android.ViewCacheStuffer;

/**
 * Created by Administrator on 2017/3/8.
 */

public class SJGRJianGuanTongJiAdapter extends MBaseAdapter<SJGRJianGuanTongJiAdapter.ViewHolder> {
    public SJGRJianGuanTongJiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.jianguandanweimingcheng.setText(""+result.get("jgdwmc"));
        holder.xuhao.setText(""+result.get("xuhao"));
        holder.yonghuming.setText(""+result.get("yhm"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_jianguantongji_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.jianguandanweimingcheng)
        TextView jianguandanweimingcheng;
        @BindView(R.id.yonghuming)
        TextView yonghuming;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
