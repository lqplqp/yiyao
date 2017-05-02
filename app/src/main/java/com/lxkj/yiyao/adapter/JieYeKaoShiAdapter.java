package com.lxkj.yiyao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.ExamActivity;
import com.lxkj.yiyao.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/12 0012.
 */

public class JieYeKaoShiAdapter extends BaseAdapter {

    JSONArray objects;
    JSONObject object;
    Context context;


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
        context  = viewGroup.getContext();
        if(view == null){
            view = View.inflate(viewGroup.getContext(),R.layout.zaixiankaoshi_item,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        if(object !=null){
            holder.kaochang.setText("" + object.get("id"));
            holder.shifoutongguo.setText("" + object.get("sftg"));

            holder.jinrukaochang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View views) {
                    Intent intent = new Intent(context, ExamActivity.class);
                    intent.putExtra("kmid",""+object.get("pxid"));
                    context.startActivity(intent);
                }
            });
        }




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
