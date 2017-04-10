package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.view.View;
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
import com.lxkj.yiyao.utils.SPUtil;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/6 0006.
 */

public class ZengJiaRenYuanActivity extends BaseActivity {


    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.xingming)
    EditText xingming;
    @BindView(R.id.nan)
    RadioButton nan;
    @BindView(R.id.nv)
    RadioButton nv;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.tijianxinxibianhao)
    EditText tijianxinxibianhao;
    @BindView(R.id.tijianxinxiyouxiaoqi)
    TextView tijianxinxiyouxiaoqi;
    @BindView(R.id.peixunzhenghao)
    EditText peixunzhenghao;
    @BindView(R.id.peixunzhengyouxiaoqi)
    TextView peixunzhengyouxiaoqi;
    @BindView(R.id.chushengriqi)
    TextView chushengriqi;
    @BindView(R.id.xiaoxitixing)
    EditText xiaoxitixing;
    @BindView(R.id.youxiang)
    EditText youxiang;
    @BindView(R.id.shoujihaoma)
    EditText shoujihaoma;
    @BindView(R.id.shenfenzhenghao)
    EditText shenfenzhenghao;
    @BindView(R.id.zhiwu)
    Spinner zhiwu;
    @BindView(R.id.gangwei)
    Spinner gangwei;
    @BindView(R.id.xueli)
    Spinner xueli;
    @BindView(R.id.xiangxidizhi)
    TextView xiangxidizhi;
    @BindView(R.id.register)
    TextView register;
    private String userName;

    @Override
    protected void init() {
        userName = SPUtil.getUserName(this);
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/qita1/qyryxz");
        params.addBodyParameter("username", userName);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject object = JSONObject.parseObject(result);
                String code = object.get("code").toString();
                if (code.equals("111111")) {

                    finish();
                }
                ToastUtil.show(object.get("message").toString());
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
        return R.layout.qiye_zengjiarenyuan_layout;
    }


    @OnClick(R.id.register)
    public void onClick() {
        requestDate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
