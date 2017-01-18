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

public class CompanyManager extends BaseFragment {
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.company_name)
    EditText companyName;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_companyManager;
    }

    @OnClick(R.id.select)
    public void onClick() {
        toast("查询");
        // TODO: 2017/1/18  
    }
}
