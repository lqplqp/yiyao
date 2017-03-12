package com.lxkj.yiyao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lxkj.yiyao.activity.LoginActivity;
import com.lxkj.yiyao.adapter.VPFAdapter;
import com.lxkj.yiyao.adapter.VPFAdapter2;
import com.lxkj.yiyao.jianguan.CompanyManagerFragment;
import com.lxkj.yiyao.jianguan.JGCompanyManFragment;
import com.lxkj.yiyao.jianguan.JGUpdatePswFragment;
import com.lxkj.yiyao.jianguan.LawManagerFragment;
import com.lxkj.yiyao.jianguan.QiyeInfoCardFragment;
import com.lxkj.yiyao.jianguan.UserManagerFragment;
import com.lxkj.yiyao.qiye.QYHomeFragment;
import com.lxkj.yiyao.qiye.QYInfoInputFragment;
import com.lxkj.yiyao.qiye.QYInfocardManagerFragment;
import com.lxkj.yiyao.qiye.QYMessageSearchFragment;
import com.lxkj.yiyao.qiye.QYPersonManagerFragment;
import com.lxkj.yiyao.qiye.QYTrainOrderFragment;
import com.lxkj.yiyao.shengji.CompanyTongJiFragment;
import com.lxkj.yiyao.shengji.DownloadDocFragment;
import com.lxkj.yiyao.shengji.JianGuanTongJiFragment;
import com.lxkj.yiyao.shengji.PersonAnalysisFragment;
import com.lxkj.yiyao.shengji.ShenHeFragment;
import com.lxkj.yiyao.shengji.TiJianSearchFragment;
import com.lxkj.yiyao.shengji.TiJianTongJiFragment;
import com.lxkj.yiyao.shengji.UpdatePswFragment;
import com.lxkj.yiyao.shengjugeren.SJGRBaoMingMessageFragment;
import com.lxkj.yiyao.shengjugeren.SJGRCompanyInfoListFragment;
import com.lxkj.yiyao.shengjugeren.SJGRCompanyTongJiFragment;
import com.lxkj.yiyao.shengjugeren.SJGRDownloadDocFragment;
import com.lxkj.yiyao.shengjugeren.SJGRJianGuanTongJiFragment;
import com.lxkj.yiyao.shengjugeren.SJGRMessageFragment;
import com.lxkj.yiyao.shengjugeren.SJGRMessageSearchFragment;
import com.lxkj.yiyao.shengjugeren.SJGRPersonAnalysisFragment;
import com.lxkj.yiyao.shengjugeren.SJGRPersonManagerAddFragment;
import com.lxkj.yiyao.shengjugeren.SJGRTiJianSearchFragment;
import com.lxkj.yiyao.shengjugeren.SJGRTiJianTongJiFragment;
import com.lxkj.yiyao.shengjugeren.SJGRUpdatePswFragment;
import com.lxkj.yiyao.shengjugeren.SJGRYiBaoPeiXunXiangMuFragment;
import com.lxkj.yiyao.shengjugeren.SJGRZhiFaSerachFragment;
import com.lxkj.yiyao.shiji.AdminManagerFragment;
import com.lxkj.yiyao.shiji.CompanyManageyFragment;
import com.lxkj.yiyao.shiji.HomeFragment;
import com.lxkj.yiyao.shiji.MessageSearchFragment;
import com.lxkj.yiyao.shiji.PeiXunListFragment;
import com.lxkj.yiyao.shiji.ProjectApplyFragment;
import com.lxkj.yiyao.shiji.QiYeInfoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

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
    @BindView(R.id.sanheng)
    ImageView sanheng;
    @BindView(R.id.toolbar_head)
    CircleImageView toolbarHead;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.user_name)
    TextView userName;


    private String user_name;


    private String[] shengjiTabTitles = {"首页", "审核"};
    private ActionBarDrawerToggle drawerToggle;
    private int userType;
    private VPFAdapter vpfAdapter;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] pagerTitles;
    private VPFAdapter2 vpfAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        initData();
        initView();
    }


    private void logOut() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    private void setTitle(String title) {
        titleTv.setText(title);
    }

    private void initView() {
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawerToggle.syncState();
        drawer.setDrawerListener(drawerToggle);
        sanheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(naviView);
            }
        });

        switch (userType) {
            /**
             * 增加监管
             */
            case 0:
                fragments.clear();
                pagerTitles = getResources().getStringArray(R.array.zengjiajianguan0);
                com.lxkj.yiyao.jianguan.HomeFragment homeFragment = new com.lxkj.yiyao.jianguan.HomeFragment();
                UserManagerFragment userManagerFragment = new UserManagerFragment();
                CompanyManagerFragment companyManagerFragment = new CompanyManagerFragment();
                QiyeInfoCardFragment qiyeInfoCardFragment = new QiyeInfoCardFragment();
                JGCompanyManFragment jgCompanyManFragment = new JGCompanyManFragment();
                LawManagerFragment lawManagerFragment = new LawManagerFragment();
                fragments.add(homeFragment);
                fragments.add(userManagerFragment);
                fragments.add(companyManagerFragment);
                fragments.add(qiyeInfoCardFragment);
                fragments.add(jgCompanyManFragment);
                fragments.add(lawManagerFragment);
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_jianguan);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        fragments.clear();
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.navi_menu_1:
                                setTitle("菜单");
                                pagerTitles = getResources().getStringArray(R.array.zengjiajianguan0);
                                com.lxkj.yiyao.jianguan.HomeFragment homeFragment = new com.lxkj.yiyao.jianguan.HomeFragment();
                                UserManagerFragment userManagerFragment = new UserManagerFragment();
                                CompanyManagerFragment companyManagerFragment = new CompanyManagerFragment();
                                QiyeInfoCardFragment qiyeInfoCardFragment = new QiyeInfoCardFragment();
                                JGCompanyManFragment jgCompanyManFragment = new JGCompanyManFragment();
                                LawManagerFragment lawManagerFragment = new LawManagerFragment();
                                fragments.add(homeFragment);
                                fragments.add(userManagerFragment);
                                fragments.add(companyManagerFragment);
                                fragments.add(qiyeInfoCardFragment);
                                fragments.add(jgCompanyManFragment);
                                fragments.add(lawManagerFragment);
                                break;
                            case R.id.navi_menu_2:
                                setTitle("安全设置");
                                pagerTitles = getResources().getStringArray(R.array.zengjiajianguan0);
                                JGUpdatePswFragment sjgrUpdatePswFragment = new JGUpdatePswFragment();
                                fragments.add(sjgrUpdatePswFragment);
                                break;
                            case R.id.navi_menu_logout:
                                logOut();
                                break;
                        }
                        vpfAdapter2.setData(fragments, pagerTitles);
                        drawer.closeDrawers();
                        return true;
                    }
                });
                break;
            /**
             * 省局管理员
             */
            case 1:
                fragments.clear();
                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan0);
                com.lxkj.yiyao.shengji.HomeFragment homeFragment3 = new com.lxkj.yiyao.shengji.HomeFragment();
                fragments.add(homeFragment3);
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_shengjuadmin);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        fragments.clear();
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.navi_menu_1:
                                setTitle("菜单");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan0);
                                com.lxkj.yiyao.shengji.HomeFragment homeFragment = new com.lxkj.yiyao.shengji.HomeFragment();
                                fragments.add(homeFragment);
                                break;
                            case R.id.navi_menu_2:
                                setTitle("监管单位管理");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan1);
                                //监管单位信息
                                com.lxkj.yiyao.shengji.CompanyManageyFragment companyManageyFragment = new com.lxkj.yiyao.shengji.CompanyManageyFragment();
                                //监管人员管理
                                com.lxkj.yiyao.shengji.AdminManagerFragment adminManagerFragment = new com.lxkj.yiyao.shengji.AdminManagerFragment();
                                fragments.add(companyManageyFragment);
                                fragments.add(adminManagerFragment);
                                break;
                            case R.id.navi_menu_3:
                                setTitle("培训通知管理");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan2);
                                //培训通知列表
                                com.lxkj.yiyao.shengji.SJGRMessageSearchFragment sjgrMessageSearchFragment = new com.lxkj.yiyao.shengji.SJGRMessageSearchFragment();
                                fragments.add(sjgrMessageSearchFragment);
                                break;
                            case R.id.navi_menu_4:
                                setTitle("体检机构审核");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan3);
                                ShenHeFragment shenHeFragment = new ShenHeFragment();
                                fragments.add(shenHeFragment);
                                break;
                            case R.id.navi_menu_5:
                                setTitle("企业管理");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan4);
                                //企业信息列表
                                com.lxkj.yiyao.shengji.SJGRCompanyInfoListFragment sjgrCompanyInfoListFragment = new com.lxkj.yiyao.shengji.SJGRCompanyInfoListFragment();
                                fragments.add(sjgrCompanyInfoListFragment);
                                break;
                            case R.id.navi_menu_6:
                                setTitle("培训报名");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan5);
                                //培训项目报名
                                com.lxkj.yiyao.shengji.ProjectApplyFragment projectApplyFragment = new com.lxkj.yiyao.shengji.ProjectApplyFragment();
                                //已报培训项目
                                com.lxkj.yiyao.shengji.PeiXunListFragment peiXunListFragment = new com.lxkj.yiyao.shengji.PeiXunListFragment();
                                //通知消息
                                com.lxkj.yiyao.shengji.MessageSearchFragment messageSearchFragment = new com.lxkj.yiyao.shengji.MessageSearchFragment();
                                fragments.add(projectApplyFragment);
                                fragments.add(peiXunListFragment);
                                fragments.add(messageSearchFragment);
                                break;
                            case R.id.navi_menu_7:
                                setTitle("监管统计");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan6);
                                //监管单位统计分析
                                JianGuanTongJiFragment sjgrJianGuanTongJiFragment = new JianGuanTongJiFragment();
                                //执法记录统计分析 待定
                                JianGuanTongJiFragment sjgrJianGuanTongJiFragment1 = new JianGuanTongJiFragment();
                                //企业用户统计分析
                                CompanyTongJiFragment sjgrCompanyTongJiFragment = new CompanyTongJiFragment();
                                //个人用户统计分析
                                PersonAnalysisFragment sjgrPersonAnalysisFragment = new PersonAnalysisFragment();
                                fragments.add(sjgrJianGuanTongJiFragment);
                                fragments.add(sjgrJianGuanTongJiFragment1);
                                fragments.add(sjgrCompanyTongJiFragment);
                                fragments.add(sjgrPersonAnalysisFragment);
                                break;
                            case R.id.navi_menu_8:
                                setTitle("体检信息");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan7);
                                //体检统计
                                TiJianTongJiFragment sjgrTiJianTongJiFragment = new TiJianTongJiFragment();
                                //体检查询
                                TiJianSearchFragment sjgrTiJianSearchFragment = new TiJianSearchFragment();
                                fragments.add(sjgrTiJianTongJiFragment);
                                fragments.add(sjgrTiJianSearchFragment);
                                break;
                            case R.id.navi_menu_9:
                                setTitle("下载中心");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan8);
                                //法律法规文档下载
                                DownloadDocFragment sjgrDownloadDocFragment = new DownloadDocFragment();
                                //应用模板下载  待定
                                DownloadDocFragment sjgrDownloadDocFragment1 = new DownloadDocFragment();
                                //应用插件下载  待定
                                DownloadDocFragment sjgrDownloadDocFragment2 = new DownloadDocFragment();
                                //其他相关下载  待定
                                DownloadDocFragment sjgrDownloadDocFragment3 = new DownloadDocFragment();
                                fragments.add(sjgrDownloadDocFragment);
                                fragments.add(sjgrDownloadDocFragment1);
                                fragments.add(sjgrDownloadDocFragment2);
                                fragments.add(sjgrDownloadDocFragment3);
                                break;
                            case R.id.navi_menu_10:
                                setTitle("安全设置");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan9);
                                //安全设置
                                JGUpdatePswFragment sjgrUpdatePswFragment = new JGUpdatePswFragment();
                                fragments.add(sjgrUpdatePswFragment);
                                break;
                            case R.id.navi_menu_logout:
                                logOut();
                                break;
                        }
                        vpfAdapter2.setData(fragments, pagerTitles);
                        drawer.closeDrawers();
                        return true;
                    }
                });
                break;
            /**
             * 省局个人
             */
            case 2:
                fragments.clear();
                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan0);
                //省局个人首页
                SJGRMessageFragment sjgrMessageFragment = new SJGRMessageFragment();
                fragments.add(sjgrMessageFragment);
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_shiji);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        fragments.clear();
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.navi_menu_1:
                                setTitle("菜单");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren0);
                                //省局个人首页
                                SJGRMessageFragment sjgrMessageFragment = new SJGRMessageFragment();
                                fragments.add(sjgrMessageFragment);
                                break;
                            case R.id.navi_menu_2:
                                setTitle("监管单位管理");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren1);
                                //监管人员信息
                                SJGRPersonManagerAddFragment sjgrPersonManagerAddFragment = new SJGRPersonManagerAddFragment();
                                //我的证书  待定
                                SJGRPersonManagerAddFragment sjgrPersonManagerAddFragment1 = new SJGRPersonManagerAddFragment();
                                //我的执法
                                SJGRZhiFaSerachFragment sjgrZhiFaSerachFragment = new SJGRZhiFaSerachFragment();
                                //通知消息 查询
                                SJGRMessageSearchFragment sjgrMessageSearchFragment = new SJGRMessageSearchFragment();
                                fragments.add(sjgrPersonManagerAddFragment);
                                fragments.add(sjgrPersonManagerAddFragment1);
                                fragments.add(sjgrZhiFaSerachFragment);
                                fragments.add(sjgrMessageSearchFragment);
                                break;
                            case R.id.navi_menu_3:
                                setTitle("培训通知管理");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren2);
                                //已报培训项目
                                SJGRYiBaoPeiXunXiangMuFragment sjgrYiBaoPeiXunXiangMuFragment = new SJGRYiBaoPeiXunXiangMuFragment();
                                fragments.add(sjgrYiBaoPeiXunXiangMuFragment);
                                break;
                            case R.id.navi_menu_4:
                                setTitle("企业管理");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren3);
                                //企业信息列表
                                SJGRCompanyInfoListFragment sjgrCompanyInfoListFragment = new SJGRCompanyInfoListFragment();
                                //企业报名信息
                                SJGRBaoMingMessageFragment sjgrBaoMingMessageFragment = new SJGRBaoMingMessageFragment();
                                fragments.add(sjgrCompanyInfoListFragment);
                                fragments.add(sjgrBaoMingMessageFragment);
                                break;
                            case R.id.navi_menu_5:
                                setTitle("培训报名");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren3);
                                //企业信息列表
                                SJGRCompanyInfoListFragment sjgrCompanyInfoListFragment2 = new SJGRCompanyInfoListFragment();
                                //企业报名信息
                                SJGRBaoMingMessageFragment sjgrBaoMingMessageFragment2 = new SJGRBaoMingMessageFragment();
                                fragments.add(sjgrCompanyInfoListFragment2);
                                fragments.add(sjgrBaoMingMessageFragment2);
                                break;
                            case R.id.navi_menu_6:
                                setTitle("监管统计");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren4);
                                //监管单位统计分析
                                SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment = new SJGRJianGuanTongJiFragment();
                                //执法记录统计分析 待定
                                SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment1 = new SJGRJianGuanTongJiFragment();
                                //企业用户统计分析
                                SJGRCompanyTongJiFragment sjgrCompanyTongJiFragment = new SJGRCompanyTongJiFragment();
                                //个人用户统计分析
                                SJGRPersonAnalysisFragment sjgrPersonAnalysisFragment = new SJGRPersonAnalysisFragment();
                                fragments.add(sjgrJianGuanTongJiFragment);
                                fragments.add(sjgrJianGuanTongJiFragment1);
                                fragments.add(sjgrCompanyTongJiFragment);
                                fragments.add(sjgrPersonAnalysisFragment);
                                break;
                            case R.id.navi_menu_7:
                                setTitle("体检信息");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren5);
                                //体检统计
                                SJGRTiJianTongJiFragment sjgrTiJianTongJiFragment = new SJGRTiJianTongJiFragment();
                                //体检查询
                                SJGRTiJianSearchFragment sjgrTiJianSearchFragment = new SJGRTiJianSearchFragment();
                                fragments.add(sjgrTiJianTongJiFragment);
                                fragments.add(sjgrTiJianSearchFragment);
                                break;
                            case R.id.navi_menu_8:
                                setTitle("下载中心");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren6);
                                //法律法规文档下载
                                SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                                //应用模板下载  待定
                                SJGRDownloadDocFragment sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment();
                                //应用插件下载  待定
                                SJGRDownloadDocFragment sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment();
                                //其他相关下载  待定
                                SJGRDownloadDocFragment sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment();
                                fragments.add(sjgrDownloadDocFragment);
                                fragments.add(sjgrDownloadDocFragment1);
                                fragments.add(sjgrDownloadDocFragment2);
                                fragments.add(sjgrDownloadDocFragment3);
                                break;
                            case R.id.navi_menu_9:
                                setTitle("安全设置");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren7);
                                //安全设置
                                JGUpdatePswFragment sjgrUpdatePswFragment = new JGUpdatePswFragment();
                                fragments.add(sjgrUpdatePswFragment);
                                break;
                            case R.id.navi_menu_10:
                                setTitle("安全设置");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren7);
                                //安全设置
                                SJGRUpdatePswFragment sjgrUpdatePswFragment3 = new SJGRUpdatePswFragment();
                                fragments.add(sjgrUpdatePswFragment3);
                                break;
                            case R.id.navi_menu_logout:
                                logOut();
                                break;
                        }
                        vpfAdapter2.setData(fragments, pagerTitles);
                        drawer.closeDrawers();
                        return true;
                    }
                });
                break;
            /**
             * 市级管理员
             */
            case 3:
                fragments.clear();
                pagerTitles = getResources().getStringArray(R.array.shiji0);
                HomeFragment homeFragment2 = new HomeFragment();
                fragments.add(homeFragment2);
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_shiji);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        fragments.clear();
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.navi_menu_1:
                                setTitle("菜单");
                                pagerTitles = getResources().getStringArray(R.array.shiji0);
                                HomeFragment homeFragment = new HomeFragment();
                                fragments.add(homeFragment);
                                break;
                            case R.id.navi_menu_2:
                                setTitle("监管单位管理");
                                pagerTitles = getResources().getStringArray(R.array.shiji1);
                                CompanyManageyFragment companyManageyFragment = new CompanyManageyFragment();
                                AdminManagerFragment adminManagerFragment = new AdminManagerFragment();
                                fragments.add(companyManageyFragment);
                                fragments.add(adminManagerFragment);
                                break;
                            case R.id.navi_menu_3:
                                setTitle("培训通知管理");
                                pagerTitles = getResources().getStringArray(R.array.shiji2);
                                PeiXunListFragment peiXunListFragment = new PeiXunListFragment();
                                fragments.add(peiXunListFragment);
                                break;
                            case R.id.navi_menu_4:
                                setTitle("企业管理");
                                pagerTitles = getResources().getStringArray(R.array.shiji3);
                                QiYeInfoFragment qiYeInfoFragment = new QiYeInfoFragment();
                                fragments.add(qiYeInfoFragment);
                                break;
                            case R.id.navi_menu_5:
                                setTitle("培训报名");
                                pagerTitles = getResources().getStringArray(R.array.shiji4);
                                ProjectApplyFragment projectApplyFragment = new ProjectApplyFragment();
                                PeiXunListFragment peiXunListFragment1 = new PeiXunListFragment();
                                MessageSearchFragment messageSearchFragment = new MessageSearchFragment();
                                fragments.add(projectApplyFragment);
                                fragments.add(peiXunListFragment1);
                                fragments.add(messageSearchFragment);
                                break;
                            case R.id.navi_menu_6:
                                setTitle("监管统计");
                                pagerTitles = getResources().getStringArray(R.array.shiji5);
                                //监管单位统计分析
                                SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment = new SJGRJianGuanTongJiFragment();
                                //执法记录统计分析 待定
                                SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment1 = new SJGRJianGuanTongJiFragment();
                                //企业用户统计分析
                                SJGRCompanyTongJiFragment sjgrCompanyTongJiFragment = new SJGRCompanyTongJiFragment();
                                //个人用户统计分析
                                SJGRPersonAnalysisFragment sjgrPersonAnalysisFragment = new SJGRPersonAnalysisFragment();
                                fragments.add(sjgrJianGuanTongJiFragment);
                                fragments.add(sjgrJianGuanTongJiFragment1);
                                fragments.add(sjgrCompanyTongJiFragment);
                                fragments.add(sjgrPersonAnalysisFragment);
                                break;
                            case R.id.navi_menu_7:
                                setTitle("体检信息");
                                pagerTitles = getResources().getStringArray(R.array.shiji6);
                                //体检统计
                                SJGRTiJianTongJiFragment sjgrTiJianTongJiFragment = new SJGRTiJianTongJiFragment();
                                //体检查询
                                SJGRTiJianSearchFragment sjgrTiJianSearchFragment = new SJGRTiJianSearchFragment();
                                fragments.add(sjgrTiJianTongJiFragment);
                                fragments.add(sjgrTiJianSearchFragment);
                                break;
                            case R.id.navi_menu_8:
                                setTitle("下载中心");
                                pagerTitles = getResources().getStringArray(R.array.shiji7);
                                //法律法规文档下载
                                SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                                //应用模板下载  待定
                                SJGRDownloadDocFragment sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment();
                                //应用插件下载  待定
                                SJGRDownloadDocFragment sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment();
                                //其他相关下载  待定
                                SJGRDownloadDocFragment sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment();
                                fragments.add(sjgrDownloadDocFragment);
                                fragments.add(sjgrDownloadDocFragment1);
                                fragments.add(sjgrDownloadDocFragment2);
                                fragments.add(sjgrDownloadDocFragment3);
                                break;
                            case R.id.navi_menu_9:
                                setTitle("安全设置");
                                pagerTitles = getResources().getStringArray(R.array.shiji8);
                                //安全设置
                                JGUpdatePswFragment sjgrUpdatePswFragment = new JGUpdatePswFragment();
                                fragments.add(sjgrUpdatePswFragment);
                                break;
                            case R.id.navi_menu_logout:
                                logOut();
                                break;
                        }
                        vpfAdapter2.setData(fragments, pagerTitles);
                        drawer.closeDrawers();
                        return true;
                    }
                });
                break;
            /**
             * 企业管理员
             */
            case 4:
                qiye();
                break;
            /**
             * 县级管理员
             */
            case 5:
                qiye();
                /*fragments.clear();
                pagerTitles = getResources().getStringArray(R.array.qiye0);
                QYHomeFragment qyHomeFragment1 = new QYHomeFragment();
                fragments.add(qyHomeFragment1);
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_qiye);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        fragments.clear();
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.navi_menu_1:
                                setTitle("菜单");
                                pagerTitles = getResources().getStringArray(R.array.qiye0);
                                QYHomeFragment qyHomeFragment = new QYHomeFragment();
                                fragments.add(qyHomeFragment);
                                break;
                            case R.id.navi_menu_2:
                                setTitle("企业管理");
                                pagerTitles = getResources().getStringArray(R.array.qiye1);
                                QYInfoInputFragment qyInfoInputFragment = new QYInfoInputFragment();
                                fragments.add(qyInfoInputFragment);
                                QYPersonManagerFragment qyPersonManagerFragment = new QYPersonManagerFragment();
                                fragments.add(qyPersonManagerFragment);
                                QYPersonManagerFragment qyPersonManagerFragment1 = new QYPersonManagerFragment();
                                fragments.add(qyPersonManagerFragment1);
                                QYInfocardManagerFragment qyInfocardManagerFragment = new QYInfocardManagerFragment();
                                fragments.add(qyInfocardManagerFragment);
                                break;
                            case R.id.navi_menu_3:
                                setTitle("培训报名");
                                pagerTitles = getResources().getStringArray(R.array.qiye2);
                                ProjectApplyFragment projectApplyFragment = new ProjectApplyFragment();
                                fragments.add(projectApplyFragment);
                                QYTrainOrderFragment qyTrainOrderFragment = new QYTrainOrderFragment();
                                fragments.add(qyTrainOrderFragment);
                                PeiXunListFragment peiXunListFragment = new PeiXunListFragment();
                                fragments.add(peiXunListFragment);
                                MessageSearchFragment messageSearchFragment = new MessageSearchFragment();
                                fragments.add(messageSearchFragment);
                                break;
                            case R.id.navi_menu_4:
                                setTitle("下载中心");
                                pagerTitles = getResources().getStringArray(R.array.qiye3);
                                SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                                SJGRDownloadDocFragment sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment();
                                SJGRDownloadDocFragment sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment();
                                SJGRDownloadDocFragment sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment();
                                fragments.add(sjgrDownloadDocFragment);
                                fragments.add(sjgrDownloadDocFragment1);
                                fragments.add(sjgrDownloadDocFragment2);
                                fragments.add(sjgrDownloadDocFragment3);
                                break;
                            case R.id.navi_menu_5:
                                setTitle("安全设置");
                                pagerTitles = getResources().getStringArray(R.array.qiye4);
                                SJGRUpdatePswFragment sjgrUpdatePswFragment = new SJGRUpdatePswFragment();
                                fragments.add(sjgrUpdatePswFragment);
                                break;
                            case R.id.navi_menu_logout:
                                logOut();
                                break;
                        }
                        vpfAdapter2.setData(fragments, pagerTitles);
                        drawer.closeDrawers();
                        return true;
                    }
                });*/
                break;

        }
    }
    private void qiye(){
        fragments.clear();
        pagerTitles = getResources().getStringArray(R.array.qiye0);
        QYHomeFragment qyHomeFragment = new QYHomeFragment();
        fragments.add(qyHomeFragment);
        setVP();
        naviView.inflateMenu(R.menu.navi_menu_qiye);
        naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                fragments.clear();
                int id = item.getItemId();
                switch (id) {
                    case R.id.navi_menu_1:
                        setTitle("菜单");
                        pagerTitles = getResources().getStringArray(R.array.qiye0);
                        QYHomeFragment qyHomeFragment = new QYHomeFragment();
                        fragments.add(qyHomeFragment);
                        break;
                    case R.id.navi_menu_2:
                        setTitle("企业管理");
                        pagerTitles = getResources().getStringArray(R.array.qiye1);
                        QYInfoInputFragment qyInfoInputFragment = new QYInfoInputFragment();
                        fragments.add(qyInfoInputFragment);
                        QYPersonManagerFragment qyPersonManagerFragment = new QYPersonManagerFragment();
                        fragments.add(qyPersonManagerFragment);
                        QYPersonManagerFragment qyPersonManagerFragment1 = new QYPersonManagerFragment();
                        fragments.add(qyPersonManagerFragment1);
                        QYInfocardManagerFragment qyInfocardManagerFragment = new QYInfocardManagerFragment();
                        fragments.add(qyInfocardManagerFragment);
                        break;
                    case R.id.navi_menu_3:
                        setTitle("培训报名");
                        pagerTitles = getResources().getStringArray(R.array.qiye2);
                        ProjectApplyFragment projectApplyFragment = new ProjectApplyFragment();
                        fragments.add(projectApplyFragment);
                        QYTrainOrderFragment qyTrainOrderFragment = new QYTrainOrderFragment();
                        fragments.add(qyTrainOrderFragment);
                        PeiXunListFragment peiXunListFragment = new PeiXunListFragment();
                        fragments.add(peiXunListFragment);
                        QYMessageSearchFragment messageSearchFragment = new QYMessageSearchFragment();
                        fragments.add(messageSearchFragment);
                        break;
                    case R.id.navi_menu_4:
                        setTitle("下载中心");
                        pagerTitles = getResources().getStringArray(R.array.qiye3);
                        SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                        SJGRDownloadDocFragment sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment();
                        SJGRDownloadDocFragment sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment();
                        SJGRDownloadDocFragment sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment();
                        fragments.add(sjgrDownloadDocFragment);
                        fragments.add(sjgrDownloadDocFragment1);
                        fragments.add(sjgrDownloadDocFragment2);
                        fragments.add(sjgrDownloadDocFragment3);
                        break;
                    case R.id.navi_menu_5:
                        setTitle("安全设置");
                        pagerTitles = getResources().getStringArray(R.array.qiye4);
                        JGUpdatePswFragment sjgrUpdatePswFragment = new JGUpdatePswFragment();

                        fragments.add(sjgrUpdatePswFragment);
                        break;
                    case R.id.navi_menu_logout:
                        logOut();
                        break;
                }
                vpfAdapter2.setData(fragments, pagerTitles);
                drawer.closeDrawers();
                return true;
            }
        });
    }

    private void setVP() {
        vpfAdapter2 = new VPFAdapter2(getSupportFragmentManager(), fragments, pagerTitles);
        viewPager.setAdapter(vpfAdapter2);
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



    String user_dep;
    String user_img;

    private void initData() {
        userType = getIntent().getIntExtra("userType", 0);
        user_name = getIntent().getStringExtra("user_name");
        user_dep = getIntent().getStringExtra("user_dep");
        user_img = getIntent().getStringExtra("user_img");


        View mRootView = naviView.getHeaderView(0);
        CircleImageView circleImageView = (CircleImageView) mRootView.findViewById(R.id.user_head);
        TextView username_tv = (TextView) mRootView.findViewById(R.id.username_tv);
        TextView name_tv = (TextView) mRootView.findViewById(R.id.name_tv);
        TextView unit_name_tv = (TextView) mRootView.findViewById(R.id.unit_name_tv);

        username_tv.setText(user_name);
        name_tv.setText(user_name);
        unit_name_tv.setText(user_dep);

        Glide.with(this).load(user_img).into(circleImageView);
        userName.setText(user_name);
        Glide.with(this).load(user_img).into(toolbarHead);


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
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
