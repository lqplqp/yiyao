package com.lxkj.yiyao.jianguan.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class LawManagerAdapter extends MBaseAdapter<LawManagerAdapter.ViewHolder> {




    public LawManagerAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {



        //序号
        holder.xuhao.setText("" + result.get("id"));

        //执法编号
        holder.zhifabianhao.setText("" + result.get("zfbh"));

        //执法人姓名
        holder.zhifarenxingming.setText("" + result.get("zfrxm"));

        //执法时间
        holder.zhifashijian.setText("" + result.get("zfsj"));

        //许可证编号
        holder.xukezhengbianhao.setText("" + result.get("bzfrxxkbh"));


        //被执法人
        holder.beizhifaren.setText("" + result.get("bzfrxm"));


        //执法类型
        holder.zhifaleixing.setText("" + result.get("zflx"));




    }


    @Override
    protected int getItemLayout() {
        return R.layout.jglawmanager_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.zhifabianhao)
        TextView zhifabianhao;
        @BindView(R.id.zhifarenxingming)
        TextView zhifarenxingming;
        @BindView(R.id.zhifashijian)
        TextView zhifashijian;
        @BindView(R.id.xukezhengbianhao)
        TextView xukezhengbianhao;
        @BindView(R.id.beizhifaren)
        TextView beizhifaren;
        @BindView(R.id.zhifaleixing)
        TextView zhifaleixing;
        @BindView(R.id.chakan)
        TextView chakan;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
