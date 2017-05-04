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

public class SJGRJianGuanTongJiAdapter extends MBaseAdapter<SJGRJianGuanTongJiAdapter.ViewHolder> {
    public SJGRJianGuanTongJiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //监管单位名称
        holder.jianguandanweimingcheng.setText(""+result.get("jgdwmc"));
        //集中培训人数
        holder.jizhongpeixunrenshu.setText(""+result.get("jzpxrs"));
        //培训率
        holder.peixunlv.setText(""+result.get("pxl"));
        //网上培训人数
        holder.wangshangpeixunrenshu.setText(""+result.get("wspxrs"));
        //辖区管理人数
        holder.xiaquguanlirenshu.setText(""+result.get("xqnjgryrs"));
        //序号
        holder.xuhao.setText(""+result.get("id"));
        //用户名
        holder.yonghuming.setText(""+result.get("yhm"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_jianguantongji_item;
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
        @BindView(R.id.yonghuming)
        TextView yonghuming;
        @BindView(R.id.xiaquguanlirenshu)
        TextView xiaquguanlirenshu;
        @BindView(R.id.jizhongpeixunrenshu)
        TextView jizhongpeixunrenshu;
        @BindView(R.id.wangshangpeixunrenshu)
        TextView wangshangpeixunrenshu;
        @BindView(R.id.peixunlv)
        TextView peixunlv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
