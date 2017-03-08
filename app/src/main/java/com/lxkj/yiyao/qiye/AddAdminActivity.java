package com.lxkj.yiyao.qiye;

import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/6 0006.
 */

public class AddAdminActivity extends BaseActivity {


    @BindView(R.id.register)
    TextView register;

    @Override
    protected void init() {

    }

    @Override
    public int getLayout() {
        return R.layout.jg_addadmin_fragment;
    }



    @OnClick(R.id.register)
    public void onClick() {
        ToastUtil.show("服务器异常...");
    }
}
