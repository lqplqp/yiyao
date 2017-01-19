package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class QYMessageSearchFragment extends BaseFragment {
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.company)
    EditText company;
    @BindView(R.id.message_type)
    Spinner messageType;
    @BindView(R.id.administrative_type)
    Spinner administrativeType;
    @BindView(R.id.train_type)
    Spinner trainType;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_message_search;
    }


    @OnClick(R.id.select)
    public void onClick() {
        toast("查询");// TODO: 2017/1/19
    }
}
