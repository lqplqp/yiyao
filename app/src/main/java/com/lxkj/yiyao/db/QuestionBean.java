package com.lxkj.yiyao.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by sun on 2017/1/19.
 */

@Entity
public class QuestionBean {
    @Id
    public Long num;
    public int type;
    public String question;
    public int answer;
    public boolean right;
    public boolean getRight() {
        return this.right;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public int getAnswer() {
        return this.answer;
    }
    public void setAnswer(int answer) {
        this.answer = answer;
    }
    public String getQuestion() {
        return this.question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public Long getNum() {
        return this.num;
    }
    public void setNum(Long num) {
        this.num = num;
    }
    @Generated(hash = 1929061428)
    public QuestionBean(Long num, int type, String question, int answer,
            boolean right) {
        this.num = num;
        this.type = type;
        this.question = question;
        this.answer = answer;
        this.right = right;
    }
    @Generated(hash = 842286453)
    public QuestionBean() {
    }
}
