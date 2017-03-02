package com.lxkj.yiyao.shiji.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
;import com.lxkj.yiyao.R;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2.
 */

public class AdminManagerAdapter extends BaseAdapter {
    private Context context;
    private List<AdminManagerBean> adminManager;

    public AdminManagerAdapter(Context context, List<AdminManagerBean> adminManager) {
        this.context = context;
        this.adminManager = adminManager;
    }
    @Override
    public int getCount() {
        return adminManager.size();
    }

    @Override
    public Object getItem(int position) {
        return adminManager.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.adminmanager_item, null);
            viewHolder.textView_1 = (TextView) convertView.findViewById(R.id.adminmanager_tv_1);
            viewHolder.textView_2 = (TextView) convertView.findViewById(R.id.adminmanager_tv_2);
            viewHolder.textView_3 = (TextView) convertView.findViewById(R.id.adminmanager_tv_3);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = new ViewHolder();
            viewHolder = (ViewHolder) convertView.getTag();
        }
        AdminManagerBean admin = adminManager.get(position);
        viewHolder.textView_1.setText(admin.getIndex());
        viewHolder.textView_2.setText(admin.getUserName());
        viewHolder.textView_3.setText(admin.getName());
        return convertView;
    }
}
class ViewHolder {
    public TextView textView_1;
    public TextView textView_2;
    public TextView textView_3;
}


