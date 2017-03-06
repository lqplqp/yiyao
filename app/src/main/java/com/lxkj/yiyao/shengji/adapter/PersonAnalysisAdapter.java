package com.lxkj.yiyao.shengji.adapter;

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

public class PersonAnalysisAdapter extends MBaseAdapter <PersonAnalysisAdapter.ViewHolder>{

    public PersonAnalysisAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //市区
        holder.shiqu.setText(""+result.getString("shiqu"));
        //县区
        holder.xianqu.setText(""+result.getString("xianqu"));
        //已报名培训人数
        holder.yibaomingpeixunrenshu.setText(""+result.getString("yibaomingpeixunrenshu"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_person_analysis_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.shiqu)
        TextView shiqu;
        @BindView(R.id.xianqu)
        TextView xianqu;
        @BindView(R.id.yibaomingpeixunrenshu)
        TextView yibaomingpeixunrenshu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
