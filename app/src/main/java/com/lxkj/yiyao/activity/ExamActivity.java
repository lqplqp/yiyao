package com.lxkj.yiyao.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.lxkj.yiyao.R;
import com.lxkj.yiyao.base.BaseActivity;
import com.lxkj.yiyao.db.QuestionDBBean;
import com.lxkj.yiyao.utils.ToastUtil;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by sun on 2017/1/19.
 */

public class ExamActivity extends BaseActivity {
    @BindView(R.id.num_tv)
    TextView numTv;
    @BindView(R.id.type_tv)
    TextView typeTv;
    @BindView(R.id.question_tv)
    TextView questionTv;
    @BindView(R.id.first_key_tv)
    TextView firstKeyTv;
    @BindView(R.id.first_rb)
    RadioButton firstRb;
    @BindView(R.id.second_key_tv)
    TextView secondKeyTv;
    @BindView(R.id.second_rb)
    RadioButton secondRb;
    @BindView(R.id.third_key_tv)
    TextView thirdKeyTv;
    @BindView(R.id.third_rb)
    RadioButton thirdRb;
    @BindView(R.id.fourth_key_tv)
    TextView fourthKeyTv;
    @BindView(R.id.fourth_rb)
    RadioButton fourthRb;
    @BindView(R.id.last_but)
    Button lastBut;
    @BindView(R.id.next_but)
    Button nextBut;


    private int current = 0;
    private int num = 20;
    private List<QuestionDBBean> all;

    @Override
    public int getLayout() {
        return R.layout.exam_layout;
    }

    @Override
    protected void init() {
        checkData();
        initView();
    }

    private void initView() {
        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current >= num - 1){
                    ToastUtil.show("已经做完所有题目");
                }else {
                    current++;
                    exam();
                }

            }
        });
        lastBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current == 0){
                    ToastUtil.show("已经是第一题了");
                }else {
                    current--;
                    exam();
                }
            }
        });
    }

    private void checkData() {
        all = DataSupport.findAll(QuestionDBBean.class);
        if (all.size() >= num) {
            exam();
        } else {
            for (int i = 0; i < num; i++) {
                QuestionDBBean bean = new QuestionDBBean();
                bean.setType(0);
                bean.setQuestion(" 编译原理一般分为哪几个阶段？编译原理一般分为哪几个阶段？" + i);
                bean.setAnswer(2);
                bean.setKey1("A.词法分析" + i);
                bean.setKey2("B.语法分析" + i);
                bean.setKey3("C.语义分析和中间代码生成法分析" + i);
                bean.setKey4("D.代码优化" + i);
                bean.save();
                Log.d("ExamActivity", i + "存储情况：" + bean.save() + "");
            }
            checkData();
        }
    }

    private void exam() {
        QuestionDBBean questionDBBean = all.get(current);
        numTv.setText("" + questionDBBean.getId());
        if (questionDBBean.getType() == 0) {
            typeTv.setText("选择题");
        } else {
            typeTv.setText("判断题");
        }
        questionTv.setText("" + questionDBBean.getQuestion() + questionDBBean.getId());
        firstKeyTv.setText("" + questionDBBean.getKey1() + questionDBBean.getId());
        secondKeyTv.setText("" + questionDBBean.getKey2() + questionDBBean.getId());
        thirdKeyTv.setText("" + questionDBBean.getKey3() + questionDBBean.getId());
        fourthKeyTv.setText("" + questionDBBean.getKey4() + questionDBBean.getId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
