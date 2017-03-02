package com.lxkj.yiyao.shengji;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lxkj.yiyao.MainActivity;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.bean.LoginBean;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.shengji.contract.LoginContract;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class LoginActivity extends BaseActivity  {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.register)
    Button register;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.spinner)
    Spinner spinner;


    private String TAG = "LoginActivity";

    //用户权限
    private int userType;

    //下拉框输入适配器
    private ArrayAdapter<String> adapter;

    //下拉框信息
    private List<String> selects = new ArrayList<String>();

    @Override
    protected void init() {
        initSpinner();

    }

    private void initSpinner() {

        selects.add("增加监管单位");
        selects.add("省局管理员");
        selects.add("省局个人");
        selects.add("市级管理员");
        selects.add("企业管理员");
        selects.add("县区级管理员");

        adapter = new ArrayAdapter<String>(this,R.layout.spinner_item,selects);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        spinner.setAdapter(adapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                userType = (int) arg3;
                /* 将mySpinner 显示*/
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });

    }



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


        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.login);
        params.addBodyParameter("username",username.getText().toString());
        params.addBodyParameter("password",password.getText().toString());
        params.addBodyParameter("access",userType + "");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson(result, LoginBean.class);
                if(loginBean.code == 111111){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("userType",userType);
                    intent.putExtra("user_name",loginBean.user_name);
                    intent.putExtra("user_dep",loginBean.user_dep);
                    intent.putExtra("user_img",loginBean.user_img);
                    startActivity(intent);
                    finish();
                }else{
                    ToastUtil.show(loginBean.message);
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
                Log.i(TAG,"finished");
            }
        });


    }

    private void onClickRegister() {
        toast("注册");
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }






}
