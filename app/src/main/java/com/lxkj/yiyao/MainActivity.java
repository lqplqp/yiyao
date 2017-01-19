package com.lxkj.yiyao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lxkj.yiyao.activity.ExamActivity;
import com.lxkj.yiyao.adapter.VPFAdapter;
import com.lxkj.yiyao.utils.ToastUtil;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navi_view)
    NavigationView naviView;
    @BindView(R.id.drawer)
    DrawerLayout drawer;

    private String[] shengjiTabTitles = {"首页", "审核"};
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawerToggle.syncState();
        drawer.setDrawerListener(drawerToggle);
        naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navi_menu_1:
                        ToastUtil.show("监督人员首页");
                        break;
                    case R.id.navi_menu_2:
                        ToastUtil.show("监管人员中心");
                        break;
                    case R.id.navi_menu_3:
                        ToastUtil.show("培训学习");
                        break;
                    case R.id.navi_menu_4:
                        ToastUtil.show("企业管理");
                        break;
                    case R.id.navi_menu_5:
                        ToastUtil.show("监管统计");
                        break;
                    case R.id.navi_menu_6:
                        ToastUtil.show("体检信息");
                        break;
                    case R.id.navi_menu_7:
                        ToastUtil.show("下载中心");
                        break;
                    case R.id.navi_menu_8:
                        ToastUtil.show("安全设置");
                        break;
                }
                drawer.closeDrawers();
                return true;
            }
        });
        viewPager.setAdapter(new VPFAdapter(getSupportFragmentManager(), 0, getResources().getStringArray(R.array.addJianGuanUnit)));
        tab.setupWithViewPager(viewPager);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);


        initData();
//        startActivity(new Intent(MainActivity.this, ExamActivity.class));
    }

    private void initData() {
//
////        new MyOpenHelper(this, "info.db").onUpgrade();
//        QuestionBeanHelper driverHelper = DbUtil.getDriverHelper();
//        QuestionDBBean questionBean = new QuestionDBBean();
//        questionBean.setType(0);
//        questionBean.setQuestion("第一题");
//        questionBean.setAnswer(2);
//        driverHelper.save(questionBean);
//        QuestionDBBean questionBean1 = driverHelper.queryAll().get(0);
//        ToastUtil.show(" " + questionBean1.getNum() + ", 题目：" + questionBean1.getQuestion() + "答案：" + questionBean1.getAnswer());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
