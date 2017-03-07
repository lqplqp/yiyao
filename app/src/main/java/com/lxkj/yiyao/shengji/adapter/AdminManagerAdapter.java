package com.lxkj.yiyao.shengji.adapter;

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

public class AdminManagerAdapter extends MBaseAdapter<AdminManagerAdapter.ViewHolder> {




    public AdminManagerAdapter(String bean) {
        super(bean);
    }

    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //序号
        holder.number.setText("" + result.get("id"));

        //用户名
        holder.yhm.setText("" + result.get("yhm"));

        //姓名
        holder.xm.setText("" + result.get("xm"));


    }

    protected int getItemLayout() {
        return R.layout.adminmanager_item;
    }

    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.number)
        TextView number;
        @BindView(R.id.yhm)
        TextView yhm;
        @BindView(R.id.xm)
        TextView xm;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}