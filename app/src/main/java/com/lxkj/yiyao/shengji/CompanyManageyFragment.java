package com.lxkj.yiyao.shengji;

import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.lxkj.yiyao.shengji.adapter.CompanyManagerAdapter;
import com.lxkj.yiyao.utils.PickViewUtils;
import com.lxkj.yiyao.utils.SPUtil;
import com.lxkj.yiyao.utils.ToastUtil;

import org.w3c.dom.Text;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class CompanyManageyFragment extends BaseFragment {

// ======================== 模板代码=============================

    CompanyManagerAdapter adapter;
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
    @BindView(R.id.shoujihaoma)
    EditText shoujihao;
    @BindView(R.id.jianguanduiwu)
    CheckBox jianguanduiwu;
    @BindView(R.id.danweidizhi)
    TextView danweidizhi;
    @BindView(R.id.danwei)
    EditText danwei;

    @BindView(R.id.commit)
    Button commit;


    private int page = 1;

    private String TAG = "CompanyManageyFragment";


    // ======================== 模板代码=============================


    @Override
    protected void initView() {
        //requestData();
        requestUserInfo();
    }

    private void requestUserInfo() {
        try {
            RequestParams params = new RequestParams("http://af.0101hr.com/admin/fenji1/jgdwxx");

        /*单位名称 dwmc
        单位人数 dwrs
        管理员 gly
        邮箱 yx
        手机号码 sjhm
        行业领域 hyly
        详细地址 szdq  szdq1 szdq2  dwdz*/
            SharedPreferences sp = getActivity().getSharedPreferences("shiyao", getActivity().MODE_PRIVATE);
            params.addBodyParameter("username", SPUtil.getUserName(getContext()));

            //params.addBodyParameter("dwdz", "");

            x.http().get(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {

                    JSONObject jsonObject = JSONObject.parseObject(result);
                    JSONObject data = jsonObject.getJSONObject("data");
                    yonghuming.setText(""+data.get("username"));
                    danweimingcheng.setText(""+data.get("dwmc"));
                    danweirenshu.setText(""+data.get("glrs"));
                    guanliyuan.setText(""+data.get("xm"));
                    youxiang.setText(""+data.get("yx"));
                    shoujihao.setText(""+data.get("sjhm"));
                    danweidizhi.setText(data.get("szdq") +"-" + data.get("szdq1") +"-"+data.get("szdq2"));

                    danwei.setText(data.get("dwdz")+"");


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
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    private void requestData() {
        try {
            RequestParams params = new RequestParams("http://af.0101hr.com/admin/fenji1/jgdwxx");

        /*单位名称 dwmc
        单位人数 dwrs
        管理员 gly
        邮箱 yx
        手机号码 sjhm
        行业领域 hyly
        详细地址 szdq  szdq1 szdq2  dwdz*/
            SharedPreferences sp = getActivity().getSharedPreferences("shiyao", getActivity().MODE_PRIVATE);
            params.addBodyParameter("username",sp.getString("username","") + "");
            params.addBodyParameter("dwmc", danweimingcheng.getText().toString() + "");
            params.addBodyParameter("dwrs", danweirenshu.getText().toString() + "");
            params.addBodyParameter("gly", guanliyuan.getText().toString() + "");
            params.addBodyParameter("yx", youxiang.getText().toString() + "");
            params.addBodyParameter("sjhm", shoujihao.getText().toString() + "");
            boolean selected = jianguanduiwu.isSelected();
            if (!selected) {
                params.addBodyParameter("dwhylymc", jianguanduiwu.getText().toString() + "");
            }
            String[] split = danweidizhi.getText().toString().split("-");
            params.addBodyParameter("szdq", split[0]);
            params.addBodyParameter("szdq1", split[1]);
            params.addBodyParameter("szdq2", split[2]);
            params.addBodyParameter("dz", danwei.getText().toString());

            x.http().get(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    //String s = result;
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    ToastUtil.show(jsonObject.get("message") + "");
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
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    @Override
    public int getLayout() {
        return R.layout.jianguandanweiguanli_layout;
    }




    @OnClick({R.id.danweidizhi, R.id.commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.danweidizhi:
                new PickViewUtils(getActivity(), danweidizhi).pickProvince();
                break;
            case R.id.commit:
                requestData();
                break;
        }
    }
}
