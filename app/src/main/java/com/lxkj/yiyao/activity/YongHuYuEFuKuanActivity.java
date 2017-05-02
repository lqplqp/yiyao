package com.lxkj.yiyao.activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.AliPayHelper.Alipay;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sun on 2017/3/25.
 * 选购课程后支付页面
 */

public class YongHuYuEFuKuanActivity extends BaseActivity {
    @BindView(R.id.gongji_text)
    TextView gongjiText;
    @BindView(R.id.tijiao_but)
    TextView tijiaoBut;
    @BindView(R.id.yue_radio)
    RadioButton yueRadio;
    @BindView(R.id.zhifubao_radio)
    RadioButton zhifubaoRadio;
    @BindView(R.id.dinganxinxi_text)
    TextView dinganxinxiText;
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.top)
    RelativeLayout top;
    @BindView(R.id.dingdanneirong)
    TextView dingdanneirong;
    @BindView(R.id.zhifuren)
    TextView zhifuren;
    @BindView(R.id.dingdanhao)
    TextView dingdanhao;
    @BindView(R.id.renci)
    TextView renci;

    private String tempPayUrl = "app_id=2016072201651366&biz_content=%7B%22subject%22%3A%22%5Cu652f%5Cu4ed8%5Cu8d2d%5Cu4e70%5Cu5546%5Cu54c1%5Cu8d39%5Cu7528%22%2C%22out_trade_no%22%3A%2210268%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%229.90%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=utf-8&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fwww.hnljxm.com%2Findex.php%2FWebApp%2FPayments%2Falipay_notifyurl.html&sign_type=RSA&timestamp=2017-04-26+14%3A04%3A03&version=1.0&sign=bSgklvdoQnKE80GfZPWHm%2B7L%2BDd2AgYloUVe2jLSojdLbd%2BGwnHpnyc8e2BBcp7%2FyRUKPtwYqilsiebkS6D%2FNehYKE%2BCZux%2F5n7o4i5GpgoxfvQ5484z5auxdKoDJyVnBI3O%2Bdu%2Fv5lVDuppXCoe1xppOtRsac80H9phvd9ulcI%3D";
    private String oidData;
    private String oidNum;
    private String oidPrice;
    private ProgressDialog progressDialog;
    private String oidTitle;

    @Override
    protected void init() {
        progressDialog = new ProgressDialog(YongHuYuEFuKuanActivity.this);
        progressDialog.setMessage("正在加载...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        oidData = getIntent().getStringExtra("data") + "";
        oidNum = JSONObject.parseObject(oidData).getString("oid");
        oidPrice = JSONObject.parseObject(oidData).getString("price");
        oidTitle = JSONObject.parseObject(oidData).getString("title");
        JSONObject result = JSONObject.parseObject(oidData);

        if(result.get("content") != null)
            dingdanneirong.setText(result.get("content").toString());
        if(result.get("username") != null)
            zhifuren.setText(result.get("username").toString());
        if(result.get("oid") != null)
            dingdanhao.setText(oidNum);
        if(result.get("num") != null)
            renci.setText(result.get("num").toString());
        if(result.get("price") != null)
            gongjiText.setText(result.get("price").toString() + " 元");
        if(result.get("title") != null)
            dinganxinxiText.setText(result.get("title").toString() + "");
        RequestParams requestParams = new RequestParams(GlobalString.BaseURL + GlobalString.yueUrl);
        SharedPreferences sharedPreferences = getSharedPreferences("shiyao", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        requestParams.addBodyParameter("username", username + "");
        progressDialog.dismiss();
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (!TextUtils.isEmpty(result)) {
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    int code = (int) jsonObject.get("code");
                    if (code == 111111) {
                        String data = (String) jsonObject.get("data");
                        if (!TextUtils.isEmpty(data)) {
                            JSONObject jsonData = JSONObject.parseObject(data);
                            String ye = (String) jsonData.get("ye");
                            yueRadio.setText(ye + " 元");

                        }
                    } else {
                        //请求失败
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

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tijiaoBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                if (yueRadio.isChecked()) {
                    progressDialog.dismiss();
                } else {
                    RequestParams requestParams = new RequestParams(GlobalString.xuangou_zhifubao);
                    requestParams.addBodyParameter("oid", oidNum);
                    x.http().post(requestParams, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String result) {
                            if (!TextUtils.isEmpty(result)) {
                                String status = JSONObject.parseObject(result).getString("status");
                                if (TextUtils.equals("ok", status)) {
                                    String payUrl = JSONObject.parseObject(result).getString("data");
                                    progressDialog.dismiss();
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
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.xuangou_fukuan;
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
        new Alipay(YongHuYuEFuKuanActivity.this, orderInfo, new Alipay.AlipayResultCallBack() {
            @Override
            public void onSuccess() {
                Toast.makeText(YongHuYuEFuKuanActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onDealing() {
                Toast.makeText(YongHuYuEFuKuanActivity.this, "支付处理中...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(int error_code) {
                switch (error_code) {
                    case Alipay.ERROR_RESULT:
                        Toast.makeText(YongHuYuEFuKuanActivity.this, "支付失败:支付结果解析错误", Toast.LENGTH_SHORT).show();
                        break;

                    case Alipay.ERROR_NETWORK:
                        Toast.makeText(YongHuYuEFuKuanActivity.this, "支付失败:网络连接错误", Toast.LENGTH_SHORT).show();
                        break;

                    case Alipay.ERROR_PAY:
                        Toast.makeText(YongHuYuEFuKuanActivity.this, "支付错误:支付码支付失败", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        Toast.makeText(YongHuYuEFuKuanActivity.this, "支付错误", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onCancel() {
                Toast.makeText(YongHuYuEFuKuanActivity.this, "支付取消", Toast.LENGTH_SHORT).show();
            }
        }).doPay();
    }

    //获取订单Oid
    private String getOidMethod(String orderInfo) {
        return orderInfo.substring(orderInfo.indexOf("out_trade_no%22") + 21, orderInfo.indexOf("%22timeout_express") - 6);
    }


}
