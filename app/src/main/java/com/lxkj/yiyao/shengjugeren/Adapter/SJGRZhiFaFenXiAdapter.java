package com.lxkj.yiyao.shengjugeren.Adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/8.
 */

public class SJGRZhiFaFenXiAdapter extends MBaseAdapter<SJGRZhiFaFenXiAdapter.ViewHolder> {
    public SJGRZhiFaFenXiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //管辖从业人数
        holder.guanxiacongyerenshu.setText(""+result.get("guaxincongyerenshu"));
        //管辖企业数
        holder.guanxiaqiyeshu.setText(""+result.get("guanxiaqiyeshu"));
        //监管单位名称
        holder.jianguandanweimingcheng.setText(""+result.get("jianguandanweimingcheng"));
        //序号
        holder.xuhao.setText(""+result.get("xuhao"));
        //执法企业数量
        holder.zhifaqiyeshuliang.setText(""+result.get("zhifaqiyushuliang"));
        //执法人员数量
        holder.zhifarenyuanshuliang.setText(""+result.get("zhifarenyuanshuliang"));
        //执法人次
        holder.zhifarenci.setText(""+result.get("zhifarenci"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_zhifajilufenxi_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.jianguandanweimingcheng)
        TextView jianguandanweimingcheng;
        @BindView(R.id.zhifarenyuanshuliang)
        TextView zhifarenyuanshuliang;
        @BindView(R.id.guanxiaqiyeshu)
        TextView guanxiaqiyeshu;
        @BindView(R.id.guanxiacongyerenshu)
        TextView guanxiacongyerenshu;
        @BindView(R.id.zhifarenci)
        TextView zhifarenci;
        @BindView(R.id.zhifaqiyeshuliang)
        TextView zhifaqiyeshuliang;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
