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

public class QiyeInfoCardFragment extends BaseFragment {
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.company_name)
    EditText companyName;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_infocard_manage_search;
    }

    @OnClick(R.id.select)
    public void onClick() {
        toast("查询");
        // TODO: 2017/1/18
    }
}
