package com.lxkj.yiyao.activity.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/25 0025.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class KaoShiJieGuoZhiFaAdapter extends MBaseAdapter<KaoShiJieGuoZhiFaAdapter.ViewHolder> {


    public KaoShiJieGuoZhiFaAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        holder.name.setText(result.get("name").toString());

        holder.score.setText(result.get("score").toString());
    }

    @Override
    protected int getItemLayout() {
        return R.layout.kaoshijieguozhifa_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.score)
        TextView score;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
