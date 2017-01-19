package com.lxkj.yiyao.db;

import com.lxkj.yiyao.dao.QuestionBeanDao;

import org.greenrobot.greendao.AbstractDao;

/**
 * Created by apple on 2016/10/17.
 * 具体表的实现类
 */

public class QuestionBeanHelper extends BaseDbHelper<QuestionBean, Long> {


    public QuestionBeanHelper(AbstractDao dao) {
        super(dao);
    }
}
