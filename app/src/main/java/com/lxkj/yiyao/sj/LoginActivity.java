package com.lxkj.yiyao.sj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lxkj.yiyao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class LoginActivity extends BaseActivity implements LoginConstract.LoginView {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.checkcode)
    EditText checkcode;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.register)
    Button register;
    @BindView(R.id.login)
    Button login;

    @Override
    public int getLayout() {
        return R.layout.login;
    }


    @OnClick({R.id.register, R.id.login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                onClickRegister();
                break;
            case R.id.login:
                onClickLogin();
                break;
        }
    }

    private void onClickLogin() {
        toast("登录");
    }

    private void onClickRegister() {
        toast("注册");
    }

    @Override
    public void toLogin() {

    }

    @Override
    public void toRegister() {

    }

    @Override
    public void showCheckCode(String imageUrl){
        Glide.with(mActivity).load(imageUrl).into(image);
    }
}
