package com.lxkj.yiyao.shengjugeren;

import android.os.Bundle;
import android.util.Log;
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

public class SJGRUpdatePswFragment extends BaseFragment {
    public String TAG = this.getClass().getSimpleName();
    @BindView(R.id.yuanmima)
    EditText yuanmima;
    @BindView(R.id.xinmima)
    EditText xinmima;
    @BindView(R.id.chongfumima)
    EditText chongfumima;
    @BindView(R.id.tijiao)
    Button tijiao;
    Unbinder unbinder;

    @Override
    protected void initView() {

    }

    public void requestData(){
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.shiji_anquanshezhi);
        params.addBodyParameter("ymm",yuanmima.getText().toString());
        params.addBodyParameter("xmm",xinmima.getText().toString());
        params.addBodyParameter("qrmm",chongfumima.getText().toString());

        x.http().get(params, new Callback.CacheCallback<String>() {

            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                JSONObject jsonObject = JSONObject.parseObject(result);

                ToastUtil.show(jsonObject.get("data").toString());

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
        return R.layout.sjgr_fragment_layout_updatepsw;
    }


    @OnClick(R.id.tijiao)
    public void onClick() {

        requestData();
    }
}
