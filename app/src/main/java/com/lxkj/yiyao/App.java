package com.lxkj.yiyao;


import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import org.litepal.LitePalApplication;
import org.litepal.tablemanager.Connector;
import org.xutils.x;


/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class App extends LitePalApplication {

    public static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        x.Ext.init(this);
        SQLiteDatabase db = Connector.getDatabase();
    }
}
