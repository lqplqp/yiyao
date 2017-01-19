package com.lxkj.yiyao.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lxkj.yiyao.db.MyRealm;
import com.lxkj.yiyao.utils.ToastUtil;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/1/18 0018.
 */

public abstract class BaseActivity extends AppCompatActivity{
    protected AppCompatActivity mActivity;

    protected View mRootView;

    public BaseActivity(){
        mActivity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootView = View.inflate(mActivity,getLayout(),null);
        setContentView(mRootView);
        ButterKnife.bind(mActivity,mRootView);
        init();
    }

    protected abstract void init();

    public View findViewById(int id){
        return mRootView.findViewById(id);
    }

    public abstract int getLayout();

    protected void toast(String msg){
        ToastUtil.show(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
