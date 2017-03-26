package com.lxkj.yiyao.gerenyonghu.Adapter;

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
import com.lxkj.yiyao.activity.XuanGouKeChengActivity;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/22.
 */

public class GrenYongHuShouYePeiXunBanAdapter extends MBaseAdapter <GrenYongHuShouYePeiXunBanAdapter.ViewHolder>{

    private Activity mActivity;
    public GrenYongHuShouYePeiXunBanAdapter(String s,Activity activity) {
        mActivity = activity;
        datas = JSONArray.parseArray(s);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, final JSONObject result) {
        Glide.with(mActivity).load(result.get("tpdz")).into(holder.img1);

        holder.title.setText( "" + result.get("pxbname").toString());
        holder.time.setText("" + result.get("pxtime").toString());

        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(mActivity,LearningActivity.class);
                    intent.putExtra("pxid",result.get("id").toString());
                    mActivity.startActivity(intent);
            }
        });

    }

    @Override
    protected int getItemLayout() {
        return R.layout.gerenyonghu_peixunxiangmu_item;
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
