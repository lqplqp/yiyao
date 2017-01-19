package com.lxkj.yiyao.db;


import com.lxkj.yiyao.dao.QuestionBeanDao;

/**
 * Created by apple on 2016/10/17.
 * 获取表 Helper 的工具类
 */

public class DbUtil {
    private static QuestionBeanHelper mDbBeanHelper;


    private static QuestionBeanDao getDriverDao() {
        return DbCore.getDaoSession().getQuestionBeanDao();
    }

    public static QuestionBeanHelper getDriverHelper() {
        if (mDbBeanHelper == null) {
            mDbBeanHelper = new QuestionBeanHelper(getDriverDao());
        }
        return mDbBeanHelper;
    }

}
