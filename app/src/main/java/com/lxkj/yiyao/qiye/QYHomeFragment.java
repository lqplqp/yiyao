package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class QYHomeFragment extends BaseFragment {
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.select)
    TextView select;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_home;
    }

    @OnClick({R.id.add, R.id.select})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                toast("增加");// TODO: 2017/1/19 增加
                break;
            case R.id.select:
                toast("选择");// TODO: 2017/1/19 选择
                break;
        }
    }
}
