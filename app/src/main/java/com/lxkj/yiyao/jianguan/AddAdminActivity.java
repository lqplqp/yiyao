package com.lxkj.yiyao.jianguan;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
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
 * Created by Administrator on 2017/3/6 0006.
 */

public class AddAdminActivity extends BaseActivity {


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
    @BindView(R.id.adminname)
    EditText adminname;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.zhiwu)
    EditText zhiwu;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.repassword)
    EditText repassword;
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.title_tv)
    TextView titleTv;

    @Override
    protected void init() {

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + "/admin/fjgl/jgdwgltja");


        params.addBodyParameter("yhm", username.getText().toString());

        params.addBodyParameter("dwmc", companyName.getText().toString());

        params.addBodyParameter("jgjb", jgJibie.getText().toString());

        params.addBodyParameter("dwrs", renshu.getText().toString());

        params.addBodyParameter("mm", password.getText().toString());

        params.addBodyParameter("qrmm", repassword.getText().toString());

        params.addBodyParameter("glyxm", adminname.getText().toString());

        params.addBodyParameter("dh", phone.getText().toString());

        params.addBodyParameter("zw", zhiwu.getText().toString());

        params.addBodyParameter("email", email.getText().toString());

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
        return R.layout.jg_addadmin_fragment;
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
