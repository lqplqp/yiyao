package com.lxkj.yiyao.qiye.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/3 0003.
 */

public class QYSianedTrainAdapter extends MBaseAdapter<QYSianedTrainAdapter.ViewHolder> {


    public QYSianedTrainAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //序号
        holder.xuhao.setText("" + result.get("id"));
        //订单编号
        holder.dingdanbianhao.setText("" + result.get("ddbh"));
        //培训班名称
        holder.peixunbanmingcheng.setText("" + result.get("pxbmc"));
        //培训班类型
        holder.peixunbanleixing.setText("" + result.get("pxblx"));
        //培训时间
        holder.peixunshijian.setText("" + result.get("pxsj"));
        //实报人数
        holder.shibaorenshu.setText("" + result.get("sbrs"));
        //购客人数
        holder.goukerenshu.setText(""+result.get("gkrs"));
        //查看
        holder.chakan.setText("" + result.get("chakan"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.qysigntrain_item;
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
        @BindView(R.id.peixunshijian)
        TextView peixunshijian;
        @BindView(R.id.shibaorenshu)
        TextView shibaorenshu;
        @BindView(R.id.goukerenshu)
        TextView goukerenshu;
        @BindView(R.id.chakan)
        TextView chakan;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
