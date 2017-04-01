package com.lxkj.yiyao.jianguan.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/29.
 */

public class HomeMessageAdapter extends MBaseAdapter<HomeMessageAdapter.ViewHolder> {

    public HomeMessageAdapter(String bean) {
        datas = JSONArray.parseArray(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.xiaoxi.setText(""+result.get("tzbt"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.jianguan_shouye_tongzhi_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xiaoxi)
        TextView xiaoxi;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
