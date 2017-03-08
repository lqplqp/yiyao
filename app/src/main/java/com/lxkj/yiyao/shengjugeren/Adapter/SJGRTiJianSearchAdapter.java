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

public class SJGRTiJianSearchAdapter extends MBaseAdapter <SJGRTiJianSearchAdapter.ViewHolder>{
    public SJGRTiJianSearchAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //姓名
        holder.name.setText(""+result.getString("xm"));
        //体检报告编号
        holder.tijianbaogaobianhao.setText(""+result.getString("tjbgh"));
        //序号
        holder.xuhao.setText(""+result.getString("tj"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_tijian_search_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.tijianbaogaobianhao)
        TextView tijianbaogaobianhao;
        @BindView(R.id.name)
        TextView name;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
