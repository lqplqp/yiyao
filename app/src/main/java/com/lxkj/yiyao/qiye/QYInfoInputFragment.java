package com.lxkj.yiyao.qiye;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.PickViewUtils;
import com.lxkj.yiyao.utils.SPUtil;
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

public class QYInfoInputFragment extends BaseFragment {


    @BindView(R.id.username_tv)
    EditText usernameTv;
    @BindView(R.id.unitname_tv)
    EditText unitnameTv;
    @BindView(R.id.do_person_tv)
    EditText doPersonTv;
    @BindView(R.id.manage_person_tv)
    EditText managePersonTv;
    @BindView(R.id.contact_name_tv)
    EditText contactNameTv;
    @BindView(R.id.email_tv)
    EditText emailTv;
    @BindView(R.id.phone_tv)
    EditText phoneTv;
    @BindView(R.id.rg_first)
    RadioButton rgFirst;
    @BindView(R.id.rg_second)
    RadioButton rgSecond;
    @BindView(R.id.rg_third)
    RadioButton rgThird;
    @BindView(R.id.rg_fourth)
    RadioButton rgFourth;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;
    @BindView(R.id.commit)
    Button commit;
    @BindView(R.id.danweidizhi)
    TextView danweidizhi;
    @BindView(R.id.danwei)
    EditText danwei;
    Unbinder unbinder;

    @Override
    protected void initView() {
        getDate();
    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_qyinfo_input;
    }


    @OnClick({R.id.danweidizhi, R.id.commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.danweidizhi:
                new PickViewUtils(getActivity(), danweidizhi).pickProvince();
                break;
            case R.id.commit:
                //ToastUtil.show("OK");
                requestDate();
                break;
        }
    }


    void getDate(){
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_info);
        SharedPreferences sp = getActivity().getSharedPreferences("shiyao", getActivity().MODE_PRIVATE);
        params.addBodyParameter("username", SPUtil.getUserName(getContext()));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                JSONObject data = jsonObject.getJSONObject("data");
                usernameTv.setText(data.get("username").toString());
                unitnameTv.setText(data.get("dwdz").toString());
                doPersonTv.setText(data.get("cyrs").toString());
                managePersonTv.setText(data.get("glrys").toString());
                contactNameTv.setText(data.get("gly").toString());
                emailTv.setText(data.get("yx").toString());

                phoneTv.setText(data.get("dh").toString());


                danweidizhi.setText(data.get("dwdz").toString());
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


    void requestDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_info);
        SharedPreferences sp = getActivity().getSharedPreferences("shiyao", getActivity().MODE_PRIVATE);
        params.addBodyParameter("username",sp.getString("username","") + "");
        params.addBodyParameter("username", usernameTv.getText().toString());
        params.addBodyParameter("dwmc", unitnameTv.getText().toString());
        params.addBodyParameter("cyrs", doPersonTv.getText().toString());
        params.addBodyParameter("glrys", managePersonTv.getText().toString());
        params.addBodyParameter("gly", contactNameTv.getText().toString());
        params.addBodyParameter("yx", emailTv.getText().toString());
        params.addBodyParameter("dh", phoneTv.getText().toString());

        int id = 0;
        switch (radiogroup.getCheckedRadioButtonId()) {
            case R.id.rg_first:
                id = 1;
                break;
            case R.id.rg_second:
                id = 2;
                break;
            case R.id.rg_third:
                id = 3;
                break;
            case R.id.rg_fourth:
                id = 4;
                break;
        }


        params.addBodyParameter("hyly", "" + id);

        String [] sanji = danweidizhi.getText().toString().split("-");

        params.addBodyParameter("szdq", sanji[0]);
        params.addBodyParameter("szdq1", sanji[1]);
        params.addBodyParameter("szdq2", sanji[2]);
        params.addBodyParameter("dz", danwei.getText().toString());

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                String code = jsonObject.get("code").toString();
                ToastUtil.show(jsonObject.get("message").toString());
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
