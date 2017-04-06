package com.lxkj.yiyao.shengjugeren.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.LearningActivity;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/5.
 */

public class SJGRShouYePeiXunBanAdapter extends MBaseAdapter<SJGRShouYePeiXunBanAdapter.ViewHolder> {
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.time)
    TextView time;
    private Activity mActivity;
    private int muserType;

    public SJGRShouYePeiXunBanAdapter(int userType, String s, Activity activity) {
        mActivity = activity;
        datas = JSONArray.parseArray(s);
        muserType = userType;
    }

    @Override
    protected void fillData(int i, ViewHolder holder, final JSONObject result) {
        Glide.with(mActivity).load(result.get("tpdz")).into(holder.img1);

        holder.title.setText("" + result.get("tpjs").toString());
        holder.time.setText("" + result.get("pxsj").toString());

        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, LearningActivity.class);
                intent.putExtra("pxid", result.get("id").toString());
                intent.putExtra("user_type", muserType);
                mActivity.startActivity(intent);
            }
        });

    }

    @Override
    protected int getItemLayout() {
        return R.layout.shengjugeren_shouye_peixunban_item;
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
