package com.lxkj.yiyao.base;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lxkj.yiyao.db.MyRealm;
import com.lxkj.yiyao.utils.ToastUtil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;

    private View mRootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayout(), container, false);
        init();
        return mRootView;
    }

    private  void init(){
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
        ToastUtil.show(msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
