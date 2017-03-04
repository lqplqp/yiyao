package com.lxkj.yiyao.shiji.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/3.
 */

public class QiYeInfoAdapter extends MBaseAdapter<QiYeInfoAdapter.ViewHolder> {
    public QiYeInfoAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.adressTv.setText("" + result.get("adressTv"));
        holder.contactNameTv.setText("" + result.get("contactNameTv"));
        holder.doPersonTv.setText("" + result.get("daPersonTv"));
        holder.emailTv.setText("" + result.get("emailTv"));
        holder.emial.setText("" + result.get("emial"));
        holder.hangyelingyu.setText("" + result.get("hangyelingyu"));
        holder.managePersonTv.setText("" + result.get("managerPersonTv"));
        holder.phoneTv.setText("" + result.get("phoneTv"));
        holder.suozaidiqu.setText("" + result.get("zuozaidiqu"));
        holder.unitnameTv.setText("" + result.get("unitnameTv"));
        holder.usernameTv.setText("" + result.get("usernameTv"));

    }


    @Override
    protected int getItemLayout() {
        return R.layout.qiye_info_ichakan_tem;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return  new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.username_tv)
        TextView usernameTv;
        @BindView(R.id.unitname_tv)
        TextView unitnameTv;
        @BindView(R.id.do_person_tv)
        TextView doPersonTv;
        @BindView(R.id.manage_person_tv)
        TextView managePersonTv;
        @BindView(R.id.contact_name_tv)
        TextView contactNameTv;
        @BindView(R.id.email_tv)
        TextView emailTv;
        @BindView(R.id.phone_tv)
        TextView phoneTv;
        @BindView(R.id.emial)
        TextView emial;
        @BindView(R.id.hangyelingyu)
        TextView hangyelingyu;
        @BindView(R.id.suozaidiqu)
        TextView suozaidiqu;
        @BindView(R.id.adress_tv)
        TextView adressTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
