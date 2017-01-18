package com.lxkj.yiyao;


import android.app.Application;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class App extends Application {

    public static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }
}
