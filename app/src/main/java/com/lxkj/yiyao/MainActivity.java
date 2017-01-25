package com.lxkj.yiyao;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;

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
    private int userType;
    private VPFAdapter vpfAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }



    private void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawerToggle.syncState();
        drawer.setDrawerListener(drawerToggle);

        //naviView.inflateMenu(R.menu.navi_menu);

        switch (userType){
            case 0:
                naviView.inflateMenu(R.menu.navi_menu_jianguan);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        switch (id){
                            case R.id.navi_menu_1:
                                ToastUtil.show("分级管理");
                                break;
                            case R.id.navi_menu_2:
                                ToastUtil.show("安全管理");
                                break;
                            case R.id.navi_menu_3:
                                ToastUtil.show("退出账户");
                                break;
                        }
                        return true;
                    }
                });
                break;
            case 1:
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),10, getResources().getStringArray(R.array.shengjiguanliyuan0));
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_shengjuadmin);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        switch (id){
                            case R.id.navi_menu_1:
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),10, getResources().getStringArray(R.array.shengjiguanliyuan0));
                                break;
                            case R.id.navi_menu_2:
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),11, getResources().getStringArray(R.array.shengjiguanliyuan1));
                                break;
                            case R.id.navi_menu_3:
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),12, getResources().getStringArray(R.array.shengjiguanliyuan2));
                                break;
                            case R.id.navi_menu_4:
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),13, getResources().getStringArray(R.array.shengjiguanliyuan3));
                                break;
                            case R.id.navi_menu_5:
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),14, getResources().getStringArray(R.array.shengjiguanliyuan4));
                                break;
                            case R.id.navi_menu_6:
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),15, getResources().getStringArray(R.array.shengjiguanliyuan5));
                                break;
                            case R.id.navi_menu_7:
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),16, getResources().getStringArray(R.array.shengjiguanliyuan6));
                                break;
                            case R.id.navi_menu_8:
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),17, getResources().getStringArray(R.array.shengjiguanliyuan7));
                                break;
                            case R.id.navi_menu_9:
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),18, getResources().getStringArray(R.array.shengjiguanliyuan8));
                                break;
                            case R.id.navi_menu_10:
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),19, getResources().getStringArray(R.array.shengjiguanliyuan9));
                                break;
                        }
                        setVP();
                        drawer.closeDrawers();
                        return true;
                    }
                });
                break;
            case 2:
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),20, getResources().getStringArray(R.array.shengjugeren0));
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_shengjugeren);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        vpfAdapter = null;
                        int id = item.getItemId();
                        switch (id){
                            case R.id.navi_menu_1:
                                //省局个人首页
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),20, getResources().getStringArray(R.array.shengjugeren0));
                                break;
                            case R.id.navi_menu_2:
                                // 监管人员中心
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),21, getResources().getStringArray(R.array.shengjugeren1));
                                break;
                            case R.id.navi_menu_3:
                                // 培训学习
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),22, getResources().getStringArray(R.array.shengjugeren2));
                                break;
                            case R.id.navi_menu_4:
                                // 企业管理
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),23, getResources().getStringArray(R.array.shengjugeren3));
                                break;
                            case R.id.navi_menu_5:
                                // 监管统计
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),24, getResources().getStringArray(R.array.shengjugeren4));
                                break;
                            case R.id.navi_menu_6:
                                // 体检信息
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),25, getResources().getStringArray(R.array.shengjugeren5));
                                break;
                            case R.id.navi_menu_7:
                                // 下载中心
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),26, getResources().getStringArray(R.array.shengjugeren6));
                                break;
                            case R.id.navi_menu_8:
                                // 安全设置
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),27, getResources().getStringArray(R.array.shengjugeren7));
                                break;
                        }
                        setVP();
                        drawer.closeDrawers();
                        return true;
                    }
                });
                break;
            case 3://市级管理员
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),30, getResources().getStringArray(R.array.shiji0));
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_shiji);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        vpfAdapter = null;
                        int id = item.getItemId();
                        switch (id){
                            case R.id.navi_menu_1:
                                //首页
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),30, getResources().getStringArray(R.array.shiji0));
                                break;
                            case R.id.navi_menu_2:
                                // 监管单位管理
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),31, getResources().getStringArray(R.array.shiji1));
                                break;
                            case R.id.navi_menu_3:
                                // 培训通知管理
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),32, getResources().getStringArray(R.array.shiji2));
                                break;
                            case R.id.navi_menu_4:
                                // 企业管理
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),33, getResources().getStringArray(R.array.shiji3));
                                break;
                            case R.id.navi_menu_5:
                                // 培训报名
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),34, getResources().getStringArray(R.array.shiji4));
                                break;
                            case R.id.navi_menu_6:
                                // 监管统计
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),35, getResources().getStringArray(R.array.shiji5));
                                break;
                            case R.id.navi_menu_7:
                                // 体检信息
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),36, getResources().getStringArray(R.array.shiji6));
                                break;
                            case R.id.navi_menu_8:
                                // 下载中心
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),37, getResources().getStringArray(R.array.shiji7));
                                break;
                            case R.id.navi_menu_9:
                                // 安全设置
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),38, getResources().getStringArray(R.array.shiji8));
                                break;
                        }
                        setVP();
                        drawer.closeDrawers();
                        return true;
                    }
                });
                break;
            case 4://企业管理员
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),40, getResources().getStringArray(R.array.qiye0));
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_qiye);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        vpfAdapter = null;
                        int id = item.getItemId();
                        switch (id){
                            case R.id.navi_menu_1:
                                //首页
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),40, getResources().getStringArray(R.array.qiye0));
                                break;
                            case R.id.navi_menu_2:
                                // 企业管理
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),41, getResources().getStringArray(R.array.qiye1));
                                break;
                            case R.id.navi_menu_3:
                                // 培训报名
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),42, getResources().getStringArray(R.array.qiye2));
                                break;
                            case R.id.navi_menu_4:
                                // 下载中心
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),43, getResources().getStringArray(R.array.qiye3));
                                break;
                            case R.id.navi_menu_5:
                                // 安全设置
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),44, getResources().getStringArray(R.array.qiye4));
                                break;
                        }
                        setVP();
                        drawer.closeDrawers();
                        return true;
                    }
                });
                break;
            case 5:
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),40, getResources().getStringArray(R.array.qiye0));
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_qiye);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        vpfAdapter = null;
                        int id = item.getItemId();
                        switch (id){
                            case R.id.navi_menu_1:
                                //首页
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),40, getResources().getStringArray(R.array.qiye0));
                                break;
                            case R.id.navi_menu_2:
                                // 企业管理
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),41, getResources().getStringArray(R.array.qiye1));
                                break;
                            case R.id.navi_menu_3:
                                // 培训报名
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),42, getResources().getStringArray(R.array.qiye2));
                                break;
                            case R.id.navi_menu_4:
                                // 下载中心
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),43, getResources().getStringArray(R.array.qiye3));
                                break;
                            case R.id.navi_menu_5:
                                // 安全设置
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),44, getResources().getStringArray(R.array.qiye4));
                                break;
                        }
                        setVP();
                        drawer.closeDrawers();
                        return true;
                    }
                });
                break;
        }
    }

    private void setVP() {
        viewPager.setAdapter(vpfAdapter);
        tab.setupWithViewPager(viewPager);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
    }


    private SpannableStringBuilder addColor(CharSequence text, int color) {
        SpannableStringBuilder builder = new SpannableStringBuilder(text);

        if (color != 0) {
            builder.setSpan(new ForegroundColorSpan(color), 0, text.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        }
        return builder;
    }

    private void initData() {
        userType = getIntent().getIntExtra("userType", 0);
        /*switch (userType){
            case 0:
                //naviView.inflateMenu(R.menu.navi_menu_jianguan);
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(), 0, getResources().getStringArray(R.array.addJianGuanUnit));
                break;
            case 1:
                //naviView.inflateMenu(R.menu.navi_menu);
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(), 1, getResources().getStringArray(R.array.ShengJuAdmin));
                break;
            case 2:
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(), 2, getResources().getStringArray(R.array.ShengJuMan));
                break;
            case 3:
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(), 3, getResources().getStringArray(R.array.ShiJiAdmin));
                break;
            case 4:
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(), 4, getResources().getStringArray(R.array.CompanyAdmin));
                break;
            case 5:
                vpfAdapter = new VPFAdapter(getSupportFragmentManager(), 5, getResources().getStringArray(R.array.XianAdmin));
                break;
        }*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
