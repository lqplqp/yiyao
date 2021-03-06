package com.lxkj.yiyao.shengjugeren.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.LearningActivity;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class SJGRYiBaoPeiXunAdapter extends MBaseAdapter<SJGRYiBaoPeiXunAdapter.ViewHolder> {

    private Activity activity;



    public SJGRYiBaoPeiXunAdapter(String bean) {
        super(bean);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //序号
        holder.xuhao.setText("" + result.getString("id"));
        //培训名次
        holder.peixunleixing.setText("" + result.getString("pxbmc"));
        //培训类型
        holder.peixunleixing.setText("" + result.getString("pxblx"));
        final String id = result.getString("cid");
        holder.caozuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, LearningActivity.class);
                intent.putExtra("pxid", id);
                intent.putExtra("user_type", -1);

                activity.startActivity(intent);
            }
        });
       /* //培训时间
        holder.peixunshijian.setText(""+result.getString("pxkssj"));
        //证书名称
        holder.zhengshumingcheng.setText(""+result.getString("pxbt"));
        //购买时间
        holder.goumaishijian.setText(""+result.getString("cjsj"));
        //学习进度
        holder.xuexijindu.setText(""+result.getString("xxjd"));
        //查看*/
    }


    @Override
    protected int getItemLayout() {
        return R.layout.qy_layout_yiyao_peixun_item;
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
        @BindView(R.id.caozuo)
        TextView caozuo;
      /*  @BindView(R.id.peixunshijian)
        TextView peixunshijian;
        @BindView(R.id.zhengshumingcheng)
        TextView zhengshumingcheng;
        @BindView(R.id.goumaishijian)
        TextView goumaishijian;
        @BindView(R.id.xuexijindu)
        TextView xuexijindu;
        @BindView(R.id.chakan)
        TextView chakan;*/

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
