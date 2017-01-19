package com.lxkj.yiyao.activity;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.db.QuestionBean;

/**
 * Created by sun on 2017/1/19.
 */

public class ExamActivity extends BaseActivity{
    @Override
    public int getLayout() {
        return R.layout.exam_layout;
    }

    @Override
    protected void init() {
        super.init();
        /*QuestionBeanHelper driverHelper = DbUtil.getDriverHelper();
        for (int i = 0; i < 10; i++){
            QuestionBean questionBean = new QuestionBean();
            questionBean.setType(0);
            questionBean.setQuestion("编译原理一般分为哪几个阶段？编译原理一般分为哪几个阶段？" + i);
            questionBean.setAnswer(2);
            driverHelper.save(questionBean);
        }*/
    }
}
