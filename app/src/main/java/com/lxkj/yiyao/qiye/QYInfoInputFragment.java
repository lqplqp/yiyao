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
    @BindView(R.id.xukezhengbianhao)
    EditText xukezhengbianhao;

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


    void getDate() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_info);
        SharedPreferences sp = getActivity().getSharedPreferences("shiyao", getActivity().MODE_PRIVATE);
        params.addBodyParameter("username", SPUtil.getUserName(getContext()));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                JSONObject data = jsonObject.getJSONObject("data");
                if (data.get("yhm") != null)
                    usernameTv.setText("" + data.get("yhm") + "");
                if (data.get("dwmc") != null)
                    unitnameTv.setText("" + data.get("dwmc") + "");
                if (data.get("cyrs") != null)
                    doPersonTv.setText("" + data.get("cyrs") + "");
                if (data.get("glrys") != null)
                    managePersonTv.setText("" + data.get("glrys") + "");
                if (data.get("gly") != null)
                    contactNameTv.setText("" + data.get("gly") + "");
                if (data.get("yx") != null)
                    emailTv.setText("" + data.get("yx") + "");
                if (data.get("dh") != null)
                    phoneTv.setText("" + data.get("dh") + "");

                //danweidizhi.setText("123312123123");
                //danweidizhi.setText("123");
                if(data.get("sfzh") != null){
                    xukezhengbianhao.setText(data.get("sfzh").toString());
                }

                danweidizhi.setText("" + data.get("szdq1").toString() + "-" + data.get("szdq2").toString() + "-" + data.get("szdq3").toString() + "");
                if (data.get("dwdz") != null)
                    danwei.setText("" + data.get("dwdz"));

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
        params.addBodyParameter("username", sp.getString("username", "") + "");
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

        String[] sanji = danweidizhi.getText().toString().split("-");

        if (sanji.length == 3) {
            params.addBodyParameter("szdq1", sanji[0]);
            params.addBodyParameter("szdq2", sanji[1]);
            params.addBodyParameter("szdq3", sanji[2]);
        }
        params.addBodyParameter("sfzh",xukezhengbianhao.getText().toString());

        params.addBodyParameter("dwdz", danwei.getText().toString());

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
