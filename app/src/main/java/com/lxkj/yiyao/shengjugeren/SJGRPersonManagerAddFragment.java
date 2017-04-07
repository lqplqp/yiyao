package com.lxkj.yiyao.shengjugeren;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.PickViewUtils;
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

public class SJGRPersonManagerAddFragment extends BaseFragment {
    public String TAG = this.getClass().getSimpleName();
    @BindView(R.id.yonghuming)
    EditText yonghuming;
    @BindView(R.id.xingming)
    EditText xingming;
    @BindView(R.id.nan)
    RadioButton nan;
    @BindView(R.id.nu)
    RadioButton nu;
    @BindView(R.id.shenfenzhenghao)
    EditText shenfenzhenghao;
    @BindView(R.id.danweimingcheng)
    EditText danweimingcheng;
    @BindView(R.id.youxiang)
    EditText youxiang;
    @BindView(R.id.shoujihaoma)
    EditText shoujihaoma;
    @BindView(R.id.zhiwei)
    EditText zhiwei;
    @BindView(R.id.chushengriqi)
    EditText chushengriqi;
    @BindView(R.id.xueli)
    TextView xueli;
    @BindView(R.id.danweidizhi)
    TextView danweidizhi;
    @BindView(R.id.commit)
    Button commit;
    Unbinder unbinder2;
    Unbinder unbinder;
    @BindView(R.id.gongzhong)
    EditText gongzhong;
    @BindView(R.id.danwei)
    EditText danwei;

    @Override
    protected void initView() {
        requestData();

    }

    @Override
    public int getLayout() {
        return R.layout.sjgr_fragment_layout_person_manage_add;
    }

    public void requestData() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.sjgr_jgryxx);
        SharedPreferences sp = getActivity().getSharedPreferences("shiyao", getActivity().MODE_PRIVATE);
        params.addBodyParameter("username",sp.getString("username","") + "");
        params.addBodyParameter("zh", yonghuming.getText().toString());
        params.addBodyParameter("xm", xingming.getText().toString());
        if (nan.isClickable()) {
            params.addBodyParameter("xb", "男");
        }
        if (nu.isClickable()) {
            params.addBodyParameter("xb", "女");
        }
        params.addBodyParameter("sfzh", shenfenzhenghao.getText().toString());
        params.addBodyParameter("jgdwmc", danweimingcheng.getText().toString());
        params.addBodyParameter("yx", youxiang.getText().toString());
        params.addBodyParameter("sjhm", shoujihaoma.getText().toString());
        params.addBodyParameter("zw", zhiwei.getText().toString());
        params.addBodyParameter("csrq", chushengriqi.getText().toString());
        params.addBodyParameter("gw", gongzhong.getText().toString());
        params.addBodyParameter("xl", xueli.getText().toString());

        String [] sanji = danweidizhi.getText().toString().split("-");

        params.addBodyParameter("szdq", sanji[0]);
        params.addBodyParameter("szdq1", sanji[1]);
        params.addBodyParameter("szdq2", sanji[2]);
        params.addBodyParameter("dz", danwei.getText().toString());

        x.http().get(params, new Callback.CacheCallback<String>() {

            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
                JSONObject jsonObject = JSONObject.parseObject(result);
                ToastUtil.show(result);
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

    @OnClick({R.id.danweidizhi, R.id.commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.danweidizhi:
                new PickViewUtils(getActivity(), danweidizhi).pickProvince();
                break;
            case R.id.commit:
                ToastUtil.show("OK");
                requestData();
                break;
        }
    }

}
