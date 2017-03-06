package com.lxkj.yiyao.shengji.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.shiji.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/3.
 */

public class ProjectApplyAdapter extends MBaseAdapter<ProjectApplyAdapter.ViewHolder>{
    public ProjectApplyAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.peixunbanname.setText(""+result.get("peixunbanname"));
        holder.peixunTime.setText(""+result.get("peixunTime"));
        holder.peixunbanname2.setText(""+result.get("peixunname2"));
        holder.peixunbanTime2.setText(""+result.get("peixunbanTime2"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.select_train_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return  new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.img3)
        ImageView img3;
        @BindView(R.id.peixunbanname)
        TextView peixunbanname;
        @BindView(R.id.peixunTime)
        TextView peixunTime;
        @BindView(R.id.img4)
        ImageView img4;
        @BindView(R.id.peixunbanname_2)
        TextView peixunbanname2;
        @BindView(R.id.peixunbanTime_2)
        TextView peixunbanTime2;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
