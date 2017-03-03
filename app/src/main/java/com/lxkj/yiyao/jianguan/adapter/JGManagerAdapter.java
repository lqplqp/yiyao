package com.lxkj.yiyao.jianguan.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class JGManagerAdapter extends MBaseAdapter<JGManagerAdapter.ViewHolder> {
    public JGManagerAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {

        //序号
        holder.xuhao.setText("" + result.get("xuhao"));

        //账号
        holder.zhanghao.setText("" + result.get("zhanghao"));

        //监管名称
        holder.jianguanmingcheng.setText(""+result.get("jgmc"));


    }



    @Override
    protected int getItemLayout() {
        return R.layout.jgmanger_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.zhanghao)
        TextView zhanghao;
        @BindView(R.id.jianguanmingcheng)
        TextView jianguanmingcheng;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
