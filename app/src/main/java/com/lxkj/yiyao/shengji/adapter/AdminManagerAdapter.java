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
        holder.xuhao.setText("" + result.getString("id"));

        //用户名
        holder.yonghuming.setText("" + result.getString("zh"));

        //姓名
        holder.xingming.setText("" + result.getString("xm"));

        holder.xingbie.setText("" + result.getString("xb"));

        holder.shoujihao.setText("" + result.getString("sjhm"));

        holder.youxiang.setText("" + result.getString("yx"));

    }

    protected int getItemLayout() {
        return R.layout.shengji_adminmanager_item;
    }

    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.yonghuming)
        TextView yonghuming;
        @BindView(R.id.xingming)
        TextView xingming;
        @BindView(R.id.xingbie)
        TextView xingbie;
        @BindView(R.id.shoujihao)
        TextView shoujihao;
        @BindView(R.id.youxiang)
        TextView youxiang;
        @BindView(R.id.xiangqing)
        TextView xiangqing;
        @BindView(R.id.bianji)
        TextView bianji;
        @BindView(R.id.yichu)
        TextView yichu;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}