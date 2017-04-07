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

public class QYPersonManagerAdapter extends MBaseAdapter<QYPersonManagerAdapter.ViewHolder> {


    public QYPersonManagerAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
       //手机号
        holder.shoujihao.setText(""+result.get("sjhm"));
        //性别
        holder.xingbie.setText(""+result.get("xingb"));
        //姓名
        holder.xingming.setText(""+result.get("sex"));
        //序号
        holder.xuhao.setText(""+result.get("xh"));
        //用户名
        holder.yonghuming.setText(""+result.get("yhm"));
        //邮箱
        holder.youxiang.setText(""+result.get("yx"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.qypersonmanager_item;
    }

    @Override
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

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
