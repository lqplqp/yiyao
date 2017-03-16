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

public class SJGRTiJianTongJiAdapter extends MBaseAdapter<SJGRTiJianTongJiAdapter.ViewHolder> {


    public SJGRTiJianTongJiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //人数
        holder.renshu.setText(""+result.getString(" tjrs"));
        //体检单位
        holder.tijaindanwei.setText(""+result.getString("tjdw"));
        //序号
        holder.xuhao.setText("" + result.getString("xuhao"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_tijian_tongji_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.tijaindanwei)
        TextView tijaindanwei;
        @BindView(R.id.renshu)
        TextView renshu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
