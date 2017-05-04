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

public class TiJianTongJiAdapter extends MBaseAdapter<TiJianTongJiAdapter.ViewHolder> {


    public TiJianTongJiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //不合格人数
        holder.buhegerenshu.setText(""+result.get("buhegerenshu"));
        //合格人数
        holder.hegerenshu.setText(""+result.get("buhegerenshu"));
        //体检单位
        holder.tijiandanwei.setText(""+result.get("tijiandanwei"));
        //体检合格率
        holder.tijianhegelv.setText(""+result.get("tijianhegelv"));
        //体检人数
        holder.tijianrenshu.setText(""+result.get("tijianrenshu"));
        //序号
        holder.xuhao.setText(""+result.get("id"));

    }

    @Override
    protected int getItemLayout() {
        return R.layout.shengji_tijian_tonghi_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.tijiandanwei)
        TextView tijiandanwei;
        @BindView(R.id.tijianrenshu)
        TextView tijianrenshu;
        @BindView(R.id.hegerenshu)
        TextView hegerenshu;
        @BindView(R.id.buhegerenshu)
        TextView buhegerenshu;
        @BindView(R.id.tijianhegelv)
        TextView tijianhegelv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
