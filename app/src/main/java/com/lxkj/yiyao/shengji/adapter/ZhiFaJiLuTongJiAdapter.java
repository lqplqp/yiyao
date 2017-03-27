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

public class ZhiFaJiLuTongJiAdapter extends MBaseAdapter<ZhiFaJiLuTongJiAdapter.ViewHolder> {




    public ZhiFaJiLuTongJiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //监管单位名称
        holder.jianguandanweimingcheng.setText("" + result.getString("fbr"));
        //执法人员数量
        holder.zhifarenyuanshuliang.setText("" + result.getString("pxjssj"));
        //管辖企业数
        holder.guanxiaqiyeshu.setText("" + result.getString("pxkssj"));
        //管辖从业人数
        holder.guanxiacongyerenshu.setText("" + result.getString("peixundidian"));
        //执法人次
        holder.zhifarenci.setText("" + result.getString("tzbt"));
        //序号
        holder.xuhao.setText("" + result.getString("id"));
        //培训率
        holder.zhifaqiyeshuliang.setText("" + result.getString("tzlx"));

    }

    @Override
    protected int getItemLayout() {
        return R.layout.shengji_zhifajilutongji_item;
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
