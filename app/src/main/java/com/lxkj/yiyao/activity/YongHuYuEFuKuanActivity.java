package com.lxkj.yiyao.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sun on 2017/3/25.
 * 选购课程后支付页面
 */

public class YongHuYuEFuKuanActivity extends BaseActivity {
    @BindView(R.id.gongji_text)
    TextView gongjiText;
    @BindView(R.id.yue_text)
    TextView yueText;
    @BindView(R.id.tijiao_but)
    TextView tijiaoBut;

    @Override
    protected void init() {
        RequestParams requestParams = new RequestParams(GlobalString.BaseURL + GlobalString.yueUrl);
        SharedPreferences sharedPreferences = getSharedPreferences("shiyao", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        requestParams.addBodyParameter("username", username + "");
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (!TextUtils.isEmpty(result)){
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    int code = (int) jsonObject.get("code");
                    if (code == 111111){
                        String data = (String) jsonObject.get("data");
                        if (!TextUtils.isEmpty(data)){
                            JSONObject jsonData = JSONObject.parseObject(data);
                            String ye = (String) jsonData.get("ye");
                            yueText.setText("" + ye);
                        }
                    }else {
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
    }

    @Override
    public int getLayout() {
        return R.layout.xuangou_fukuan;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
