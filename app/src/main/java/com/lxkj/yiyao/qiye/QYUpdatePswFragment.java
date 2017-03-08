package com.lxkj.yiyao.qiye;

import android.util.Log;
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
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class QYUpdatePswFragment extends BaseFragment {


    private static final String TAG = "QYUpdatePswFragment";
    @BindView(R.id.old_pwd)
    EditText oldPwd;
    @BindView(R.id.new_pwd)
    EditText newPwd;
    @BindView(R.id.new_pwd2)
    EditText newPwd2;
    @BindView(R.id.commit)
    Button commit;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.sjgr_fragment_layout_updatepsw;
    }



    @OnClick(R.id.commit)
    public void onClick() {

        Log.i(TAG,"onclick");

        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_aqsz);
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
}
