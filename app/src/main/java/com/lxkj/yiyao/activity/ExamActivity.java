package com.lxkj.yiyao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.bean.ExamBean;
import com.lxkj.yiyao.db.ExamDataBean;
import com.lxkj.yiyao.db.QuestionDBBean;
import com.lxkj.yiyao.global.GlobalString;
import com.lxkj.yiyao.utils.ToastUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by sun on 2017/1/19.
 */

public class ExamActivity extends BaseActivity {
    @BindView(R.id.question_tv)
    TextView questionTv;
    @BindView(R.id.last_but)
    Button lastBut;
    @BindView(R.id.next_but)
    Button nextBut;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rb_a)
    RadioButton rbA;
    @BindView(R.id.rb_b)
    RadioButton rbB;
    @BindView(R.id.rb_c)
    RadioButton rbC;
    @BindView(R.id.rb_d)
    RadioButton rbD;
    @BindView(R.id.ok_but)
    Button okBut;


    private int current = 0;
    private int num = 20;
    private int currAnswer = 1;
    private boolean isAnswer = false;
    private List<QuestionDBBean> all;
    private QuestionDBBean currQuestion;
    private List<ExamDataBean> examData = new ArrayList<>();
    private ExamDataBean currData;
    private Gson gson;
    private String kmid = "";

    @Override
    public int getLayout() {
        return R.layout.exam_layout;
    }

    @Override
    protected void init() {
        gson = new Gson();
        kmid = getIntent().getStringExtra("kmid");
        requestData();
        initView();
    }

    public void requestData() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.examUrl);
        params.addBodyParameter("kmid", kmid);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                ExamBean examBean = gson.fromJson(result, ExamBean.class);
                int retCode = examBean.getCode();
                if (11111 == retCode) {
                    examData = examBean.getData();
                    if (examData.size() > 0) {
                        current = 0;
                        exam();
                    } else {

                    }
                } else {

                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initView() {

        checkIsSelect();
        rbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamDataBean examDataBean = examData.get(current);
                examDataBean.setDa("0");
                examData.set(current, examDataBean);
            }
        });
        rbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamDataBean examDataBean = examData.get(current);
                examDataBean.setDa("1");
                examData.set(current, examDataBean);
            }
        });
        rbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamDataBean examDataBean = examData.get(current);
                examDataBean.setDa("2");
                examData.set(current, examDataBean);
            }
        });
        rbD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamDataBean examDataBean = examData.get(current);
                examDataBean.setDa("3");
                examData.set(current, examDataBean);
            }
        });
        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((current + 1) == examData.size()) {
                    ToastUtil.show("没有更多题目了");
                } else {
                    ++current;
                    noChecked();
                    exam();
                    checkIsSelect();
                }
            }
        });
        lastBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current == 0) {
                    ToastUtil.show("已经是第一题了");
                } else {
                    --current;
                    noChecked();
                    exam();
                    checkIsSelect();
                }
            }
        });
        okBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                okRequest();
            }
        });
        /*nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbA.isChecked()) {
                    currAnswer = 1;
                    isAnswer = true;
                    ContentValues values = new ContentValues();
                    values.put("answer", 1);
                    values.put("status", 1);
                    if (currQuestion.getKey() == 1) {
                        values.put("right", true);
                    }
                    DataSupport.update(QuestionDBBean.class, values, currQuestion.getId());
                } else if (rbB.isChecked()) {
                    currAnswer = 2;
                    isAnswer = true;
                    ContentValues values = new ContentValues();
                    values.put("answer", 2);
                    values.put("status", 1);
                    if (currQuestion.getKey() == 2) {
                        values.put("right", true);
                    }
                    DataSupport.update(QuestionDBBean.class, values, currQuestion.getId());
                } else if (rbC.isChecked()) {
                    currAnswer = 3;
                    isAnswer = true;
                    ContentValues values = new ContentValues();
                    values.put("answer", 3);
                    values.put("status", 1);
                    if (currQuestion.getKey() == 3) {
                        values.put("right", true);
                    }
                    DataSupport.update(QuestionDBBean.class, values, currQuestion.getId());
                } else if (rbD.isChecked()) {
                    currAnswer = 4;
                    isAnswer = true;
                    ContentValues values = new ContentValues();
                    values.put("answer", 4);
                    values.put("status", 1);
                    if (currQuestion.getKey() == 4) {
                        values.put("right", true);
                    }
                    DataSupport.update(QuestionDBBean.class, values, currQuestion.getId());
                } else {
                    isAnswer = false;
                }
                noChecked();
                if (current == num - 1) {
                    ToastUtil.show("已经做完所有题目");
                } else {
                    current++;
                    exam();
                }
                isAnswer = false;
            }
        });
        lastBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noChecked();
                if (current == 0) {
                    ToastUtil.show("已经是第一题了");
                } else {
                    current--;
                    exam();
                }
            }
        });*/
    }

    private void checkIsSelect() {
        if (examData.size() > 0){
            String da = examData.get(current).getDa();
            if (da == "0"){
                rbA.setChecked(true);
            }else if (da == "1"){
                rbB.setChecked(true);
            }else if (da == "2"){
                rbC.setChecked(true);
            }else if (da == "3"){
                rbD.setChecked(true);
            }else {
                noChecked();
            }
        }
    }

    private void okRequest() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.examOkUrl);
        String examOkJson = gson.toJson(examData);
        params.addBodyParameter("data", examOkJson);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("", result);
                JSONObject jsonObject = JSONObject.parseObject(result);
                String code = jsonObject.get("code").toString();
                String data = jsonObject.get("data").toString();
                JSONObject jsonObject1 = JSONObject.parseObject(data);
                int fs = (int) jsonObject1.get("fs");
                if (code.equals("11111")){
                    Log.d("", fs + "");
                    Intent intent = new Intent(ExamActivity.this, ExamResultActivity.class);
                    intent.putExtra("fs", fs);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void noChecked() {
        rbA.setChecked(false);
        rbB.setChecked(false);
        rbC.setChecked(false);
        rbD.setChecked(false);
    }

    /*private void checkData() {
        all = DataSupport.findAll(QuestionDBBean.class);
        if (all.size() >= num) {
            exam();
        } else {
            for (int i = 0; i < num; i++) {
                QuestionDBBean bean = new QuestionDBBean();
                bean.setType(0);
                bean.setQuestion(" 编译原理一般分为哪几个阶段？编译原理一般分为哪几个阶段？" + i);
                bean.setKey(2);
                bean.setKey1("A.词法分析" + i);
                bean.setKey2("B.语法分析" + i);
                bean.setKey3("C.语义分析和中间代码生成法分析" + i);
                bean.setKey4("D.代码优化" + i);
                bean.save();
                Log.d("ExamActivity", i + "存储情况：" + bean.save() + "");
            }
            checkData();
        }
    }*/

    private void exam() {
        currData = examData.get(current);
        questionTv.setText("" + currData.getId() + "." + currData.getTm() + "  (" + currData.getFs() + "分)");
        rbA.setText("A." + currData.getA());
        rbB.setText("B." + currData.getB());
        rbC.setText("C." + currData.getC());
        rbD.setText("D." + currData.getD());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
