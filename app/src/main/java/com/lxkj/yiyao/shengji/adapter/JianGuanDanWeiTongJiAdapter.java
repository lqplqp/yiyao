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

public class JianGuanDanWeiTongJiAdapter extends MBaseAdapter<JianGuanDanWeiTongJiAdapter.ViewHolder> {


    public JianGuanDanWeiTongJiAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //监管单位名称
        holder.jianguandanweimingcheng.setText("" + result.getString("fbr"));
        //用户名
        holder.yonghuming.setText("" + result.getString("pxjssj"));
        //辖区内监管人员人数
        holder.xiaquneirenshu.setText("" + result.getString("pxkssj"));
        //集中培训人数
        holder.jizhongpeixunrenshu.setText(""+result.getString("peixundidian"));
        //网上培训人数
        holder.wangshangpeixunrenshu.setText("" + result.getString("tzbt"));
        //序号
        holder.xuhao.setText("" + result.getString("id"));
        //培训率
        holder.peixunlv.setText("" + result.getString("tzlx"));

    }

    @Override
    protected int getItemLayout() {
        return R.layout.shengji_jianguandanweitongji_item;
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
        @BindView(R.id.xiaquneirenshu)
        TextView xiaquneirenshu;
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
