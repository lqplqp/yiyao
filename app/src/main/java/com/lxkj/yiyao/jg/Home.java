package com.lxkj.yiyao.jg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.sj.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class Home extends BaseFragment {

    @BindView(R.id.content)
    TextView content;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_home;
    }


    public void showMsg(String msg){
        content.setText(msg);
    }

}
