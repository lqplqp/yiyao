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

public class ShengJiPeiXunMessageSearchAdapter extends MBaseAdapter<ShengJiPeiXunMessageSearchAdapter.ViewHolder> {




    public ShengJiPeiXunMessageSearchAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //结束时间
        holder.jieshushijian.setText("" + result.getString("pxjssj"));
        //开始时间
        holder.kaishishijian.setText("" + result.getString("pxkssj"));
        //适用地区
        holder.shiyongdiqu.setText("" + result.getString("peixundidian"));
        //培训标题
        holder.peixunbiaoti.setText("" + result.getString("tzbt"));
        //发起单位
        holder.faqidanwei.setText("" + result.getString("tzdw"));
        //培训类型
        holder.peixunleixing.setText("" + result.getString("tzlx"));
        //序号
        holder.xuhao.setText("" + result.getString("xuhao"));
        //创建时间
        holder.chuangjianshijian.setText("");
        //发布状态
        holder.fabuzhuangtai.setText("'");
    }

    @Override
    protected int getItemLayout() {
        return R.layout.shengji_peixun_tongzhiguanli_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.faqidanwei)
        TextView faqidanwei;
        @BindView(R.id.peixunbiaoti)
        TextView peixunbiaoti;
        @BindView(R.id.peixunleixing)
        TextView peixunleixing;
        @BindView(R.id.kaishishijian)
        TextView kaishishijian;
        @BindView(R.id.jieshushijian)
        TextView jieshushijian;
        @BindView(R.id.shiyongdiqu)
        TextView shiyongdiqu;
        @BindView(R.id.chuangjianshijian)
        TextView chuangjianshijian;
        @BindView(R.id.fabuzhuangtai)
        TextView fabuzhuangtai;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
