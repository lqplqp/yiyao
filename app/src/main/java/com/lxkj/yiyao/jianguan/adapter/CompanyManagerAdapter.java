package com.lxkj.yiyao.jianguan.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.lxkj.yiyao.MainActivity;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.jianguan.QiYeRenYuanActivity;
import com.lxkj.yiyao.utils.ToastUtil;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class CompanyManagerAdapter extends MBaseAdapter<CompanyManagerAdapter.ViewHolder> {

    private Activity mActivity;

    public CompanyManagerAdapter(String bean , Activity activity) {
        super(bean);
        mActivity = activity;
    }

    protected void fillData(int i, ViewHolder holder , final com.alibaba.fastjson.JSONObject result) {


        if(result.get("qymc")!=null){
            //企业名称
            holder.qiyeName.setText(""+result.get("qymc"));
        }

        if(result.get("tjhgrs")!=null)
        //体检合格人数
            holder.tijianhegePeople.setText(""+result.get("tjhgrs"));
        if(result.get("pxhgrs")!=null)
        //培训合格人数
            holder.peixunhegeRenshu.setText(""+result.get("pxhgrs"));
        if(result.get("hdxxkrs")!=null)
        //获取信息卡人数
            holder.infocardRenshu.setText(""+result.get("hdxxkrs"));
        if(result.get("bz")!=null)
        // TODO: 2017/3/2 0002  true和false
        //备注
         holder.beizhu.setText(""+result.get("bz"));
        holder.chakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, QiYeRenYuanActivity.class);
                intent.putExtra("qymc", result.getString("qymc"));
                mActivity.startActivity(intent);
//                ((MainActivity)mActivity).setIndexFragement(1);
            }
        });

        holder.qiyerenyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, QiYeRenYuanActivity.class);
                intent.putExtra("qymc", result.getString("qymc"));
                mActivity.startActivity(intent);
            }
        });


    }

    @Override
    protected int getItemLayout() {
        return R.layout.qiyeguanli_table_item;
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
        @BindView(R.id.qiye_name)
        TextView qiyeName;
        @BindView(R.id.tijianhege_people)
        TextView tijianhegePeople;
        @BindView(R.id.peixunhege_renshu)
        TextView peixunhegeRenshu;
        @BindView(R.id.infocard_renshu)
        TextView infocardRenshu;
        @BindView(R.id.guoqitixing)
        LinearLayout guoqitixing;
        @BindView(R.id.beizhu)
        TextView beizhu;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
