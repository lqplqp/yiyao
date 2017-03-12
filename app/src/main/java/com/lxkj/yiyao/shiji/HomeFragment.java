package com.lxkj.yiyao.shiji;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.SelectTrainActivity;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.jianguan.*;
import com.lxkj.yiyao.jianguan.AddAdminActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class HomeFragment extends BaseFragment {


    @BindView(R.id.add_people)
    TextView addPeople;
    @BindView(R.id.learning)
    TextView learning;
    @BindView(R.id.none)
    TextView none;
    @BindView(R.id.select_project)
    TextView selectProject;
    @BindView(R.id.content)
    TextView content;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.shiji_fragment_layout_home;
    }


    @OnClick({R.id.add_people, R.id.select_project})
    public void onClick(View view) {
        Intent intent ;
        switch (view.getId()) {
            case R.id.add_people:
                intent = new Intent(getActivity(),AddAdminActivity.class);
                startActivity(intent);
                break;
            case R.id.select_project:
                intent = new Intent(getActivity(),SelectTrainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
