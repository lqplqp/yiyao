package com.lxkj.yiyao.shengjugeren.Adapter;

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

public class SJGRCompanyInfoLisrAdapter extends MBaseAdapter <SJGRCompanyInfoLisrAdapter.ViewHolder>{

    public SJGRCompanyInfoLisrAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //用户姓名
        holder.username.setText(""+result.getString("username"));
        //性别
        holder.sex.setText(""+result.getString("sex"));
        //体检信息编号
        holder.tijianxinxibianhao.setText(""+result.getString("tijainxinxibianhao"));
        //体检信息有效期
        holder.tijianxinxiyouxiaoqi.setText(""+result.getString("tijianxinxiyouxiaoqi"));
        //培训证号
        holder.peixunzhenghao.setText(""+result.getString("peixunzhenghao"));
        //培训证有效期
        holder.peixunzhengyouxiaoqi.setText(""+result.getString("peixuzhengyouxiaoqi"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_fragment_layout_qiye_info_list_search_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.username)
        TextView username;//用户姓名
        @BindView(R.id.sex)
        TextView sex;//性别
        @BindView(R.id.tijianxinxibianhao)
        TextView tijianxinxibianhao;//
        @BindView(R.id.tijianxinxiyouxiaoqi)
        TextView tijianxinxiyouxiaoqi;//
        @BindView(R.id.peixunzhenghao)
        TextView peixunzhenghao;//
        @BindView(R.id.peixunzhengyouxiaoqi)
        TextView peixunzhengyouxiaoqi;//

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
