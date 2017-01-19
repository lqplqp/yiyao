package com.lxkj.yiyao.db;

import android.content.Context;

import io.realm.Realm;

/**
 * Created by sun on 2017/1/19.
 */

public class MyRealm {
    private static Realm myRealm;

    public static Realm getInstance(){
        if (myRealm == null){
            myRealm = Realm.getDefaultInstance();
        }
        return myRealm;
    }
}
