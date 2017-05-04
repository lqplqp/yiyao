package com.lxkj.yiyao.qiye.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.AliPayHelper.Alipay;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.XuanGouKeChengRenYuanActivity;
import com.lxkj.yiyao.activity.YongHuYuEFuKuanActivity;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/3 0003.
 */

public class QYTrainOrderAdapter extends MBaseAdapter<QYTrainOrderAdapter.ViewHolder> {

    public Context mContext;

    public QYTrainOrderAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, ViewHolder holder, final JSONObject result) {

        mContext = holder.fukuan.getContext();
        //培训项目信息
        holder.peixunxiangmuxinxi.setText("" + result.get("title"));
        //培训费用
        holder.peixunfeiyong.setText("" + result.get("content"));
        //资料费用
        holder.ziliaofeiyong.setText("" + result.get("username"));
        //学员人数
        holder.xueyuanrenshu.setText("" + result.get("oid"));
        //已付款
        holder.yifukuan.setText("" + result.get("num"));
        //应付款
        holder.yingfukuan.setText("" + result.get("price"));


        if(result.get("status").toString().equals("1")){
            //待支付
            holder.jiaoyizhuangtai.setText("待支付");
        }else if(result.get("status").toString().equals("2")){
            //支付成功
            holder.jiaoyizhuangtai.setText("支付成功");
            holder.fukuan.setText("已付款");
            holder.fukuan.setClickable(false);

        }else if(result.get("status").toString().equals("3")){
            //支付失败
            holder.jiaoyizhuangtai.setText("支付失败");
        }
        //交易状态

        holder.fukuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String data = JSONObject.parseObject(result).getString("data");
                Intent intent = new Intent(mContext, YongHuYuEFuKuanActivity.class);
                intent.putExtra("data", result.toString());
                mContext.startActivity(intent);
            }
        });


        //查看
        /*holder.chakan.setText("" + result.get("chakan"));
        //付款
        holder.fukuan.setText("" + result.get("fukuan"));
        //取消
        holder.quxiao.setText("" + result.get("quxiao"));*/

    }

    @Override
    protected int getItemLayout() {
        return R.layout.qytrainorder_item;
    }

    @Override
    protected ViewHolder getHolder(View view) {
        return new ViewHolder(view);
    }


   void requestData(String oidNum){
       RequestParams requestParams = new RequestParams(GlobalString.xuangou_zhifubao);
       requestParams.addBodyParameter("oid", oidNum);
       x.http().post(requestParams, new Callback.CommonCallback<String>() {
           @Override
           public void onSuccess(String result) {
               if (!TextUtils.isEmpty(result)) {
                   String status = JSONObject.parseObject(result).getString("status");
                   if (TextUtils.equals("ok", status)) {
                       String payUrl = JSONObject.parseObject(result).getString("data");
                       doAlipay(payUrl);
                   }
               }
           }

           @Override
           public void onError(Throwable ex, boolean isOnCallback) {

           }

           @Override
           public void onCancelled(CancelledException cex) {

           }

           @Override
           public void onFinished() {

           }
       });
   }


    /**
     * 支付宝支付
     *
     * @param orderInfo 支付服务生成的支付参数
     */
    private void doAlipay(String orderInfo) {

        // pay_param=pay_param.replace("alipay.trade.wap.pay","alipay.trade.app.pay");
        //pay_param="https://openapi.alipay.com/gateway.do?"+pay_param;
        //   Log.e("FairyDebug","-----------支付调取----------"+orderInfo);
        // Toast.makeText(myWebViewActivity.this,""+pay_param,Toast.LENGTH_LONG).show();
        final String product_oid = getOidMethod(orderInfo);
        new Alipay(mContext, orderInfo, new Alipay.AlipayResultCallBack() {
            @Override
            public void onSuccess() {
                Toast.makeText(mContext, "支付成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDealing() {
                Toast.makeText(mContext, "支付处理中...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(int error_code) {
                switch (error_code) {
                    case Alipay.ERROR_RESULT:
                        Toast.makeText(mContext, "支付失败:支付结果解析错误", Toast.LENGTH_SHORT).show();
                        break;

                    case Alipay.ERROR_NETWORK:
                        Toast.makeText(mContext, "支付失败:网络连接错误", Toast.LENGTH_SHORT).show();
                        break;

                    case Alipay.ERROR_PAY:
                        Toast.makeText(mContext, "支付错误:支付码支付失败", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        Toast.makeText(mContext, "支付错误", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onCancel() {
                Toast.makeText(mContext, "支付取消", Toast.LENGTH_SHORT).show();
            }
        }).doPay();
    }

    //获取订单Oid
    private String getOidMethod(String orderInfo) {
        return orderInfo.substring(orderInfo.indexOf("out_trade_no%22") + 21, orderInfo.indexOf("%22timeout_express") - 6);
    }


    static class ViewHolder {
        @BindView(R.id.peixunxiangmuxinxi)
        TextView peixunxiangmuxinxi;
        @BindView(R.id.peixunfeiyong)
        TextView peixunfeiyong;
        @BindView(R.id.ziliaofeiyong)
        TextView ziliaofeiyong;
        @BindView(R.id.xueyuanrenshu)
        TextView xueyuanrenshu;
        @BindView(R.id.yingfukuan)
        TextView yingfukuan;
        @BindView(R.id.yifukuan)
        TextView yifukuan;
        @BindView(R.id.jiaoyizhuangtai)
        TextView jiaoyizhuangtai;
        @BindView(R.id.chakan)
        TextView chakan;
        @BindView(R.id.fukuan)
        TextView fukuan;
        @BindView(R.id.quxiao)
        TextView quxiao;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
