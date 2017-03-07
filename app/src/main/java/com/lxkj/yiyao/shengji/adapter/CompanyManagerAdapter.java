package com.lxkj.yiyao.shengji.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class CompanyManagerAdapter extends MBaseAdapter<CompanyManagerAdapter.ViewHolder> {


    public CompanyManagerAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.enterpriseName.setText("" + result.get("qymc"));
        holder.getInfoPeople.setText("" + result.get("hqxxkrs"));
        holder.tijianhegePeople.setText("" + result.get("tjhgrs"));
        holder.peixunhegeRenshu.setText("" + result.get("pxhgrs"));
        holder.beizhu.setText("" + result.get("bz"));
        /*if ((Boolean) result.get("gqtx")){
            holder.gqtx.setImageResource(R.mipmap.green_ture);
        }else {
            holder.gqtx.setImageResource(R.mipmap.red_point);
        }*/

    }


    @Override
    protected int getItemLayout() {
        return R.layout.companymanager_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.textView26)
        TextView textView26;
        @BindView(R.id.enterpriseName)
        TextView enterpriseName;
        @BindView(R.id.tijianhege_people)
        TextView tijianhegePeople;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.peixunhege_renshu)
        TextView peixunhegeRenshu;
        @BindView(R.id.getInfoPeople)
        TextView getInfoPeople;
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.gqtx)
        ImageView gqtx;
        @BindView(R.id.beizhu)
        TextView beizhu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
