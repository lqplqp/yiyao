package com.lxkj.yiyao.shengji.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/3.
 */

public class ShenHeAapter extends MBaseAdapter<ShenHeAapter.ViewHolder> {
    public ShenHeAapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, final ViewHolder holder, JSONObject result) {
        //登录用户名
        holder.dengluyonghuming.setText(""+result.get("dlyhm"));
        //法人
        holder.faren.setText(""+result.get("fr"));
        //服务对象
        holder.fuwuduixiang.setText(""+result.get("fwdx"));
        //联系电话
        holder.lianxidianhua.setText(""+result.get("lxdh"));
        //审核状态
        holder.shenhezhuangtai.setText(""+result.get("shzt"));
        //体检机构地址
        holder.tijianjigoudizhi.setText(""+result.get("tjjgdz"));
        //体检机构名称
        holder.tijianjigoumingcheng.setText(""+result.get("tjglmc"));
        //序号
        holder.xuhao.setText(""+result.get("id"));


        if(holder.shenhezhuangtai.getText().toString().equals("未审核")){
            holder.shenhezhuangtai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/fenji1/sh");
                    params.addBodyParameter("id",""+holder.xuhao.getText());
                    x.http().get(params, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String result) {
                            JSONObject jsonObject = JSONObject.parseObject(result);
                            Object message = jsonObject.get("message");
                            if(message!=null){
                                ToastUtil.show(message.toString());
                                holder.shenhezhuangtai.setText("审核通过");
                            }
                        }

                        @Override
                        public void onError(Throwable ex, boolean isOnCallback) {
                            ex.printStackTrace();
                        }

                        @Override
                        public void onCancelled(CancelledException cex) {

                        }

                        @Override
                        public void onFinished() {

                        }
                    });
                }
            });
        }

    }

    @Override
    protected int getItemLayout() {
        return R.layout.sj_shenhe_item;
    }


    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }

    static class ViewHolder {
        @BindView(R.id.xuhao)
        TextView xuhao;
        @BindView(R.id.dengluyonghuming)
        TextView dengluyonghuming;
        @BindView(R.id.tijianjigoumingcheng)
        TextView tijianjigoumingcheng;
        @BindView(R.id.tijianjigoudizhi)
        TextView tijianjigoudizhi;
        @BindView(R.id.fuwuduixiang)
        TextView fuwuduixiang;
        @BindView(R.id.faren)
        TextView faren;
        @BindView(R.id.lianxidianhua)
        TextView lianxidianhua;
        @BindView(R.id.shenhezhuangtai)
        TextView shenhezhuangtai;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
