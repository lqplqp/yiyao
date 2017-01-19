package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class QYTrainOrderFragment extends BaseFragment {
    @BindView(R.id.all)
    RadioButton all;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_train_order;
    }

    @OnClick(R.id.all)
    public void onClick() {
        toast("全部");
        // TODO: 2017/1/19 标题栏“全部”
    }
}
