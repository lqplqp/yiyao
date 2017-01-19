package com.lxkj.yiyao.shengji;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.shengji.contract.RegisterContract;

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
    @BindView(R.id.checkcode)
    EditText checkcode;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.register)
    TextView register;

    @Override
    protected void init() {

    }

    @Override
    public int getLayout() {
        return R.layout.register;
    }
    @Override
    public void toRegister(){
        toast("注册");
    }

    @OnClick(R.id.register)
    public void onClick() {
        toRegister();
    }
}
