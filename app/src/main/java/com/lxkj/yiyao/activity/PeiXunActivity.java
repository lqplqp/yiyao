package com.lxkj.yiyao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sun on 2017/1/20.
 */

public class PeiXunActivity extends BaseActivity {
    @BindView(R.id.exam_but)
    Button examBut;
    @BindView(R.id.sp_but)
    Button spBut;

    @Override
    protected void init() {
        examBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PeiXunActivity.this, ExamActivity.class));
            }
        });
        spBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PeiXunActivity.this, PlayerActivity.class));
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.peixun_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
