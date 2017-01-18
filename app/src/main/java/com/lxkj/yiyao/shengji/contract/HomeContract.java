package com.lxkj.yiyao.shengji.contract;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class HomeContract {
    public interface HomeView{
        /**
         * 增加监管人员
         */
        void addPeople();

        /**
         * 选择项目
         */
        void selectProject();

        /**
         * 修改学习中数目
         * @param count
         */
        void changeLearningCount(int count);

        /**
         * 修改学习完成数目
         * @param count
         */
        void changeNoneCount(int count);
    }
}
