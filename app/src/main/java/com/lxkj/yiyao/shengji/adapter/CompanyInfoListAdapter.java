package com.lxkj.yiyao.shengji.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.shengji.QiYeRenYuanActivity;
import com.lxkj.yiyao.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2.
 */

public class CompanyInfoListAdapter extends MBaseAdapter<CompanyInfoListAdapter.ViewHolder> {

    private Context context;


    public CompanyInfoListAdapter(String bean) {
        super(bean);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void fillData(int i, final ViewHolder holder, final JSONObject result) {
        //查看
        context = holder.beizhu.getContext();

        //企业名称
        holder.qiyemingcheng.setText("" + result.getString("qymc"));
        //从业人数
        holder.congyerenshu.setText("" + result.getString("cyrs"));
        //培训合格人数
        holder.peixunhegerenshu.setText("" + result.getString("pxhgrs"));
        holder.tijianhegerenshu.setText("" + result.getString("tjhgrs"));
        //获得信息卡人数
        holder.huodexinxikarenshu.setText("" + result.getString("hdxxkrs"));
        //过期提醒(image)
        if (result.getString("gqtx").equals("1")) {
            holder.guoqitixin.setImageResource(R.mipmap.red_point);
        } else {
            holder.guoqitixin.setImageResource(R.mipmap.ic_weiguoqi);
        }
        holder.beizhu.setText("" + result.getString("bz"));
        final String qymc = result.getString("qymc");
        holder.chakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.beizhu.getContext(), QiYeRenYuanActivity.class);
                intent.putExtra("qymc", qymc);
                context.startActivity(intent);
                //ToastUtil.show("123");
            }
        });
        holder.qiyerenyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.beizhu.getContext(), QiYeRenYuanActivity.class);
                intent.putExtra("qymc", qymc);
                context.startActivity(intent);
            }
        });
    }


    @Override
    protected int getItemLayout() {
        return R.layout.sjgr_layout_person_qiye_info_list_itme;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


    static class ViewHolder {
        @BindView(R.id.chakan)
        TextView chakan;
        @BindView(R.id.qiyerenyuan)
        TextView qiyerenyuan;
        @BindView(R.id.qiyemingcheng)
        TextView qiyemingcheng;
        @BindView(R.id.congyerenshu)
        TextView congyerenshu;
        @BindView(R.id.tijianhegerenshu)
        TextView tijianhegerenshu;
        @BindView(R.id.peixunhegerenshu)
        TextView peixunhegerenshu;
        @BindView(R.id.huodexinxikarenshu)
        TextView huodexinxikarenshu;
        @BindView(R.id.guoqitixin)
        ImageView guoqitixin;
        @BindView(R.id.beizhu)
        TextView beizhu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
