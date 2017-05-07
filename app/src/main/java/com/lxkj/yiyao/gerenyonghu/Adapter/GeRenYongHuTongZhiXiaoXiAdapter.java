package com.lxkj.yiyao.gerenyonghu.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/22.
 */

public class GeRenYongHuTongZhiXiaoXiAdapter extends BaseAdapter {
    JSONArray objects;

    public GeRenYongHuTongZhiXiaoXiAdapter(String s) {
        objects = JSONArray.parseArray(s);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.gerenyonghu_tongzhi_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final JSONObject object = objects.getJSONObject(i);

        holder.fabushijian.setText("网上培训通知  发布时间："+object.get("cjsj"));
        holder.tongzhineirong.setText(""+object.get("tzbt"));
        holder.zhuangtai.setText("状态："+object.get("zt"));
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.fabushijian)
        TextView fabushijian;
        @BindView(R.id.zhuangtai)
        TextView zhuangtai;
        @BindView(R.id.tongzhineirong)
        TextView tongzhineirong;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
