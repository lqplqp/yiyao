package com.lxkj.yiyao.jianguan;

import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class HomeFragment extends BaseFragment {

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
