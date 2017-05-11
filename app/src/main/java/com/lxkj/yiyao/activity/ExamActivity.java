package com.lxkj.yiyao.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.exam_radio_group)
    RadioGroup examRadioGroup;


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
    private String xkzbh = "";
    private String ctr = "";
    private int jyk = 0;

    @Override
    public int getLayout() {
        return R.layout.exam_layout;
    }

    @Override
    protected void init() {
        gson = new Gson();
        kmid = getIntent().getStringExtra("kmid");
        xkzbh = getIntent().getStringExtra("xkzbh");
        ctr = getIntent().getStringExtra("ctr");
        jyk = getIntent().getIntExtra("jyk", 0);
        requestData();
        initView();
    }

    public void requestData() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.examUrl);
        params.addBodyParameter("kmid", kmid);
        params.addBodyParameter("jyk", jyk + "");
        if (xkzbh != null && !xkzbh.equals("")) {
            params.addBodyParameter("xkzbh", xkzbh);
        }
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //JSONObject examBean = JSONObject.parseObject(result);
                //String  retCode = examBean.get("code").toString();

                ExamBean examBean = gson.fromJson(result, ExamBean.class);
                String retCode = examBean.getCode();
                if ("111111".equals(retCode)) {

                    examData = examBean.getData();
                    if (examData.size() > 0) {
                        current = 0;
                        kmid = examData.get(0).kmid;
                        exam();
                    } else {

                    }
                } else {

                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
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
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        checkIsSelect();
        rbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamDataBean examDataBean = examData.get(current);
                examDataBean.setDaa("A");
                examData.set(current, examDataBean);
                rbA.setChecked(true);
            }
        });
        rbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamDataBean examDataBean = examData.get(current);
                examDataBean.setDaa("B");
                examData.set(current, examDataBean);
                rbB.setChecked(true);
            }
        });
        rbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamDataBean examDataBean = examData.get(current);
                examDataBean.setDaa("C");
                examData.set(current, examDataBean);
                rbC.setChecked(true);
            }
        });
        rbD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExamDataBean examDataBean = examData.get(current);
                examDataBean.setDaa("D");
                examData.set(current, examDataBean);
                rbD.setChecked(true);
            }
        });
        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((current + 1) == examData.size()) {
                    ToastUtil.show("没有更多题目了");
                } else {
                    current = current + 1;
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
                    current = current - 1;
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

    private void noChecked() {
        examRadioGroup.clearCheck();
    }

    private void checkIsSelect() {
        noChecked();
        if (examData.size() > 0) {
            String daa = examData.get(current).getDaa() + "";
            if (daa.equals("A")) {
                rbA.setChecked(true);
                //ToastUtil.show("A");
            } else if (daa.equals("B")) {
                rbB.setChecked(true);
                //ToastUtil.show("B");
            } else if (daa.equals("C")) {
                rbC.setChecked(true);
                //ToastUtil.show("C");
            } else if (daa.equals("D")) {
                rbD.setChecked(true);
                //ToastUtil.show("D");
            } else {
                noChecked();
                //ToastUtil.show("0");
            }
        }
    }

    private void okRequest() {
        RequestParams params = new RequestParams(GlobalString.BaseURL + GlobalString.examOkUrl);
        String examOkJson = gson.toJson(examData);
        params.addBodyParameter("data", examOkJson);
        Log.i("data", examOkJson);
        //params.addBodyParameter("xkzbh",xkzbh);
        SharedPreferences sp = getSharedPreferences("shiyao", 0);
        String username = sp.getString("username", "");
        //int id = sp.getInt("id", -1);
        params.addBodyParameter("kmid", kmid);
        params.addBodyParameter("username", username);
        params.addBodyParameter("ctr", ctr + "");

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //Log.d("", result);
                JSONObject jsonObject = JSONObject.parseObject(result);
                String code = jsonObject.get("code").toString();
                String data = jsonObject.get("data").toString();
                JSONObject jsonObject1 = JSONObject.parseObject(data);
                String x = jsonObject1.get("fs") + "";
                float fs1 = Float.parseFloat(x);
                int fs = (int) fs1;

                if (code.equals("11111")) {
                    Log.d("", fs + "");
                    Intent intent = new Intent(ExamActivity.this, ExamResultActivity.class);
                    intent.putExtra("fs", fs);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
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
        nextBut.setVisibility(View.VISIBLE);
        lastBut.setVisibility(View.VISIBLE);
        if (current + 1 == examData.size()){
            nextBut.setVisibility(View.GONE);
        }else if (current == 0){
            lastBut.setVisibility(View.GONE);
        }
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
