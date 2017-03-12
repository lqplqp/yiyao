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
 * Created by liqinpeng on 2017/3/12 0012.
 */

public class JieYeKaoShiAdapter extends BaseAdapter {

    JSONArray objects;
    JSONObject object;


    public JieYeKaoShiAdapter(String result) {
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
            view = View.inflate(viewGroup.getContext(),R.layout.zaixiankaoshi_item,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }


        holder.kaochang.setText("" + object.get("id").toString());
        holder.shifoutongguo.setText("" + object.get("sftg").toString());

        holder.jinrukaochang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show("未实现,接口有误");
            }
        });



        return view;


    }

    static class ViewHolder {
        @BindView(R.id.kaochang)
        TextView kaochang;
        @BindView(R.id.shifoutongguo)
        TextView shifoutongguo;
        @BindView(R.id.jinrukaochang)
        TextView jinrukaochang;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
