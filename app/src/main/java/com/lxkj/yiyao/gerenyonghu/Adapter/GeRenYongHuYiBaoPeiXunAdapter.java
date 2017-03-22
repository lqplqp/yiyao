package com.lxkj.yiyao.gerenyonghu.Adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/19.
 */

public class GeRenYongHuYiBaoPeiXunAdapter extends MBaseAdapter<GeRenYongHuYiBaoPeiXunAdapter.ViewHolder> {
    public GeRenYongHuYiBaoPeiXunAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //查看
        holder.chakan.setText(""+result.get("chakan"));
        //购买时间
        holder.goumaishijian.setText(""+result.get("cjsj"));
        //培训类型
        holder.peixunleixing.setText(""+result.get(" pxlx"));
        //培训时间
        holder.peixunshijian.setText(""+result.get("pxkssj"));
        //培训名次
        holder.peixunmingci.setText(""+result.get("pxbmc"));
        //培训进度
        holder.xuexijindu.setText(""+result.get("xxjd"));
        //序号
        holder.xuhao.setText(""+result.get("xuhao"));
        //证书名称
        holder.zhengshumingcheng.setText(""+result.get("pxbt"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.gerenyonghu_yibaopeixunxiangmu_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.peixunmingci)
        TextView peixunmingci;
        @BindView(R.id.peixunleixing)
        TextView peixunleixing;
        @BindView(R.id.peixunshijian)
        TextView peixunshijian;
        @BindView(R.id.zhengshumingcheng)
        TextView zhengshumingcheng;
        @BindView(R.id.goumaishijian)
        TextView goumaishijian;
        @BindView(R.id.xuexijindu)
        TextView xuexijindu;
        @BindView(R.id.chakan)
        TextView chakan;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
