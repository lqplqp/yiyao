package com.lxkj.yiyao.shiji.adapter;

/**
 * Created by Administrator on 2017/3/2.
 */

public  class AdminManagerBean {

    private String index;
    private String userName;
    private String name;

    public AdminManagerBean(String index, String userName, String name) {
        this.index = index;
        this.userName = userName;
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
