package com.lxkj.yiyao.shengjugeren.Adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/31.
 */

public class SJGRShouYeTongZhiAdapter extends MBaseAdapter <SJGRShouYeTongZhiAdapter.ViewHolder>{

    public SJGRShouYeTongZhiAdapter(String bean) {
        datas = JSONArray.parseArray(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //状态
        holder.peixunzhuangtai.setText("状态："+result.get("zt"));
        //通知标题
        holder.tongzhibiaoti.setText(""+result.get("tzbt"));
        //通知时间
        holder.tongzhishijian.setText("网上培训通知  发布时间："+result.get("cjsj"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.shengjigeren_shouye_tongzhixaoxi;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.tongzhishijian)
        TextView tongzhishijian;
        @BindView(R.id.peixunzhuangtai)
        TextView peixunzhuangtai;
        @BindView(R.id.tongzhibiaoti)
        TextView tongzhibiaoti;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
