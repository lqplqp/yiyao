package com.lxkj.yiyao.gerenyonghu.Adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/16.
 */

public class GeRenYongHuWenDangXiaZaiAdapter extends MBaseAdapter<GeRenYongHuWenDangXiaZaiAdapter.ViewHolder> {

    public GeRenYongHuWenDangXiaZaiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //文档发布时间
        holder.time.setText(""+result.get("time"));
        //文档名
        holder.wendangming.setText(""+result.get("wendangming"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.gerenyonghu_wendangxiazai_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.wendangming)
        TextView wendangming;
        @BindView(R.id.time)
        TextView time;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
