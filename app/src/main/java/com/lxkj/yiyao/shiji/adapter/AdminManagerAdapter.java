package com.lxkj.yiyao.shiji.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class AdminManagerAdapter extends MBaseAdapter<AdminManagerAdapter.ViewHolder> {


    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.user_name)
    TextView user_name;

    public AdminManagerAdapter(String bean) {
        super(bean);
    }

    protected void fillData(int i, AdminManagerAdapter.ViewHolder holder, JSONObject result) {
        //序号
        holder.number.setText("" + result.get("xuhao"));

        //用户名
        holder.username.setText("" + result.get("username"));

        //姓名
        holder.name.setText("" + result.get("name"));


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
        @BindView(R.id.username)
        TextView username;
        @BindView(R.id.name)
        TextView name;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}