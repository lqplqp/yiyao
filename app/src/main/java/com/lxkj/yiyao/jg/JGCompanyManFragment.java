package com.lxkj.yiyao.jg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.sj.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18.
 */

public class JGCompanyManFragment extends BaseFragment {
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.add)
    TextView add;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_jianGuanRenYuan;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.select, R.id.back, R.id.add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select:
                toast("查询");
                // TODO: 2017/1/18 完善查询 
                break;
            case R.id.back:
                toast("返回");
                // TODO: 2017/1/18  
                break;
            case R.id.add:
                toast("添加");
                // TODO: 2017/1/18  
                break;
        }
    }
}
