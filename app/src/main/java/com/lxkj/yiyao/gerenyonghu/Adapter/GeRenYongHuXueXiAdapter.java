package com.lxkj.yiyao.gerenyonghu.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.ExamActivity;
import com.lxkj.yiyao.activity.PlayerActivity;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/26.
 */

public class GeRenYongHuXueXiAdapter extends MBaseAdapter <GeRenYongHuXueXiAdapter.ViewHolder>{
    private Activity mActivity;
    public GeRenYongHuXueXiAdapter(Activity activity ,String s) {
        datas = JSONArray.parseArray(s);
        mActivity = activity;
    }

    @Override
    protected void fillData(int i, ViewHolder holder, final JSONObject result) {
        holder.name.setText(""+result.get("jckcmc"));
        holder.xuexi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, PlayerActivity.class);
                intent.putExtra("VIDEO_PATH","http://af.0101hr.com"+result.get("xxlj").toString());
                intent.putExtra("video_hd_url","http://af.0101hr.com"+result.get("xxlj").toString());
                //String s = "http://af.0101hr.com"+result.get("xxlj").toString();
                mActivity.startActivity(intent);
            }
        });
        holder.kaoshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show("考试");
                Intent intent = new Intent(mActivity, ExamActivity.class);
                intent.putExtra("kmid",result.get   ("id").toString());
                mActivity.startActivity(intent);
            }
        });

    }

    @Override
    protected int getItemLayout() {
        return R.layout.basic_kechengxueix_name;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.xuexi)
        TextView xuexi;
        @BindView(R.id.kaoshi)
        TextView kaoshi;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
