package com.lxkj.yiyao.db;

import org.litepal.crud.DataSupport;

/**
 * Created by sun on 2017/3/12.
 */

public class ExamDataBean  extends DataSupport {
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
     daa  提交的答案

     */
    public String tm;
    public String a;
    public String b;
    public String c;
    public String d;
    public String da;
    public String daa;
    public String fs;
    public int zf;
    public int jgfs;
    public String kmid;
    public int id;

    public String getDaa() {
        return daa;
    }

    public void setDaa(String daa) {
        this.daa = daa;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public int getZf() {
        return zf;
    }

    public void setZf(int zf) {
        this.zf = zf;
    }

    public int getJgfs() {
        return jgfs;
    }

    public void setJgfs(int jgfs) {
        this.jgfs = jgfs;
    }

    public String getKmid() {
        return kmid;
    }

    public void setKmid(String kmid) {
        this.kmid = kmid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

