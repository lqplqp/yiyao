package com.lxkj.yiyao.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.adapter.KaoShiJieGuoZhiFaAdapter;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liqinpeng on 2017/3/25 0025.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class KaoShiJieGuoZhiFaActivity extends BaseActivity {
    @BindView(R.id.chengjiliebiao)
    ListView chengjiliebiao;
    @BindView(R.id.shuaxin_but)
    Button shuaxinBut;
    @BindView(R.id.match_qiyemingcheng)
    TextView matchQiyemingcheng;
    @BindView(R.id.match_diyizhifa)
    TextView matchDiyizhifa;
    @BindView(R.id.diyizhifa)
    EditText diyizhifa;
    @BindView(R.id.match_dierzhifa)
    TextView matchDierzhifa;
    @BindView(R.id.dierzhifa)
    EditText dierzhifa;
    @BindView(R.id.tijiao_but)
    Button tijiaoBut;

    String number;
    String username;
    @BindView(R.id.qiyename)
    TextView qiyename;

    private KaoShiJieGuoZhiFaAdapter adapter;
    String qiyemingcheng;

    @Override
    protected void init() {
        String number = getIntent().getStringExtra("qrcode_result");
        String username = getIntent().getStringExtra("username");

        qiyemingcheng = getIntent().getStringExtra("qiyemingcheng");

        qiyename.setText(qiyemingcheng);
        requestDate();
    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "admin/qita1/khcjlb");
        params.addBodyParameter("kmid", number);
        params.addBodyParameter("username", username);
        params.addBodyParameter("xkzbh", number);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                adapter = new KaoShiJieGuoZhiFaAdapter(result);
                chengjiliebiao.setAdapter(adapter);
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

    @Override
    public int getLayout() {
        return R.layout.kaohecehngji_layout;
    }




    void commitData(){
        RequestParams params = new RequestParams("http://af.0101hr.com/admin/qita1/xzzfjl");
        params.addBodyParameter("xkzbh",number);
        params.addBodyParameter("dyzfr",diyizhifa.getText()+"");
        params.addBodyParameter("dezfr",dierzhifa.getText()+"");
        params.addBodyParameter("qymc",qiyemingcheng);


        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                if("111111".equals(jsonObject.get("code"))){
                    ToastUtil.show(jsonObject.get("message")+"");
                    finish();
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


    @OnClick({R.id.shuaxin_but, R.id.tijiao_but})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shuaxin_but:
                requestDate();
                break;
            case R.id.tijiao_but:
                commitData();
                break;
        }
    }
}
