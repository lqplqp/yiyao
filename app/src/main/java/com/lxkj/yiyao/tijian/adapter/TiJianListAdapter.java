package com.lxkj.yiyao.tijian.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.MuBanActivity;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/5/1 0001.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class TiJianListAdapter extends MBaseAdapter<TiJianListAdapter.ViewHolder> {


    public TiJianListAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, final JSONObject result) {



        //序号
        holder.xuhao.setText("" + result.get("id"));
        //体检报告编号
        holder.tijianbaogaohao.setText("" + result.get("tjbgh"));
        //姓名
        holder.xingming.setText(""+ result.get("xm"));
        //身份证号
        holder.shenfenzhenghao.setText(""+result.get("sfzh"));

        //性别
        holder.xingbie.setText(""+result.get("xb"));
        //体检时间
        holder.tijianshijian.setText(""+result.get("tjsj"));
        //是否合格
        holder.shifouhege.setText(""+result.get("sfhg"));
        //查看
        holder.chakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object pic = result.get("pic");
                if(pic!=null){
                    Intent intent = new Intent(v.getContext(), MuBanActivity.class);
                    intent.putExtra("imagePath",pic.toString());
                    v.getContext().startActivity(intent);
                }else {
                    ToastUtil.show("当前用户未上传体检报告单");
                }
            }
        });
    }

    @Override
    protected int getItemLayout() {
        return R.layout.tijian_list_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.tijianbaogaohao)
        TextView tijianbaogaohao;
        @BindView(R.id.xingming)
        TextView xingming;
        @BindView(R.id.shenfenzhenghao)
        TextView shenfenzhenghao;
        @BindView(R.id.xingbie)
        TextView xingbie;
        @BindView(R.id.tijianshijian)
        TextView tijianshijian;
        @BindView(R.id.shifouhege)
        TextView shifouhege;
        @BindView(R.id.chakan)
        TextView chakan;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
