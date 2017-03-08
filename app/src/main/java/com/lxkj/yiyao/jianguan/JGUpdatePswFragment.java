package com.lxkj.yiyao.jianguan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class JGUpdatePswFragment extends BaseFragment {


    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.old_pwd)
    EditText oldPwd;
    @BindView(R.id.new_pwd)
    EditText newPwd;
    @BindView(R.id.new_pwd2)
    EditText newPwd2;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.jg_updatepwd;
    }


    @OnClick(R.id.commit)
    public void onClick() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.jg_aqsz);
        params.addBodyParameter("ymm", oldPwd.getText().toString());
        params.addBodyParameter("xmm", newPwd.getText().toString());
        params.addBodyParameter("qrmm", newPwd2.getText().toString());
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                String code = jsonObject.get("code").toString();
                if (code.equals("111111")) {

                }
                ToastUtil.show(jsonObject.get("message").toString() + "");
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



}
