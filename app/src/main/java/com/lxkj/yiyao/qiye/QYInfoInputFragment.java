package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
    @BindView(R.id.adress_tv)
    EditText adressTv;
    @BindView(R.id.commit)
    Button commit;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_qyinfo_input;
    }




    @OnClick(R.id.commit)
    public void onClick() {
        requestDate();

    }



    void  requestDate(){
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.qiye_info);

        params.addBodyParameter("yhm",usernameTv.getText().toString());
        params.addBodyParameter("dwmc",unitnameTv.getText().toString());
        params.addBodyParameter("cyrs",doPersonTv.getText().toString());
        params.addBodyParameter("glrys",managePersonTv.getText().toString());
        params.addBodyParameter("gly",contactNameTv.getText().toString());
        params.addBodyParameter("yx",emailTv.getText().toString());
        params.addBodyParameter("dh",phoneTv.getText().toString());

        int id = 0;
        switch (radiogroup.getCheckedRadioButtonId()){
            case R.id.rg_first :
                id=1;
                break;
            case R.id.rg_second:
                id=2;
                break;
            case R.id.rg_third:
                id=3;
                break;
            case R.id.rg_fourth:
                id=4;
                break;
        }


        params.addBodyParameter("hyly","" + id);
        params.addBodyParameter("dwdz",adressTv.getText().toString());


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
