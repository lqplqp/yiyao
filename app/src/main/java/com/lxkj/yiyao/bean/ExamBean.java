package com.lxkj.yiyao.bean;

import java.util.List;

/**
 * Created by sun on 2017/3/12.
 */

public class ExamBean {
    public List<Data> data;
    public int code;
    public String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data{
        /**
         * kmid			科目id 判断对应题库

         tm			题目
         a			A
         b			B
         c			C
         d			D
         da			答案
         fs			分数
         zf			总分
         jgfs			及格分数

         */
        public String tm;
        public String a;
        public String b;
        public String c;
        public String d;
        public String da;
        public String fs;
        public int zf;
        public int jgfs;
        public int kmid;
        public int id;


    }
}
