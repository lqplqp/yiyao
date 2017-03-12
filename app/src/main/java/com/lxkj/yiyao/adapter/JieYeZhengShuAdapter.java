package com.lxkj.yiyao.adapter;

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
 * Created by liqinpeng on 2017/3/12 0012.
 */

public class JieYeZhengShuAdapter extends BaseAdapter {


    JSONArray objects;
    JSONObject object;


    public JieYeZhengShuAdapter(String result) {
        //objects = JSONArray.parseArray(result);
        object = JSONObject.parseObject(result);
    }

    @Override
    public int getCount() {
        return 1;
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

        ViewHolder holder ;
        if(view == null){
            view = View.inflate(viewGroup.getContext(),R.layout.jieyezhengshu_item,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        //JSONObject object = objects.getJSONObject(i);

        holder.name.setText("" + object.get("zsname").toString());


        return view;


    }

    static class ViewHolder {
        @BindView(R.id.name)
        TextView name;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
