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
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/19.
 */

public class JGUpdatePswFragment extends BaseFragment {


    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.yuanmima)
    EditText yuanmima;
    @BindView(R.id.xinmima)
    EditText xinmima;
    @BindView(R.id.chongfumima)
    EditText chongfumima;
    Unbinder unbinder;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.sjgr_fragment_layout_updatepsw;
    }


    @OnClick(R.id.commit)
    public void onClick() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.jg_aqsz);
        params.addBodyParameter("ymm",oldPwd.getText().toString());
        params.addBodyParameter("xmm",newPwd.getText().toString());
        params.addBodyParameter("qrmm",newPwd2.getText().toString());
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                String code = jsonObject.get("code").toString();
                if(code.equals("111111")){

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
