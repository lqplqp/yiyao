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
                naviView.inflateMenu(R.menu.navi_menu_qiyeadmin);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        switch (id){
                            case R.id.navi_menu_1:
                                //ToastUtil.show("分级管理");
                                vpfAdapter = new VPFAdapter(getSupportFragmentManager(),userType,new String[]{"首页"});
                                break;
                            case R.id.navi_menu_2:
                               // ToastUtil.show("安全管理");
                                break;
                            case R.id.navi_menu_3:
                               // ToastUtil.show("退出账户");
                                break;
                            case R.id.navi_menu_4:
                                // ToastUtil.show("退出账户");
                                break;
                            case R.id.navi_menu_5:
                                // ToastUtil.show("退出账户");
                                break;
                            case R.id.navi_menu_6:
                                // ToastUtil.show("退出账户");
                                break;
                        }
                        return true;
                    }
                });

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }

      /*  naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navi_menu_1:
                        ToastUtil.show("监督人员首页");
                        item.setChecked(true);
                        break;
                    case R.id.navi_menu_2:
                        ToastUtil.show("监管人员中心");
                        item.setChecked(true);
                        break;
                    case R.id.navi_menu_3:
                        ToastUtil.show("培训学习");
                        item.setChecked(true);
                        startActivity(new Intent(MainActivity.this, PeiXunActivity.class));
                        break;
                    case R.id.navi_menu_4:
                        ToastUtil.show("企业管理");
                        item.setChecked(true);
                        break;
                    case R.id.navi_menu_5:
                        ToastUtil.show("监管统计");
                        item.setChecked(true);
                        break;
                    case R.id.navi_menu_6:
                        ToastUtil.show("体检信息");
                        item.setChecked(true);
                        break;
                    case R.id.navi_menu_7:
                        ToastUtil.show("下载中心");
                        item.setChecked(true);
                        break;
                    case R.id.navi_menu_8:
                        ToastUtil.show("安全设置");
                        item.setChecked(true);
                        break;
                }
                item.setChecked(true);
                //drawer.closeDrawers();
                return true;
            }
        });*/
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
        switch (userType){
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
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
