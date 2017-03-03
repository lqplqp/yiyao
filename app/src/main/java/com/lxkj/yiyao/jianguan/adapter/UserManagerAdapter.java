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

public class UserManagerAdapter extends MBaseAdapter<UserManagerAdapter.ViewHolder> {

    public UserManagerAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {
        //用户姓名
        holder.userName.setText("" + result.get("user_name"));
        //性别
        holder.userSex.setText("" + result.get("user_sex"));
        //体检报告号
        holder.tijianbaogaohao.setText("" + result.get("tjbgh"));
        //培训证号
        holder.peixunzhenghao.setText("" + result.get("pxzh"));
        //培训有效期
        holder.peixunyouxiaoqi.setText("" + result.get("pxyxq"));
        //消息提醒
        holder.xiaoxitixing.setText(""+result.get("xxtx"));
    }


    @Override
    protected int getItemLayout() {
        return R.layout.jg_usermanager_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.user_name)
        TextView userName;
        @BindView(R.id.user_sex)
        TextView userSex;
        @BindView(R.id.tijianbaogaohao)
        TextView tijianbaogaohao;
        @BindView(R.id.peixunzhenghao)
        TextView peixunzhenghao;
        @BindView(R.id.peixunyouxiaoqi)
        TextView peixunyouxiaoqi;

        @BindView(R.id.xiaoxitixing)
        TextView xiaoxitixing;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
