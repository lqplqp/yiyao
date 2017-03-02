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

public class JGCompanyManAdapter extends MBaseAdapter<JGCompanyManAdapter.ViewHolder> {


    public JGCompanyManAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, JSONObject result) {

        //// TODO: 2017/3/2  在这把数据填充进去就gg
        //序号
        holder.number.setText(""+result.get("xuhao"));

        //用户账号
        holder.username.setText(""+result.get("username"));

        //用户名
        holder.userName.setText(""+result.get("user_name"));


        // 这个类就结束了 gg

    }



    //这个方法就是获取布局id的,获取完了只后 鼠标放到布局id上面右键 选择
    @Override
    protected int getItemLayout() {
        return R.layout.jgcompanyman_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    //然后就生成了这个玩意  把泛型给Adapter
    static class ViewHolder {
        @BindView(R.id.number)
        TextView number;
        @BindView(R.id.username)
        TextView username;
        @BindView(R.id.user_name)
        TextView userName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
