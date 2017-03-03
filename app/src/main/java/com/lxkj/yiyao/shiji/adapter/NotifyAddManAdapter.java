package com.lxkj.yiyao.shiji.adapter;

import android.view.View;
import android.widget.EditText;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/3.
 */

public class NotifyAddManAdapter extends MBaseAdapter<NotifyAddManAdapter.ViewHolder> {
    public NotifyAddManAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.hangyeleixing.setText("" + result.get("hangyeleixing"));
        holder.keshi.setText("" + result.get("keshi"));
        holder.peixunbanleixing.setText("" + result.get("peixunbanleixing"));
        holder.peixundidian.setText("" + result.get("peixundidian"));
        holder.peixunfaqidanwei.setText("" + result.get("peixunfaqidanwei"));
        holder.peixunjieshu.setText("" + result.get("peixunjieshu"));
        holder.peixunkaishi.setText("" + result.get("peixunkaishi"));
        holder.peixunleixing.setText("" + result.get("peixunleixing"));
        holder.peixunneirong.setText("" + result.get("peixunneirong"));
        holder.peixuntongzhibiaoti.setText("" + result.get("peixuntongzhibiaoti"));
        holder.qitapeixun.setText("" + result.get("qitapeixun"));
        holder.tongzhidiqu.setText("" + result.get("tongzhidiqu"));
        holder.tongzhigangwei.setText("" + result.get("tongzhigangwei"));
        holder.zhengshumoban.setText("" + result.get("zhengshumoban"));


    }


    @Override
    protected int getItemLayout() {
        return R.layout.addman_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.peixunfaqidanwei)
        EditText peixunfaqidanwei;
        @BindView(R.id.keshi)
        EditText keshi;
        @BindView(R.id.peixuntongzhibiaoti)
        EditText peixuntongzhibiaoti;
        @BindView(R.id.tongzhidiqu)
        EditText tongzhidiqu;
        @BindView(R.id.tongzhigangwei)
        EditText tongzhigangwei;
        @BindView(R.id.peixunleixing)
        EditText peixunleixing;
        @BindView(R.id.hangyeleixing)
        EditText hangyeleixing;
        @BindView(R.id.peixunbanleixing)
        EditText peixunbanleixing;
        @BindView(R.id.zhengshumoban)
        EditText zhengshumoban;
        @BindView(R.id.peixunkaishi)
        EditText peixunkaishi;
        @BindView(R.id.peixunjieshu)
        EditText peixunjieshu;
        @BindView(R.id.peixundidian)
        EditText peixundidian;
        @BindView(R.id.peixunneirong)
        EditText peixunneirong;
        @BindView(R.id.qitapeixun)
        EditText qitapeixun;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
