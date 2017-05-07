package com.lxkj.yiyao.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/25 0025.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class KaoShiJieGuoZhiFaAdapter extends BaseAdapter {

private JSONArray jsonArray;
    private Context context;

    public KaoShiJieGuoZhiFaAdapter(JSONArray jsonArray, Context context) {
        this.jsonArray = jsonArray;
        this.context = context;
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
        View view = LayoutInflater.from(context).inflate(R.layout.kaoshijieguozhifa_item, parent, false);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView score = (TextView) view.findViewById(R.id.score);
        JSONObject jsonObject = JSONObject.parseObject(jsonArray.get(position).toString());
        String xm = jsonObject.getString("xm");
        String zf = jsonObject.getString("zf");
        name.setText(xm);
        score.setText(zf);
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.score)
        TextView score;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
