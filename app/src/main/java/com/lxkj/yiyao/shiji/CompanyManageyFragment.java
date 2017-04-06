package com.lxkj.yiyao.shiji;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.jianguan.adapter.MBaseAdapter;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class CompanyManageyFragment extends BaseFragment {

    public String TAG = this.getClass().getSimpleName();


    // ======================== 模板代码=============================

    MBaseAdapter adapter;
    @BindView(R.id.yonghuming)
    EditText yonghuming;
    @BindView(R.id.danweimingcheng)
    EditText danweimingcheng;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.danweirenshu)
    EditText danweirenshu;
    @BindView(R.id.guanliyuan)
    EditText guanliyuan;
    @BindView(R.id.youxiang)
    EditText youxiang;
    @BindView(R.id.commit)
    Button commit;
    Unbinder unbinder;
    @BindView(R.id.shoujihao)
    EditText shoujihao;
    @BindView(R.id.jianguanduiwu)
    CheckBox jianguanduiwu;
    @BindView(R.id.danweidizhi)
    TextView danweidizhi;
    private int page = 1;
    private String username;


    @Override
    protected void initView() {
        SharedPreferences sp = getActivity().getSharedPreferences("shiyao", 0);
        username = sp.getString("username", "");
        requestData();
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dwmc = danweimingcheng.getText().toString();
                String dwrs = danweirenshu.getText().toString();
                String gly = guanliyuan.getText().toString();
                String yx = youxiang.getText().toString();
                String sjhm = shoujihao.getText().toString();
                String dwdz = danweidizhi.getText().toString();
                RequestParams requestParams = new RequestParams(GlobalString.shiji_jianguandanweixinxi);
                requestParams.addBodyParameter("username", username);
                requestParams.addBodyParameter("dwmc", dwmc);
                requestParams.addBodyParameter("dwrs", dwrs);
                requestParams.addBodyParameter("gly", gly);
                requestParams.addBodyParameter("yx", yx);
                requestParams.addBodyParameter("sjhm", sjhm);
                x.http().post(requestParams, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        ToastUtil.show("操作成功");
                        requestData();
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
        });
    }

    private void requestData() {
        RequestParams requestParams = new RequestParams(GlobalString.shiji_jianguandanweixinxi);
        requestParams.addBodyParameter("username", username);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (!TextUtils.isEmpty(result)) {
                    JSONObject jsonObject = JSONObject.parseObject(JSONObject.parseObject(result).getString("data"));
                    //用户名 username
                    String username1 = jsonObject.getString("username");
                    //单位名称 dwmc
                    String dwmc = jsonObject.getString("dwmc");
                    //单位人数 glrs
                    String glrs = jsonObject.getString("glrs");
                    //管理员 xm
                    String xm = jsonObject.getString("xm");
                    //邮箱 yx
                    String yx = jsonObject.getString("yx");
                    //手机号码 sjhm
                    String sjhm = jsonObject.getString("sjhm");
                    //行业领域 hyly
                    String hyly = jsonObject.getString("hyly");
                    //详细地址szdq  szdq1 szdq2  dwdz
                    String szdq = jsonObject.getString("szdq");
                    //
                    String szdq1 = jsonObject.getString("szdq1");
                    //
                    String szdq2 = jsonObject.getString("szdq2");
                    //
                    String dwdz = jsonObject.getString("dwdz");

                    yonghuming.setText("" + username1);
                    danweimingcheng.setText("" + dwmc);
                    danweirenshu.setText("" + glrs);
                    guanliyuan.setText("" + xm);
                    youxiang.setText("" + yx);
                    shoujihao.setText("" + sjhm);
                    danweidizhi.setText("" + szdq + szdq1 + szdq2 + dwdz);

                }
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
    public int getLayout() {
        return R.layout.jianguandanweiguanli_layout;
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
