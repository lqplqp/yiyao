package com.lxkj.yiyao.activity.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/19.
 */

public class XuanGouKeChengQiYeRenYuanAdapter extends BaseAdapter {
    private JSONArray objects;
    private HashMap<Integer, Boolean> checkedMap = new HashMap<>();

    public XuanGouKeChengQiYeRenYuanAdapter(String result) {
        objects = JSONArray.parseArray(result);
        initMap();
    }

    private void initMap() {
        int size = objects.size();
        for (int i = 0; i < size; i++){
            checkedMap.put(i, false);
        }
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
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
        holder.name.setText(""+object.getString("xm"));
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkedMap.get(i)){
                    checkedMap.put(i, false);
                }else {
                    checkedMap.put(i, true);
                }
            }
        });
        return view;
    }
    public HashMap<Integer, Boolean> getCheckMap(){
        return checkedMap;
    }

    public JSONArray getObjects() {
        return objects;
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
