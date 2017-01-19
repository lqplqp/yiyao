package com.lxkj.yiyao.db;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sun on 2017/1/19.
 */

public class QuestionDBBean extends RealmObject{
    @PrimaryKey
    private Long num;
    private int type;
    private String question;
    private int key1;
    private int key2;
    private int key3;
    private int key4;
    private int answer;
    private boolean right;
    private int status;

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getKey1() {
        return key1;
    }

    public void setKey1(int key1) {
        this.key1 = key1;
    }

    public int getKey2() {
        return key2;
    }

    public void setKey2(int key2) {
        this.key2 = key2;
    }

    public int getKey3() {
        return key3;
    }

    public void setKey3(int key3) {
        this.key3 = key3;
    }

    public int getKey4() {
        return key4;
    }

    public void setKey4(int key4) {
        this.key4 = key4;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
