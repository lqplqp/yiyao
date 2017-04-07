package com.lxkj.yiyao.bean;

import java.util.List;

/**
 * Created by liqinpeng on 2017/3/30 0030.
 *
 * @author 李秦鹏
 *         -------------------------------
 */

public class QiYeHomeBean {
    /**
     * data : [{"tzbt":"黑恶"},{"tzbt":"黑恶"},{"tzbt":" 测试"}]
     * jgxxz : 2
     * jgywc : 0
     * pxxmxxz : 1
     * pxxmywc : 0
     */

    private int jgxxz;
    private int jgywc;
    private int pxxmxxz;
    private int pxxmywc;
    private List<DataBean> data;

    public int getJgxxz() {
        return jgxxz;
    }

    public void setJgxxz(int jgxxz) {
        this.jgxxz = jgxxz;
    }

    public int getJgywc() {
        return jgywc;
    }

    public void setJgywc(int jgywc) {
        this.jgywc = jgywc;
    }

    public int getPxxmxxz() {
        return pxxmxxz;
    }

    public void setPxxmxxz(int pxxmxxz) {
        this.pxxmxxz = pxxmxxz;
    }

    public int getPxxmywc() {
        return pxxmywc;
    }

    public void setPxxmywc(int pxxmywc) {
        this.pxxmywc = pxxmywc;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * tzbt : 黑恶
         */

        private String tzbt;

        public String getTzbt() {
            return tzbt;
        }

        public void setTzbt(String tzbt) {
            this.tzbt = tzbt;
        }
    }
}
