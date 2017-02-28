package com.lxkj.yiyao.shengjugeren;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/19.
 */

public class SJGRMessageFragment extends BaseFragment {

    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.img4)
    ImageView img4;

    @Override
    protected void initView() {
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb1.setBackgroundResource(R.drawable.blue_but_bg);
                rb1.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));
                img1.setBackgroundResource(R.color.colorAccent);
                img2.setBackgroundResource(R.color.colorAccent);
                img3.setBackgroundResource(R.color.colorAccent);
                img4.setBackgroundResource(R.color.colorAccent);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb2.setBackgroundResource(R.drawable.blue_but_bg);
                rb1.setTextColor(getResources().getColor(R.color.global_black));
                rb2.setTextColor(getResources().getColor(R.color.white));
                img1.setBackgroundResource(R.color.global_bg_blue);
                img2.setBackgroundResource(R.color.global_red);
                img3.setBackgroundResource(R.color.global_red);
                img4.setBackgroundResource(R.color.global_bg_blue);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
