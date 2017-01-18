package com.lxkj.yiyao.jianguan;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class UpdateAdminInfoFragment extends BaseFragment {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.repassword)
    EditText repassword;
    @BindView(R.id.man)
    RadioButton man;
    @BindView(R.id.women)
    RadioButton women;
    @BindView(R.id.idcard)
    EditText idcard;
    @BindView(R.id.company)
    EditText company;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.position)
    EditText position;
    @BindView(R.id.birthday)
    EditText birthday;
    @BindView(R.id.work_type)
    EditText workType;
    @BindView(R.id.xueli)
    EditText xueli;
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.commit)
    TextView commit;
    @BindView(R.id.back)
    TextView back;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_update_man;
    }



    @OnClick({R.id.commit, R.id.back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit:
                break;
            case R.id.back:
                break;
        }
    }
}
