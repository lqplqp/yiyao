package com.lxkj.yiyao.shengjugeren.Adapter;

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

public class SJGRZhiFaSearch extends MBaseAdapter<SJGRZhiFaSearch.ViewHolder> {

    public SJGRZhiFaSearch(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //被指法人编号
        holder.beizhifarenbianhao.setText("" + result.getString("beizhifarenbianhao"));
        //被指法人姓名
        holder.bzhifarenxingm.setText("" + result.getString("biezhifarenxingming"));
        //序号
        holder.xuhao.setText("" + result.getString("xuhao"));
        //培训开始时间
        holder.peixunkaishishijian.setText("" + result.getString("peixunkaoshishijian"));
        //执法编号
        holder.zhifabianhao.setText("" + result.getString("zhifabianhao"));
        //执法类型
        holder.zhifaleixing.setText("" + result.getString("zhifaleixing"));
        //执法人姓名
        holder.zhifarenxingming.setText("" + result.getString("zhifarenxingming"));
    }

    @Override
    protected int getItemLayout() {
        return R.layout.zhifa_search_item;
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
        @BindView(R.id.beizhifarenbianhao)
        TextView beizhifarenbianhao;
        @BindView(R.id.biezhifarenxingming)
        TextView bzhifarenxingm;
        @BindView(R.id.zhifaleixing)
        TextView zhifaleixing;
        @BindView(R.id.peixunkaishishijian)
        TextView peixunkaishishijian;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
