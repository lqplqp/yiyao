package com.lxkj.yiyao.shengji;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.shengji.contract.HomeContract;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class HomeFragment extends BaseFragment implements HomeContract.HomeView, View.OnClickListener {

    @BindView(R.id.add_people)
    TextView addPeople;
    @BindView(R.id.learning)
    TextView learning;
    @BindView(R.id.none)
    TextView none;
    @BindView(R.id.select_project)
    TextView selectProject;


    @Override
    public void addPeople() {

    }

    @Override
    public void selectProject() {

    }

    @Override
    public void changeLearningCount(int count) {
        learning.setText("" + count);
    }

    @Override
    public void changeNoneCount(int count) {
        none.setText("" + count);
    }

    @Override
    protected void initView() {
        addPeople.setOnClickListener(this);
        selectProject.setOnClickListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.sj_fragment_layout_home;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.add_people:
                clickAddPeople();
                break;
            case R.id.select_project:
                clickSelectProject();
                break;
        }
    }

    /**
     * 点击添加人员
     */
    private void clickAddPeople() {
        toast("添加人员");
    }

    /**
     * 点击选择项目
     */
    private void clickSelectProject() {
        toast("选择项目");
    }


}
