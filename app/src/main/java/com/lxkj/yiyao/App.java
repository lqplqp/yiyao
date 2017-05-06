package com.lxkj.yiyao;


import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.lxkj.yiyao.utils.SPUtil;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import org.litepal.LitePalApplication;
import org.litepal.tablemanager.Connector;
import org.xutils.x;


/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class App extends Application {

    public static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        x.Ext.init(this);
        x.Ext.setDebug(true);
        String s = SPUtil.getUserName(mApplication);
        ZXingLibrary.initDisplayOpinion(this);
//        SQLiteDatabase db = Connector.getDatabase();
    }
}