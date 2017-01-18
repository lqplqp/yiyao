package com.lxkj.yiyao.jg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.sj.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class LawManager extends BaseFragment {
    @BindView(R.id.select)
    TextView select;
    @BindView(R.id.number)
    EditText number;
    @BindView(R.id.type)
    Spinner type;
    @BindView(R.id.start_time)
    EditText startTime;
    @BindView(R.id.end_time)
    EditText endTime;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_law_update;
    }

    public void toSelect(){
        //// TODO: 2017/1/18 0018 查询按钮
        toast("查询");
    }


    @OnClick(R.id.select)
    public void onClick() {
    }
}
