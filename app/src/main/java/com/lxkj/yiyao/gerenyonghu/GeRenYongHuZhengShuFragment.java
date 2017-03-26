package com.lxkj.yiyao.gerenyonghu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.view.RefreshListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/16.
 */

public class GeRenYongHuZhengShuFragment extends BaseFragment {

    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.list_view)
    RefreshListView listView;
    Unbinder unbinder;

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.gerenyonghu_wodezhengshu;
    }


    @OnClick({R.id.rb_1, R.id.rb_2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_1:
                rb1.setBackgroundResource(R.drawable.blue_but_bg);
                rb1.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));
                rb2.setBackgroundResource(R.drawable.radiobut_color);
                break;
            case R.id.rb_2:
                rb2.setBackgroundResource(R.drawable.blue_but_bg);
                rb2.setTextColor(getResources().getColor(R.color.white));
                rb1.setTextColor(getResources().getColor(R.color.global_black));
                rb1.setBackgroundResource(R.drawable.radiobut_color);
                break;
        }
    }
}
