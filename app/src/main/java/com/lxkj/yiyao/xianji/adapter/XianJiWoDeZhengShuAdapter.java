package com.lxkj.yiyao.xianji.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.ImageActivity;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class XianJiWoDeZhengShuAdapter extends MBaseAdapter<XianJiWoDeZhengShuAdapter.ViewHolder> {

private Context context;
    public XianJiWoDeZhengShuAdapter(String bean) {
        super(bean);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void fillData(int i, ViewHolder holder, final JSONObject result) {
        holder.zhengshumingcheng.setText("" + result.getString("zsname"));
        holder.zhengshumingcheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImageActivity.class);
                intent.putExtra("url", "" + GlobalString.BaseURL + result.getString("imageurl"));
                context.startActivity(intent);
            }
        });
    }


    @Override
    protected int getItemLayout() {
        return R.layout.xianjiwodezhengshu_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.zhengshumingcheng)
        TextView zhengshumingcheng;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
