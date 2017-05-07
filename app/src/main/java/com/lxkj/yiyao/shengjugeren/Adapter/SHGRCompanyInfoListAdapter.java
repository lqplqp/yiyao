package com.lxkj.yiyao.shengjugeren.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.QiYeRenYuanActivity;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class SHGRCompanyInfoListAdapter extends MBaseAdapter<SHGRCompanyInfoListAdapter.ViewHolder> {

    private Activity mActivity;
    public SHGRCompanyInfoListAdapter(String bean , Activity activity) {
        super(bean);
        mActivity = activity;
    }

    @Override
    protected void fillData(int i, ViewHolder holder, final JSONObject result) {
        //查看

        //企业名称
        holder.qiyemingcheng.setText("" + result.getString("qymc"));
        //从业人数
        holder.congyerenshu.setText("" + result.getString("cyrs"));
        //培训合格人数
        holder.peixunhegerenshu.setText("" + result.getString("pxhgrs"));
        //获得信息卡人数
        holder.huodexinxikarenshu.setText("" + result.getString("hdxxkrs"));
        //过期提醒(image)

        //备注
        holder.beizhu.setText(""+result.getString("bz"));
        //体检合格人数
        holder.tijianhegerenshu.setText("" + result.getString("tjhgrs"));

        holder.chakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, QiYeRenYuanActivity.class);
                intent.putExtra("qymc", result.getString("qymc"));
                mActivity.startActivity(intent);
//                ((MainActivity)mActivity).setIndexFragement(1);
            }
        });

        holder.qiyerenyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, QiYeRenYuanActivity.class);
                intent.putExtra("qymc", result.getString("qymc"));
                mActivity.startActivity(intent);
            }
        });


    }


    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_layout_person_qiye_info_list_itme;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.chakan)
        TextView chakan;
        @BindView(R.id.qiyemingcheng)
        TextView qiyemingcheng;
        @BindView(R.id.congyerenshu)
        TextView congyerenshu;
        @BindView(R.id.tijianhegerenshu)
        TextView tijianhegerenshu;
        @BindView(R.id.peixunhegerenshu)
        TextView peixunhegerenshu;
        @BindView(R.id.huodexinxikarenshu)
        TextView huodexinxikarenshu;
        @BindView(R.id.guoqitixin)
        ImageView guoqitixin;
        @BindView(R.id.beizhu)
        TextView beizhu;
        @BindView(R.id.qiyerenyuan)
        TextView qiyerenyuan;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
