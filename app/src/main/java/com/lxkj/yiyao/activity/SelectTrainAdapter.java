package com.lxkj.yiyao.activity;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/8 0008.
 */

public class SelectTrainAdapter extends MBaseAdapter<SelectTrainAdapter.ViewHolder> {

    private Activity mActivity;

    public SelectTrainAdapter(String bean , Activity activity) {
        super(bean);
        mActivity = activity;

    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {


        Glide.with(mActivity).load(GlobalString.BaseURL + "/"+result.get("tpdz")).into(holder.img1);

        holder.title.setText( "" + result.get("bt").toString());
        holder.time.setText("" + result.get("pxsj").toString());

    }


    @Override
    protected int getItemLayout() {
        return R.layout.peixunlist_select_train_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.img1)
        ImageView img1;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.time)
        TextView time;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
