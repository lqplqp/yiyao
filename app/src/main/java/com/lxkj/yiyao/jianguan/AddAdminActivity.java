package com.lxkj.yiyao.jianguan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.PickViewUtils;
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
 * Created by Administrator on 2017/3/6 0006.
 */

public class AddAdminActivity extends BaseActivity {


    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.company_name)
    EditText companyName;
    @BindView(R.id.jg_jibie)
    EditText jgJibie;
    @BindView(R.id.renshu)
    EditText renshu;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.repassword)
    EditText repassword;
    @BindView(R.id.adminname)
    EditText adminname;
    @BindView(R.id.nan)
    RadioButton nan;
    @BindView(R.id.nv)
    RadioButton nv;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.xueli)
    Spinner xueli;
    @BindView(R.id.shenfenzhenghao)
    EditText shenfenzhenghao;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.gangwei)
    Spinner gangwei;
    @BindView(R.id.danweidizhi)
    TextView danweidizhi;
    @BindView(R.id.dizhi)
    EditText dizhi;
    @BindView(R.id.zhiwu)
    EditText zhiwu;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.jianguanhangye)
    RadioButton jianguanhangye;
    private String gangweiType;
    private String xueliType;
    private ArrayAdapter<String> mSpinnerAdapter;
    @Override
    protected void init() {
        initSpinner1();
        initSpinner2();
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/qita1/lawenforcer");
        SharedPreferences sp = this.getSharedPreferences("shiyao", this.MODE_PRIVATE);
        params.addBodyParameter("username",sp.getString("username","") + "");

        params.addBodyParameter("yhm", username.getText().toString());
        /*params.addBodyParameter("company", companyName.getText().toString());*/
        /*params.addBodyParameter("level",jgJibie.getText().toString());
        params.addBodyParameter("people", renshu.getText().toString());*/
        params.addBodyParameter("mm", password.getText().toString());
        params.addBodyParameter("qrmm",repassword.getText().toString());
        params.addBodyParameter("xm",adminname.getText().toString());

        if(nan.isClickable()) {
            params.addBodyParameter("xb", "男");
        }
        if(nv.isClickable()) {
            params.addBodyParameter("xb", "女");
        }

        params.addBodyParameter("xl", xueliType);
        params.addBodyParameter("sfzh", shenfenzhenghao.getText().toString());
        params.addBodyParameter("sjhm", phone.getText().toString());
        params.addBodyParameter("gw", gangweiType);
        params.addBodyParameter("zw", zhiwu.getText().toString());
        params.addBodyParameter("yx", email.getText().toString());

        /*if(jianguanhangye.isClickable()){
            params.addBodyParameter("trade", "监管队伍");
        }*/

        String [] sanji = danweidizhi.getText().toString().split("-");

        params.addBodyParameter("szdq", sanji[0]);
        params.addBodyParameter("szdq1", sanji[1]);
        params.addBodyParameter("szdq2", sanji[2]);
        params.addBodyParameter("dz", dizhi.getText().toString());

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject object = JSONObject.parseObject(result);
                String code = object.get("code").toString();
                if (code.equals("111111")) {

                    finish();
                }
                ToastUtil.show(object.get("msg").toString());
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
        return R.layout.jg_addadmin_fragment;
    }


    @OnClick({R.id.register, R.id.danweidizhi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                requestDate();
                break;
            case R.id.danweidizhi:
                new PickViewUtils(this, danweidizhi).pickProvince();
                break;
        }
    }
    private void initSpinner1() {
        final List<String> selects = new ArrayList<String>();
        /*selects.add("生产岗位");
        selects.add("设计岗位");
        selects.add("售后岗位");*/
        selects.add("销售岗位");
        selects.add("管理岗位");
        selects.add("后勤岗位");
        selects.add("人事岗位");
        selects.add("其他岗位");

        mSpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, selects);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        gangwei.setAdapter(mSpinnerAdapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        gangwei.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                gangweiType = selects.get((int)arg3);
                /* 将mySpinner 显示*/
                //arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //arg0.setVisibility(View.VISIBLE);
                ToastUtil.show("12332");
            }
        });

    }
    private void initSpinner2() {
        final List<String> selects = new ArrayList<String>();
        /*selects.add("小学");
        selects.add("初中");
        selects.add("中专");
        selects.add("高中");*/
        selects.add("大专");
        selects.add("本科");
        selects.add("硕士 ");
        selects.add("博士");

        mSpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, selects);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        xueli.setAdapter(mSpinnerAdapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        xueli.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                xueliType = selects.get((int)arg3);
                /* 将mySpinner 显示*/
                //arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //arg0.setVisibility(View.VISIBLE);
                ToastUtil.show("12332");
            }
        });

    }
}
