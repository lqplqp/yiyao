package com.lxkj.yiyao.shengji.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/3.
 */

public class PeiXunListAdapter extends MBaseAdapter<PeiXunListAdapter.ViewHolder> {




    public PeiXunListAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
//        holder.caozuo.setText("" + result.get("caozuo"));
        //序号
        holder.xuhao.setText("" + result.getString("xh"));
        //订单编号
        holder.dingdanbianhao.setText("" + result.getString("ddh"));
        //培训班类型
        holder.peixunbanleixing.setText("" + result.getString(" pxlx"));
        //培训班名称
        holder.peixunbanmingcheng.setText("" + result.getString("pxbmc"));
        //培训时间
        holder.peixuntime.setText("" + result.getString("pxkssj"));
        //实报人数
        holder.shibaorenshu.setText("" + result.getString("sbrs"));
        //购课人数
        holder.goukerenshu.setText("" + result.getString("gkrs"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.shengji_yibao_peixunlist_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.dingdanbianhao)
        TextView dingdanbianhao;
        @BindView(R.id.peixunbanmingcheng)
        TextView peixunbanmingcheng;
        @BindView(R.id.peixunbanleixing)
        TextView peixunbanleixing;
        @BindView(R.id.peixuntime)
        TextView peixuntime;
        @BindView(R.id.shibaorenshu)
        TextView shibaorenshu;
        @BindView(R.id.goukerenshu)
        TextView goukerenshu;
        @BindView(R.id.caozuo)
        TextView caozuo;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
