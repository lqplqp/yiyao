package com.lxkj.yiyao.jianguan;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18.
 */

public class JGManagerFragment extends BaseFragment {


    @Override
    protected void initView() {
    }

    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_jian_guandanweimanager;
    }

    @OnClick({R.id.select, R.id.add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select:
                toast("查询");
                break;
            case R.id.add:
                toast("添加");
                break;
        }
    }
}
