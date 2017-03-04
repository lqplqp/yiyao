package com.lxkj.yiyao.qiye;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TableLayout;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/19.
 */

public class QYTrainOrderFragment extends BaseFragment {
    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.rb_3)
    RadioButton rb3;
    @BindView(R.id.rb_4)
    RadioButton rb4;
    @BindView(R.id.tab1)
    TableLayout tab1;
    /*@BindView(R.id.tab2)
    TableLayout tab2;*/

    @Override
    protected void initView() {
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb1.setBackgroundResource(R.drawable.blue_but_bg);
                rb1.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));
                rb3.setTextColor(getResources().getColor(R.color.global_black));
                rb4.setTextColor(getResources().getColor(R.color.global_black));
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb2.setBackgroundResource(R.drawable.blue_but_bg);
                rb2.setTextColor(getResources().getColor(R.color.white));
                rb1.setTextColor(getResources().getColor(R.color.global_black));
                rb3.setTextColor(getResources().getColor(R.color.global_black));
                rb4.setTextColor(getResources().getColor(R.color.global_black));
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb3.setBackgroundResource(R.drawable.blue_but_bg);
                rb3.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));
                rb1.setTextColor(getResources().getColor(R.color.global_black));
                rb4.setTextColor(getResources().getColor(R.color.global_black));
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                rb4.setBackgroundResource(R.drawable.blue_but_bg);
                rb4.setTextColor(getResources().getColor(R.color.white));
                rb2.setTextColor(getResources().getColor(R.color.global_black));
                rb3.setTextColor(getResources().getColor(R.color.global_black));
                rb1.setTextColor(getResources().getColor(R.color.global_black));
            }
        });
    }

    private void hide() {
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);
        rb1.setBackgroundResource(R.drawable.fillet_white_bg);
        rb2.setBackgroundResource(R.drawable.fillet_white_bg);
        rb3.setBackgroundResource(R.drawable.fillet_white_bg);
        rb4.setBackgroundResource(R.drawable.fillet_white_bg);
    }

    @Override
    public int getLayout() {
        return R.layout.qy_fragment_layout_train_order;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
