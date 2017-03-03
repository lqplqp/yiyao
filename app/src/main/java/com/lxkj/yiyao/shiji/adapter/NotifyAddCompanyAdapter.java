package com.lxkj.yiyao.shiji.adapter;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class NotifyAddCompanyAdapter extends MBaseAdapter<NotifyAddCompanyAdapter.ViewHolder> {
    public NotifyAddCompanyAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.hangyeleixing.setText(""+result.get("hangyeleixing"));
        holder.keshi.setText(""+result.get("keshi"));
        holder.peixunbanType.setText(""+result.get("peixunbanType"));
        holder.peixuncontent.setText(""+result.get("peixuncontent"));
        holder.peixundidian.setText(""+result.get("peixundidian"));
        holder.peixunfaqi.setText(""+result.get("peixunfaqi"));
        holder.peixunjieshu.setText(""+result.get("peixunjieshu"));
        holder.peixunshijian.setText(""+result.get("peixunshijian"));
        holder.qitapeixun.setText(""+result.get("qitapeixun"));
        holder.tongzhibiaoti.setText(""+result.get("tongzhibiaoti"));
        holder.tongzhidiqu.setText(""+result.get("tongzhidiqu"));
        holder.tongzhigangwei.setText(""+result.get("tongzhigangwei"));
        holder.zhengshumoban.setText(""+result.get("zhengshumoban"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.addcompany_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return  new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.peixunfaqi)
        EditText peixunfaqi;
        @BindView(R.id.keshi)
        EditText keshi;
        @BindView(R.id.tongzhibiaoti)
        EditText tongzhibiaoti;
        @BindView(R.id.tongzhirenyuan)
        RadioGroup tongzhirenyuan;
        @BindView(R.id.tongzhidiqu)
        EditText tongzhidiqu;
        @BindView(R.id.tongzhigangwei)
        EditText tongzhigangwei;
        @BindView(R.id.peixunleixing)
        EditText peixunleixing;
        @BindView(R.id.hangyeleixing)
        EditText hangyeleixing;
        @BindView(R.id.peixunbanType)
        EditText peixunbanType;
        @BindView(R.id.zhengshumoban)
        EditText zhengshumoban;
        @BindView(R.id.peixunshijian)
        EditText peixunshijian;
        @BindView(R.id.peixunjieshu)
        EditText peixunjieshu;
        @BindView(R.id.peixundidian)
        EditText peixundidian;
        @BindView(R.id.peixuncontent)
        EditText peixuncontent;
        @BindView(R.id.qitapeixun)
        EditText qitapeixun;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
