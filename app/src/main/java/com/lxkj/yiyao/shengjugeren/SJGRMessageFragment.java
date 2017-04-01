package com.lxkj.yiyao.shengjugeren;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/19.
 */

public class SJGRMessageFragment extends BaseFragment {

    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.list_view)
    ListView listView;
    Unbinder unbinder;

    @Override
    protected void initView() {
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb1.setBackgroundResource(R.drawable.blue_but_bg);
                rb1.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));

            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb2.setBackgroundResource(R.drawable.blue_but_bg);
                rb1.setTextColor(getResources().getColor(R.color.global_black));
                rb2.setTextColor(getResources().getColor(R.color.white));
            }
        });
    }


    private void hide() {
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb1.setBackgroundResource(R.drawable.fillet_white_bg);
        rb2.setBackgroundResource(R.drawable.fillet_white_bg);
    }

    @Override
    public int getLayout() {
        return R.layout.sjgr_fragment_layout_message;
    }

}
