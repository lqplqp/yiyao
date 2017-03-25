package com.lxkj.yiyao.activity.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/19.
 */

public class XuanGouKeChengQiYeRenYuanAdapter extends BaseAdapter {
    JSONArray objects;

    public XuanGouKeChengQiYeRenYuanAdapter(String result) {
        objects = JSONArray.parseArray(result);
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
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.qiyerenyuanliebiao_item, null);
            holder = new XuanGouKeChengQiYeRenYuanAdapter.ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (XuanGouKeChengQiYeRenYuanAdapter.ViewHolder) view.getTag();
        }
        final JSONObject object = objects.getJSONObject(i);
        //姓名
        holder.name.setText(""+object.getString("name"));

        return view;
    }


    class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.checkBox)
        CheckBox checkBox;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
