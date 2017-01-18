package com.lxkj.yiyao.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;

    private View mRootView;

    public BaseFragment(){
        mActivity = getActivity();
        init();

    }

    private  void init(){
        mRootView = View.inflate(mActivity,getLayout(),null);
        ButterKnife.bind(this,mRootView);
    }

    /**
     * 初始化界面,寻找view,设置监听
     */
    protected abstract void initView();

    protected View findViewById(int id){
        return mRootView.findViewById(id);
    }

    public abstract int getLayout();

    public void toast(String msg){
        Toast.makeText(mActivity,msg,Toast.LENGTH_SHORT).show();
    }

}
