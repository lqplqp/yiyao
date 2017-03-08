package com.lxkj.yiyao.shengji;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.jianguan.*;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.learning)
    TextView learning;
    @BindView(R.id.none)
    TextView none;
    @BindView(R.id.select_project)
    TextView selectProject;
    @BindView(R.id.add_people)
    TextView addPeople;


    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.sj_fragment_layout_home;
    }


    /**
     * 点击选择项目
     */
    private void clickSelectProject() {
        toast("选择项目");
    }




    @OnClick(R.id.add_people)
    public void onClick() {
        Intent intent = new Intent(getActivity(), AddAdminActivity.class);
        startActivity(intent);
    }
}
