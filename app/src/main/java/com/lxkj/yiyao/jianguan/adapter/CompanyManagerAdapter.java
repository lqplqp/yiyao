package com.lxkj.yiyao.jianguan.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.utils.ToastUtil;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class CompanyManagerAdapter extends MBaseAdapter<CompanyManagerAdapter.ViewHolder> {

    public CompanyManagerAdapter(String bean) {
        super(bean);
    }

    protected void fillData(int i, ViewHolder holder , com.alibaba.fastjson.JSONObject result) {

        //企业名称
        holder.qiyeName.setText(result.get("qymc").toString());
        //体检合格人数
        holder.tijianhegePeople.setText(result.get("tjhgrs").toString());

        //培训合格人数
        holder.peixunhegeRenshu.setText(result.get("pxhgrs").toString());
        //获取信息卡人数
        holder.infocardRenshu.setText(result.get("hdxxkrs").toString());
        // TODO: 2017/3/2 0002  true和false
        //备注
        holder.beizhu.setText(result.get("bz").toString());

    }

    @Override
    protected int getItemLayout() {
        return R.layout.qiyeguanli_table_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
}

    static class ViewHolder extends BaseHolder{
        @BindView(R.id.chakan)
        TextView chakan;
        @BindView(R.id.qiyerenyuan)
        TextView qiyerenyuan;
        @BindView(R.id.qiye_name)
        TextView qiyeName;
        @BindView(R.id.tijianhege_people)
        TextView tijianhegePeople;
        @BindView(R.id.peixunhege_renshu)
        TextView peixunhegeRenshu;
        @BindView(R.id.infocard_renshu)
        TextView infocardRenshu;
        @BindView(R.id.guoqitixing)
        LinearLayout guoqitixing;
        @BindView(R.id.beizhu)
        TextView beizhu;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
