package com.lxkj.yiyao.jianguan;

import android.widget.EditText;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18.
 */

public class UserManagerFragment extends BaseFragment {
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.imput_name)
    EditText imputName;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_usermanager;
    }

    @OnClick(R.id.select)
    public void onClick() {
        toast("查询");
    }
}
