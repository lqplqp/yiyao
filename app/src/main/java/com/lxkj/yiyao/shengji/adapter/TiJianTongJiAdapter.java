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
        //人数
        holder.renshu.setText(""+result.getString(" tjrs"));
        //体检单位
        holder.tijaindanwei.setText(""+result.getString("tjdw"));
        //序号
        holder.xuhao.setText("" + result.getString("id"));
        holder.zongji.setText("" + result.getString("tj"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.tijian_tonghi_item;
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
        @BindView(R.id.zongji)
        TextView zongji;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
