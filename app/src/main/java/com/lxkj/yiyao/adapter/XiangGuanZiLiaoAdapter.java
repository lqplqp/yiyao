package com.lxkj.yiyao.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/11 0011.
 */

public class XiangGuanZiLiaoAdapter extends BaseAdapter {

    JSONArray objects;

    public XiangGuanZiLiaoAdapter(String result) {
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
        if(view == null){
            view = View.inflate(viewGroup.getContext(),R.layout.learing_ziliao_item,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }


        final JSONObject object = objects.getJSONObject(i);

        holder.name.setText("" + object.get("title").toString() );

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show("下载" + object.get("url").toString());
            }
        });



        return view;
    }

    static class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.download)
        TextView download;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
