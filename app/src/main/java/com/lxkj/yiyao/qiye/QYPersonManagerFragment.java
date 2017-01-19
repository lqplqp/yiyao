package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class QYPersonManagerFragment extends BaseFragment {
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.select_content)
    EditText selectContent;
    @BindView(R.id.start_time)
    EditText startTime;
    @BindView(R.id.end_time)
    EditText endTime;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_person_manage_tijian_search;
    }
    

    @OnClick(R.id.select)
    public void onClick() {
        toast("查询");// TODO: 2017/1/19  
    }
}
