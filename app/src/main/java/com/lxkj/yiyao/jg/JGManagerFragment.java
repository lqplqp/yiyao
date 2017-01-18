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

public class JGManagerFragment extends BaseFragment {
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.start_time)
    EditText startTime;
    @BindView(R.id.end_time)
    EditText endTime;
    @BindView(R.id.input_username)
    EditText inputUsername;
    @BindView(R.id.add)
    TextView add;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_jianGuanDanWeimanager;
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
