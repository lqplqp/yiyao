package com.lxkj.yiyao.shengjugeren.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class SHGRCompanyInfoListAdapter extends MBaseAdapter<SHGRCompanyInfoListAdapter.ViewHolder> {
    public SHGRCompanyInfoListAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //查看

        //企业名称
        holder.qiyemingcheng.setText(""+result.getString("qiyemingcheng"));
        //从业人数
        holder.congyerenshu.setText(""+result.getString("congyerenshu"));
        //培训合格人数
        holder.peixunhegerenshu.setText(""+result.getString("peixunhegerenshu"));
        //获得信息卡人数
        holder.huodexinxikarenshu.setText(""+result.getString("huodexinxikarenshu"));
        //过期提醒(image)
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

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
