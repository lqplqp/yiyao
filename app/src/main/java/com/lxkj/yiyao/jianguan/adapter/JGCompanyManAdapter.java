package com.lxkj.yiyao.jianguan.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lxkj.yiyao.R;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class JGCompanyManAdapter extends MBaseAdapter {


    public JGCompanyManAdapter(String bean) {
        super(bean);
    }

    @Override
    protected void fillData(int i, Object holder, String result) {

    }

    @Override
    protected int getItemLayout() {
        return 0;
    }

    @Override
    protected Object getHolder(View view) {
        return null;
    }
}
