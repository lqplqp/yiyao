package com.lxkj.yiyao.shiji.adapter;

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

public class CompanyManagerAdapter extends MBaseAdapter<CompanyManagerAdapter.ViewHolder> {
    public CompanyManagerAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //备注
        holder.beizhu.setText(""+result.get("bz"));
        //获取信息卡人数
        holder.huoquxinxikarenshu.setText(""+result.get("hqxxkrs"));
        //培训合格人数
        holder.peixunhegerenshu.setText(""+result.get("pxhgrs"));
        //企业名称
        holder.qiyemingcheng.setText(""+result.get("qymc"));
        //体检合格人数
        holder.tijianhegerenshu.setText(""+result.get("tjhgrs"));

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
        @BindView(R.id.qiyemingcheng)
        TextView qiyemingcheng;
        @BindView(R.id.tijianhegerenshu)
        TextView tijianhegerenshu;
        @BindView(R.id.peixunhegerenshu)
        TextView peixunhegerenshu;
        @BindView(R.id.huoquxinxikarenshu)
        TextView huoquxinxikarenshu;
        @BindView(R.id.guoqitixing)
        ImageView guoqitixing;
        @BindView(R.id.beizhu)
        TextView beizhu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
