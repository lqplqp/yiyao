package com.lxkj.yiyao.shiji.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

/**
 * Created by sun on 2017/3/31.
 */

public class ShouYeTongZhiXiaoXiAdapter extends BaseAdapter{
    private JSONArray jsonArray;

    public ShouYeTongZhiXiaoXiAdapter(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
        JSONObject jsonObject = JSONObject.parseObject(jsonArray.get(0).toString());
    }

    @Override
    public int getCount() {
        return jsonArray.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(parent.getContext(), R.layout.tongzhixiaoxi_item_layout, null);
        TextView xiaoxi = (TextView)view.findViewById(R.id.xiaoxi_text);
        JSONObject jsonObject = JSONObject.parseObject(jsonArray.get(position).toString());
        xiaoxi.setText("" + jsonObject.getString("tzbt"));
        return view;
    }
}
