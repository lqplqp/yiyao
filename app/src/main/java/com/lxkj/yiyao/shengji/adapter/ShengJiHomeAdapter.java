package com.lxkj.yiyao.shengji.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.bean.ShengJiHomeBean;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/30 0030.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class ShengJiHomeAdapter extends BaseAdapter {

    public ShengJiHomeAdapter(List<ShengJiHomeBean.DataBean> datas2) {
        this.datas2 = datas2;
    }

    private List<ShengJiHomeBean.DataBean> datas2 ;

    @Override
    public int getCount() {
        return datas2.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = View.inflate(parent.getContext() , R.layout.shengji_notify_item , null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.content.setText(datas2.get(position).getTzbt());

        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.content)
        TextView content;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
