package com.lxkj.yiyao.activity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.LearningActivity;
import com.lxkj.yiyao.activity.XuanGouKeChengRenYuanActivity;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/8 0008.
 */

public class SelectTrainAdapter extends MBaseAdapter<SelectTrainAdapter.ViewHolder> {


    private Activity mActivity;

    public SelectTrainAdapter(String bean, Activity activity) {
        super(bean);
        mActivity = activity;

    }

    public boolean isQiye_admin() {
        return qiye_admin;
    }

    public void setQiye_admin(boolean qiye_admin) {
        this.qiye_admin = qiye_admin;
    }

    public boolean qiye_admin = false;

    @Override
    protected void fillData(int i, ViewHolder holder, final JSONObject result) {
        String tpdz = GlobalString.BaseURL + "uploads/" + result.getString("tpdz");
        Log.d("fillData", "" + tpdz);

        String s1 = "http://af.0101hr.com/uploads/20170426/0efd0c86a367eb771aea792ffc3043f1.png";
        String s = "http://mmbiz.qpic.cn/mmbiz_png/Wmfr3h5BMxfSp6BjD9M4Gf57EyWnvwRbhhjNXRe7libFNAVibDRtzAceicp2HwcuCSCQgxMORibbNueLlDD9ZY9icgg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1";
        Glide.with(mActivity).load(tpdz).into(holder.img1);

        holder.title.setText("" + result.get("bt").toString());
        holder.time.setText("" + result.get("pxsj").toString());

        holder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!qiye_admin) {
                    Intent intent = new Intent(mActivity, LearningActivity.class);
                    intent.putExtra("pxid", result.get("id").toString());
                    mActivity.startActivity(intent);
                } else {
                    Intent intent = new Intent(mActivity, XuanGouKeChengRenYuanActivity.class);
                    intent.putExtra("pxid", result.get("id").toString());
                    mActivity.startActivity(intent);
                }
            }
        });

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
        @BindView(R.id.root_layout)
        LinearLayout rootLayout;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
