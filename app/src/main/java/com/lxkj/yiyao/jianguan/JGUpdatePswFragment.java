package com.lxkj.yiyao.jianguan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class JGUpdatePswFragment extends BaseFragment {


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

    }
}
