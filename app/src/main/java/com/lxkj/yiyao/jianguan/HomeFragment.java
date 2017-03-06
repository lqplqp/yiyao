package com.lxkj.yiyao.jianguan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.activity.RegisterActivity;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.add_people)
    TextView addPeople;
    @BindView(R.id.select_project)
    TextView selectProject;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.jg_fragment_layout_home;
    }


    public void showMsg(String msg) {
        content.setText(msg);
    }




    @OnClick({R.id.add_people, R.id.select_project})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_people:
                Intent intent = new Intent(getActivity(),AddAdminActivity.class);
                startActivity(intent);
                break;
            case R.id.select_project:
                break;
        }
    }
}
