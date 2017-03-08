package com.lxkj.yiyao.shiji.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class GongSiInfoAdapter extends MBaseAdapter<GongSiInfoAdapter.ViewHolder> {
    public GongSiInfoAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.adressTv.setText("" + result.get("adressTv"));
        holder.contactNameTv.setText("" + result.get("contactNameTy"));
        holder.doPersonTv.setText("" + result.get("doPersonTv"));
        holder.email.setText("" + result.get("email"));
        holder.emailTv.setText("" + result.get("emailTv"));
        holder.job.setText("" + result.get("job"));
        holder.managePersonTv.setText("" + result.get("managerPersonTv"));
        holder.phoneTv.setText("" + result.get("phoneTv"));
        holder.unitnameTv.setText("" + result.get("unitnameTv"));
        holder.usernameTv.setText("" + result.get("usernameTv"));
        holder.zone.setText("" + result.get("zone"));

    }


    @Override
    protected int getItemLayout() {
        return R.layout.gongsiinfo_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
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
        @BindView(R.id.email)
        TextView email;
        @BindView(R.id.job)
        TextView job;
        @BindView(R.id.zone)
        TextView zone;
        @BindView(R.id.adress_tv)
        TextView adressTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
