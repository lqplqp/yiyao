package com.lxkj.yiyao.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.shengji.contract.RegisterContract;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.RegisterView {
    @BindView(R.id.username)
    EditText username;
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
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;
    @BindView(R.id.user_btn)
    TextView userBtn;
    @BindView(R.id.company_2_btn)
    TextView company2Btn;


    private String TAG = "RegisterActivity";

    @Override
    protected void init() {

    }

    @Override
    public int getLayout() {
        return R.layout.register;
    }

    @Override
    public void toRegister() {

        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.reg1);

        params.addBodyParameter("username", username.getText().toString());
        params.addBodyParameter("password", password.getText().toString());
        params.addBodyParameter("type", radiogroup.getCheckedRadioButtonId() + "");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
                ;
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

    @OnClick(R.id.register)
    public void onClick() {
        toRegister();
    }




    @OnClick({R.id.user_btn, R.id.company_2_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_btn:
                Intent intent = new Intent(this,Register1Activity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.company_2_btn:
                Intent intent2 = new Intent(this,Register2Activity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}
