package com.lxkj.yiyao.gerenyonghu.Adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/19.
 */

public class GeRenYongHuWoDeZhengShuAdapter extends MBaseAdapter<GeRenYongHuWoDeZhengShuAdapter.ViewHolder> {

    public GeRenYongHuWoDeZhengShuAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.zhengshu.setText(""+result.get("zhengshu"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.gerenyonghu_wodezhengshu_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.zhengshu)
        TextView zhengshu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
