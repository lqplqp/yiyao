package com.lxkj.yiyao.bean;

import com.lxkj.yiyao.db.ExamDataBean;

import java.util.List;

/**
 * Created by sun on 2017/3/12.
 */

public class ExamBean {
    public List<ExamDataBean> data;
    public String code;
    public String message;

    public List<ExamDataBean> getData() {
        return data;
    }

    public void setData(List<ExamDataBean> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
