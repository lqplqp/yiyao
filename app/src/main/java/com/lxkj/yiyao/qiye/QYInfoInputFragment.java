package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class QYInfoInputFragment extends BaseFragment {
    @BindView(R.id.rg_first)
    RadioButton rgFirst;
    @BindView(R.id.rg_second)
    RadioButton rgSecond;
    @BindView(R.id.rg_third)
    RadioButton rgThird;
    @BindView(R.id.rg_fourth)
    RadioButton rgFourth;
    @BindView(R.id.commit)
    Button commit;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_qyinfo_input;
    }


    @OnClick(R.id.commit)
    public void onClick() {
        toast("提交");
        // TODO: 2017/1/19 提交
    }
}
