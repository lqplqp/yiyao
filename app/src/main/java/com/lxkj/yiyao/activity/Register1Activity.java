package com.lxkj.yiyao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.shengji.contract.RegisterContract;
import com.lxkj.yiyao.utils.PickViewUtils;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class Register1Activity extends BaseActivity implements RegisterContract.RegisterView {


    @BindView(R.id.company_a_btn)
    TextView companyABtn;
    @BindView(R.id.user_btn)
    TextView userBtn;
    @BindView(R.id.company)
    TextView company;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.xingming)
    EditText xingming;
    @BindView(R.id.shenfenzheng)
    EditText shenfenzheng;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.repassword)
    EditText repassword;
    @BindView(R.id.eat)
    RadioButton eat;
    @BindView(R.id.yao)
    RadioButton yao;
    @BindView(R.id.huazhuang)
    RadioButton huazhuang;
    @BindView(R.id.baojian)
    RadioButton baojian;
    @BindView(R.id.yiliao)
    RadioButton yiliao;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.qiyedizhi)
    TextView qiyedizhi;
    private String TAG = "RegisterActivity";

    @Override
    protected void init() {

    }

    @Override
    public int getLayout() {
        return R.layout.register_user;
    }

    @Override
    public void toRegister() {

        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.reg1);

        params.addBodyParameter("username", username.getText().toString());
        params.addBodyParameter("password", password.getText().toString());
        params.addBodyParameter("xm", xingming.getText().toString());
        params.addBodyParameter("qrmm", repassword.getText().toString());
        params.addBodyParameter("sfzh", shenfenzheng.getText().toString());

        if (!TextUtils.isEmpty(qiyedizhi.getText())){
            String[] split = qiyedizhi.getText().toString().split("-");
            params.addBodyParameter("szdq1", split[0] + "");
            params.addBodyParameter("szdq2", split[1] + "");
            params.addBodyParameter("szdq3", split[2] + "");
            params.addBodyParameter("dz", qiyedizhi.getText() + "");
        }

        int a = 0;
        switch (radiogroup.getCheckedRadioButtonId()) {
            case R.id.eat:
                a = 1;
                break;
            case R.id.yao:
                a = 2;
                break;
            case R.id.huazhuang:
                a = 3;
                break;
            case R.id.baojian:
                a = 4;
                break;
            case R.id.yiliao:
                a = 5;
                break;
        }
        params.addBodyParameter("lx", a + "");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject object = JSONObject.parseObject(result);
                int code = Integer.parseInt(object.get("code").toString());
                if (code == 111111) {
                    ToastUtil.show("注册成功");
                    finish();
                } else {
                    ToastUtil.show(object.get("message").toString());
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                cex.printStackTrace();
            }

            @Override
            public void onFinished() {
                Log.i(TAG, "finish");
            }
        });


    }


    @OnClick({R.id.company_a_btn, R.id.register,R.id.qiyedizhi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.company_a_btn:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.register:
                if(TextUtils.isEmpty(username.getText().toString())
                        || TextUtils.isEmpty(xingming.getText().toString())
                        || TextUtils.isEmpty(shenfenzheng.getText().toString())
                        || TextUtils.isEmpty(password.getText().toString())
                        || TextUtils.isEmpty(repassword.getText().toString())
                        || TextUtils.isEmpty(qiyedizhi.getText().toString())){
                    ToastUtil.show("请完善资料");
                }else {
                    toRegister();
                }
                break;
            case R.id.qiyedizhi:
                PickViewUtils viewUtils = new PickViewUtils(Register1Activity.this, qiyedizhi);
                viewUtils.pickProvince();
                break;
        }
    }




}
