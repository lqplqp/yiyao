package com.lxkj.yiyao.shiji.adapter;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class CompanyInfoAdapter extends MBaseAdapter<CompanyInfoAdapter.ViewHolder> {
    public CompanyInfoAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {

        holder.username.setText("" + result.get("username"));
        holder.companyName.setText("" + result.get("companyName"));
        holder.peoplenumber.setText("" + result.get("peppleNumber"));
        holder.administrator.setText("" + result.get("administrator"));
        holder.email.setText("" + result.get("email"));
        holder.adress.setText("" + result.get("adress"));
        holder.phonenumber.setText("" + result.get("phonenumber"));
        holder.zone.setText("" + result.get("zone"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.jianguaninfo_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.username)
        EditText username;
        @BindView(R.id.company_name)
        EditText companyName;
        @BindView(R.id.peopleNumber)
        EditText peoplenumber;
        @BindView(R.id.administrator)
        EditText administrator;
        @BindView(R.id.email)
        EditText email;
        @BindView(R.id.phonenumber)
        EditText phonenumber;
        @BindView(R.id.zone)
        RadioButton zone;
        @BindView(R.id.adress)
        EditText adress;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
