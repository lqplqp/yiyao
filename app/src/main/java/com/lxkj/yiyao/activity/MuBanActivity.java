package com.lxkj.yiyao.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqinpeng on 2017/3/13 0013.
 */

public class MuBanActivity extends BaseActivity {
    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void init() {
        Glide.with(this).load("http://af.0101hr.com/moban.png").into(image);
    }

    @Override
    public int getLayout() {
        return R.layout.image;
    }

}
