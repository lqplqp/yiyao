package com.lxkj.yiyao.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lxkj.yiyao.utils.ToastUtil;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/1/18 0018.
 */

public abstract class BaseActivity extends Activity{
    protected Activity mActivity;

    protected View mRootView;

    public BaseActivity(){
        mActivity = this;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    protected void init(){
        mRootView = View.inflate(mActivity,getLayout(),null);
        setContentView(mRootView);
        ButterKnife.bind(mActivity,mRootView);
    }

    public View findViewById(int id){
        return mRootView.findViewById(id);
    }

    public abstract int getLayout();

    protected void toast(String msg){
        ToastUtil.show(msg);
    }


}
