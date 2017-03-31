package com.lxkj.yiyao.utils;

import android.content.Context;

/**
 * Created by sun on 2017/3/31.
 */

public class SPUtil {
    public static String getUserName(Context context){
        String username = context.getSharedPreferences("shiyao", Context.MODE_PRIVATE).getString("username", "");
        return username;
    }
    public static String getString(Context context, String key){
        String result = context.getSharedPreferences("shiyao", Context.MODE_PRIVATE).getString(key, "");
        return result;
    }
    public static int getInt(Context context, String key){
        int result = context.getSharedPreferences("shiyao", Context.MODE_PRIVATE).getInt(key, 0);
        return result;
    }
}
