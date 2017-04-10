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
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.lxkj.yiyao.activity.GeRenScannerQrCodeActivity;
import com.lxkj.yiyao.activity.LoginActivity;
import com.lxkj.yiyao.activity.ScannerQrCodeActivity;
import com.lxkj.yiyao.adapter.VPFAdapter;
import com.lxkj.yiyao.adapter.VPFAdapter2;
import com.lxkj.yiyao.gerenyonghu.GeRenPeiXunListFragment;
import com.lxkj.yiyao.gerenyonghu.GeRenYongHuAnQuanSheZhiFragment;
import com.lxkj.yiyao.gerenyonghu.GeRenYongHuQiTaXiaZaiFragment;
import com.lxkj.yiyao.gerenyonghu.GeRenYongHuShouYeFragment;
import com.lxkj.yiyao.gerenyonghu.GeRenYongHuTiJianBaoGaoFragment;
import com.lxkj.yiyao.gerenyonghu.GeRenYongHuWenDangXiaZaiFragment;
import com.lxkj.yiyao.gerenyonghu.GeRenYongHuXinXiKaFargment;
import com.lxkj.yiyao.gerenyonghu.GeRenYongHuYongHuXinXiFragment;
import com.lxkj.yiyao.gerenyonghu.GeRenYongHuZhengShuFragment;
import com.lxkj.yiyao.gerenyonghu.GeRenYongYingYongChaJianXiaZaiFragment;
import com.lxkj.yiyao.jianguan.CompanyManagerFragment;
import com.lxkj.yiyao.jianguan.JGCompanyManFragment;
import com.lxkj.yiyao.jianguan.JGUpdatePswFragment;
import com.lxkj.yiyao.jianguan.LawManagerFragment;
import com.lxkj.yiyao.jianguan.QiyeInfoCardFragment;
import com.lxkj.yiyao.jianguan.SelectTrainFragment;
import com.lxkj.yiyao.jianguan.UserManagerFragment;
import com.lxkj.yiyao.qiye.QYHomeFragment;
import com.lxkj.yiyao.qiye.QYInfoInputFragment;
import com.lxkj.yiyao.qiye.QYInfocardManagerFragment;
import com.lxkj.yiyao.qiye.QYMessageSearchFragment;
import com.lxkj.yiyao.qiye.QYPersonManagerFragment;
import com.lxkj.yiyao.qiye.QYTrainOrderFragment;
import com.lxkj.yiyao.shengji.JianGuanTongJiFragment;
import com.lxkj.yiyao.shengji.PersonAnalysisFragment;
import com.lxkj.yiyao.shengji.QiYeYongHuTongJiFragment;
import com.lxkj.yiyao.shengji.ShenHeFragment;
import com.lxkj.yiyao.shengji.ShengJiPeiXunMessageSearchFragment;
import com.lxkj.yiyao.shengji.ShengJiYiBaoPeiXunListFragment;
import com.lxkj.yiyao.shengji.ShengjiQiYeGuanLiFragment;
import com.lxkj.yiyao.shengji.TiJianSearchFragment;
import com.lxkj.yiyao.shengji.TiJianTongJiFragment;
import com.lxkj.yiyao.shengji.ZhiFaJiLuTongJiFragment;
import com.lxkj.yiyao.shengjugeren.SJGJZhiFaJILuFenXiTongJiFragment;
import com.lxkj.yiyao.shengjugeren.SJGRBaoMingMessageFragment;
import com.lxkj.yiyao.shengjugeren.SJGRCompanyInfoListFragment;
import com.lxkj.yiyao.shengjugeren.SJGRCompanyTongJiFragment;
import com.lxkj.yiyao.shengjugeren.SJGRDownloadDocFragment;
import com.lxkj.yiyao.shengjugeren.SJGRDownloadDocFragment2;
import com.lxkj.yiyao.shengjugeren.SJGRDownloadDocFragment3;
import com.lxkj.yiyao.shengjugeren.SJGRDownloadDocFragment4;
import com.lxkj.yiyao.shengjugeren.SJGRJianGuanTongJiFragment;
import com.lxkj.yiyao.shengjugeren.SJGRMessageFragment;
import com.lxkj.yiyao.shengjugeren.SJGRMessageSearchFragment;
import com.lxkj.yiyao.shengjugeren.SJGRPersonAnalysisFragment;
import com.lxkj.yiyao.shengjugeren.SJGRPersonManagerAddFragment;
import com.lxkj.yiyao.shengjugeren.SJGRTiJianSearchFragment;
import com.lxkj.yiyao.shengjugeren.SJGRTiJianTongJiFragment;
import com.lxkj.yiyao.shengjugeren.SJGRYiBaoPeiXunXiangMuFragment;
import com.lxkj.yiyao.shengjugeren.SJGRZhengShuFragment;
import com.lxkj.yiyao.shengjugeren.SJGRZhiFaSerachFragment;
import com.lxkj.yiyao.shiji.AdminManagerFragment;
import com.lxkj.yiyao.shiji.CompanyManageyFragment;
import com.lxkj.yiyao.shiji.HomeFragment;
import com.lxkj.yiyao.shiji.MessageSearchFragment;
import com.lxkj.yiyao.shiji.PeiXunListFragment;
import com.lxkj.yiyao.shiji.ShiJiJiYiBaoPeiXunListFragment;
import com.lxkj.yiyao.shiji.ShiJiJianGuanTongJiFragment;
import com.lxkj.yiyao.shiji.ShiJiPeiXunMessageSearchFragment;
import com.lxkj.yiyao.shiji.ShiJiQiYeGuanLiFragment;
import com.lxkj.yiyao.shiji.ShiJiQiYeYongHuTongJiFragment;
import com.lxkj.yiyao.shiji.ShiJiTiJianSearchFragment;
import com.lxkj.yiyao.shiji.ShiJiTiJianTongJiFragment;
import com.lxkj.yiyao.shiji.ShiJiZhiFaJiLuTongJiFragment;
import com.lxkj.yiyao.xianji.QYManagerHomeFragment;
import com.lxkj.yiyao.xianji.QYManagerTiJianBaoGaoFragment;
import com.lxkj.yiyao.xianji.XianJiMessageSearchFragment;
import com.lxkj.yiyao.xianji.XianJiXinXiKaFargment;
import com.lxkj.yiyao.xianji.XianJiYongHuXinXiFragment;
import com.lxkj.yiyao.xianji.XianJiYongHuZhengShuFragment;
import com.lxkj.yiyao.xianji.XianJiYonghuTiJianBaoGaoFragment;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.view_pager)
    ViewPager  viewPager;
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

        /*Intent intent = new Intent(this, QiYeZhiFaActivity.class);
        startActivity(intent);*/


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

        /**
         * 测试考试用
         */
        /*titleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExamActivity.class);
                startActivity(intent);
            }
        });*/

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
                               //首页
                                com.lxkj.yiyao.jianguan.HomeFragment homeFragment = new com.lxkj.yiyao.jianguan.HomeFragment();
                               //个人用户管理
                                UserManagerFragment userManagerFragment = new UserManagerFragment();
                               //企业管理
                                CompanyManagerFragment companyManagerFragment = new CompanyManagerFragment();
                               //信息卡管理
                                QiyeInfoCardFragment qiyeInfoCardFragment = new QiyeInfoCardFragment();
                               //监管单位管理
                                JGCompanyManFragment jgCompanyManFragment = new JGCompanyManFragment();
                               //执法记录管理
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
                            /*case R.id.navi_menu_3:
                                setTitle("登录用户添加");
                                pagerTitles = getResources().getStringArray(R.array.zengjiajianguan2);
                                *//*添加管理员*//*
                                JianGuanAddGuanLiYuan jianGuanAddGuanLiYuan = new JianGuanAddGuanLiYuan();
                                *//*添加企业管理员*//*
                                JianGuanAddQiYeGuanLiYuan jianGuanAddQiYeGuanLiYuan = new JianGuanAddQiYeGuanLiYuan();
                                fragments.add(jianGuanAddGuanLiYuan);
                                fragments.add(jianGuanAddQiYeGuanLiYuan);
                                break;*/
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
                                ShengJiPeiXunMessageSearchFragment shengJiPeiXunMessageSearchFragment = new ShengJiPeiXunMessageSearchFragment();
                                fragments.add(shengJiPeiXunMessageSearchFragment);
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
                                ShengjiQiYeGuanLiFragment shengjiQiYeGuanLiFragment = new ShengjiQiYeGuanLiFragment();
                                fragments.add(shengjiQiYeGuanLiFragment);
                                break;
                            case R.id.navi_menu_6:
                                setTitle("培训报名");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan5);
                                //培训项目报名
                                SelectTrainFragment projectApplyFragment = new SelectTrainFragment();
                                //已报培训项目
                                ShengJiYiBaoPeiXunListFragment shengJiYiBaoPeiXunListFragment = new ShengJiYiBaoPeiXunListFragment();
                                //通知消息
                                com.lxkj.yiyao.shengji.MessageSearchFragment messageSearchFragment = new com.lxkj.yiyao.shengji.MessageSearchFragment();
                                fragments.add(projectApplyFragment);
                                fragments.add(shengJiYiBaoPeiXunListFragment);
                                fragments.add(messageSearchFragment);
                                break;
                            case R.id.navi_menu_7:
                                setTitle("监管统计");
                                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan6);
                                //监管单位统计分析
                                JianGuanTongJiFragment jianGuanTongJiFragment = new JianGuanTongJiFragment();
                                //执法记录统计分析 待定
                                ZhiFaJiLuTongJiFragment zhiFaJiLuTongJiFragment = new ZhiFaJiLuTongJiFragment();
                                //企业用户统计分析
                                QiYeYongHuTongJiFragment qiYeYongHuTongJiFragment = new QiYeYongHuTongJiFragment();
                                //个人用户统计分析
                                PersonAnalysisFragment sjgrPersonAnalysisFragment = new PersonAnalysisFragment();
                                fragments.add(jianGuanTongJiFragment);
                                fragments.add(zhiFaJiLuTongJiFragment);
                                fragments.add(qiYeYongHuTongJiFragment);
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
                                //应用模板下载  待定
                                SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                                SJGRDownloadDocFragment2 sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment2();
                                SJGRDownloadDocFragment3 sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment3();
                                SJGRDownloadDocFragment4 sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment4();
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
             * 省局个人  添加执法
             */
            case 2 :
            case 6 :
            case 7 :
                fragments.clear();
                pagerTitles = getResources().getStringArray(R.array.shengjiguanliyuan0);
                //省局个人首页
                SJGRMessageFragment sjgrMessageFragment = new SJGRMessageFragment();
                fragments.add(sjgrMessageFragment);
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_shengjugeren);
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
                                SJGRZhengShuFragment sjgrZhengShuFragment = new SJGRZhengShuFragment();
                               /* SJGRPersonManagerAddFragment sjgrPersonManagerAddFragment1 = new SJGRPersonManagerAddFragment();*/
                                //我的执法
                                SJGRZhiFaSerachFragment sjgrZhiFaSerachFragment = new SJGRZhiFaSerachFragment();
                                //通知消息 查询
                                SJGRMessageSearchFragment sjgrMessageSearchFragment = new SJGRMessageSearchFragment();
                                fragments.add(sjgrPersonManagerAddFragment);
                                fragments.add(sjgrZhengShuFragment);
                                fragments.add(sjgrZhiFaSerachFragment);
                                fragments.add(sjgrMessageSearchFragment);
                                break;
                           /* case R.id.navi_menu_3:
                                setTitle("培训通知管理");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren2);
                                //已报培训项目
                                SJGRYiBaoPeiXunXiangMuFragment sjgrYiBaoPeiXunXiangMuFragment = new SJGRYiBaoPeiXunXiangMuFragment();
                                fragments.add(sjgrYiBaoPeiXunXiangMuFragment);
                                break;*/
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
                                setTitle("培训学习");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren2);
                                //已报培训项目
                                SJGRYiBaoPeiXunXiangMuFragment sjgrYiBaoPeiXunXiangMuFragment = new SJGRYiBaoPeiXunXiangMuFragment();
                                fragments.add(sjgrYiBaoPeiXunXiangMuFragment);
                                break;
                            case R.id.navi_menu_6:
                                setTitle("监管统计");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren4);
                                //监管单位统计分析
                                SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment = new SJGRJianGuanTongJiFragment();
                                //执法记录统计分析
                                SJGJZhiFaJILuFenXiTongJiFragment sjgjZhiFaJILuFenXiTongJiFragment = new SJGJZhiFaJILuFenXiTongJiFragment();
                                /*SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment1 = new SJGRJianGuanTongJiFragment();*/
                                //企业用户统计分析
                                SJGRCompanyTongJiFragment sjgrCompanyTongJiFragment = new SJGRCompanyTongJiFragment();
                                //个人用户统计分析
                                SJGRPersonAnalysisFragment sjgrPersonAnalysisFragment = new SJGRPersonAnalysisFragment();
                                fragments.add(sjgrJianGuanTongJiFragment);
                                fragments.add(sjgjZhiFaJILuFenXiTongJiFragment);
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
                                SJGRDownloadDocFragment2 sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment2();
                                SJGRDownloadDocFragment3 sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment3();
                                SJGRDownloadDocFragment4 sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment4();
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
                                /*setTitle("执法");
                                pagerTitles = getResources().getStringArray(R.array.shengjugeren7);
                                //安全设置
                                SJGRUpdatePswFragment sjgrUpdatePswFragment3 = new SJGRUpdatePswFragment();
                                fragments.add(sjgrUpdatePswFragment3);*/
                                Intent intent = new Intent(MainActivity.this, ScannerQrCodeActivity.class);
                                startActivity(intent);


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
                                //还差行业领域和地址
                                CompanyManageyFragment companyManageyFragment = new CompanyManageyFragment();
                                AdminManagerFragment adminManagerFragment = new AdminManagerFragment();
                                fragments.add(companyManageyFragment);
                                fragments.add(adminManagerFragment);
                                break;
                            case R.id.navi_menu_3:
                                setTitle("培训通知管理");
                                pagerTitles = getResources().getStringArray(R.array.shiji2);
                                ShiJiPeiXunMessageSearchFragment shiJiPeiXunMessageSearchFragment = new ShiJiPeiXunMessageSearchFragment();
                                fragments.add(shiJiPeiXunMessageSearchFragment);
                                break;
                            case R.id.navi_menu_4:
                                setTitle("企业管理");

                                pagerTitles = getResources().getStringArray(R.array.shiji3);
                                ShiJiQiYeGuanLiFragment shiJiQiYeGuanLiFragment = new ShiJiQiYeGuanLiFragment();
                                fragments.add(shiJiQiYeGuanLiFragment);
                                break;
                            case R.id.navi_menu_5:
                                setTitle("培训报名");
                                pagerTitles = getResources().getStringArray(R.array.shiji4);
                                SelectTrainFragment projectApplyFragment = new SelectTrainFragment();
                                ShiJiJiYiBaoPeiXunListFragment peiXunListFragment1 = new ShiJiJiYiBaoPeiXunListFragment();
                                MessageSearchFragment messageSearchFragment = new MessageSearchFragment();
                                fragments.add(projectApplyFragment);
                                fragments.add(peiXunListFragment1);
                                fragments.add(messageSearchFragment);
                                break;

                            case R.id.navi_menu_6:
                                setTitle("监管统计");
                                pagerTitles = getResources().getStringArray(R.array.shiji5);
                                //监管单位统计分析
                                ShiJiJianGuanTongJiFragment shiJiJianGuanTongJiFragment = new ShiJiJianGuanTongJiFragment();
                                //执法记录统计分析 待定
                                ShiJiZhiFaJiLuTongJiFragment shiJiZhiFaJiLuTongJiFragment = new ShiJiZhiFaJiLuTongJiFragment();
                                //企业用户统计分析
                                ShiJiQiYeYongHuTongJiFragment shiJiQiYeYongHuTongJiFragment = new ShiJiQiYeYongHuTongJiFragment();
                                //个人用户统计分析
                                SJGRPersonAnalysisFragment sjgrPersonAnalysisFragment = new SJGRPersonAnalysisFragment();
                                fragments.add(shiJiJianGuanTongJiFragment);
                                fragments.add(shiJiZhiFaJiLuTongJiFragment);
                                fragments.add(shiJiQiYeYongHuTongJiFragment);
                                fragments.add(sjgrPersonAnalysisFragment);
                                break;
                            case R.id.navi_menu_7:
                                setTitle("体检信息");
                                pagerTitles = getResources().getStringArray(R.array.shiji6);
                                //体检统计
                                ShiJiTiJianTongJiFragment shiJiTiJianTongJiFragment = new ShiJiTiJianTongJiFragment();
                                //体检查询
                                ShiJiTiJianSearchFragment shiJiTiJianSearchFragment = new ShiJiTiJianSearchFragment();
                                fragments.add(shiJiTiJianTongJiFragment);
                                fragments.add(shiJiTiJianSearchFragment);
                                break;
                            case R.id.navi_menu_8:
                                setTitle("下载中心");
                                pagerTitles = getResources().getStringArray(R.array.shiji7);
                                //法律法规文档下载
                                SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                                SJGRDownloadDocFragment2 sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment2();
                                SJGRDownloadDocFragment3 sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment3();
                                SJGRDownloadDocFragment4 sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment4();
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
                xianji();
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
            case -1:
                fragments.clear();
                pagerTitles = getResources().getStringArray(R.array.gerenyonghu1);
                GeRenYongHuShouYeFragment geRenYongHuShouYeFragment = new GeRenYongHuShouYeFragment();
                fragments.add(geRenYongHuShouYeFragment);
                setVP();
                naviView.inflateMenu(R.menu.navi_menu_gerenyonghu);
                naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        fragments.clear();
                         int id =  item.getItemId();
                        switch (id){
                            case R.id.navi_menu_1:
                                setTitle("个人用户首页");
                                pagerTitles = getResources().getStringArray(R.array.gerenyonghu1);
                                //首页
                                GeRenYongHuShouYeFragment geRenYongHuShouYeFragment = new GeRenYongHuShouYeFragment();
                                fragments.add(geRenYongHuShouYeFragment);
                            break;
                            case R.id.navi_menu_2:
                                setTitle("个人中心");
                                pagerTitles = getResources().getStringArray(R.array.gerenyonghu2);
                                //用户信息
                                GeRenYongHuYongHuXinXiFragment geRenYongHuYongHuXinXiFragment = new GeRenYongHuYongHuXinXiFragment();
                                fragments.add(geRenYongHuYongHuXinXiFragment);

                                //我的证书
                                GeRenYongHuZhengShuFragment geRenYongHuZhengShuFragment = new GeRenYongHuZhengShuFragment();
                                fragments.add(geRenYongHuZhengShuFragment);
                                //我的信息卡
                                GeRenYongHuXinXiKaFargment geRenYongHuXinXiKaFargment = new GeRenYongHuXinXiKaFargment();
                                fragments.add(geRenYongHuXinXiKaFargment);
                                //我的体检报告
                                GeRenYongHuTiJianBaoGaoFragment geRenYongHuTiJianBaoGaoFragment = new GeRenYongHuTiJianBaoGaoFragment();
                                fragments.add(geRenYongHuTiJianBaoGaoFragment);
                                break;
                            case R.id.navi_menu_3:
                                setTitle("培训学习");
                                pagerTitles = getResources().getStringArray(R.array.gerenyonghu3);
                                //通知消息
                                //GeRenYongHuTongZhiFragment geRenYongHuTongZhiFragment = new GeRenYongHuTongZhiFragment();
                                //fragments.add(geRenYongHuTongZhiFragment);
                                //网上培训
                                //GeRenYongHuYiBaoFragment geRenYongHuYiBaoFragment = new GeRenYongHuYiBaoFragment();
                                //fragments.add(geRenYongHuYiBaoFragment);
                                //已报培训项目
                                // TODO: 2017/3/27 0027  已报培训项目
                                GeRenPeiXunListFragment geRenPeiXunListFragment = new GeRenPeiXunListFragment();
                                fragments.add(geRenPeiXunListFragment);
                                break;
                            case R.id.navi_menu_4:
                                setTitle("体检信息");
                                   pagerTitles = getResources().getStringArray(R.array.gerenyonghu4);
                                //我的体检报告
                                GeRenYongHuTiJianBaoGaoFragment geRenYongHuTiJianBaoGaoFragment2 = new GeRenYongHuTiJianBaoGaoFragment();
                                fragments.add(geRenYongHuTiJianBaoGaoFragment2);
                                break;
                            case R.id.navi_menu_5:
                                setTitle("下载中心");
                                pagerTitles = getResources().getStringArray(R.array.gerenyonghu5);
                                //法律法规文档下载
                                GeRenYongHuWenDangXiaZaiFragment geRenYongHuWenDangXiaZaiFragment = new GeRenYongHuWenDangXiaZaiFragment();
                                fragments.add(geRenYongHuWenDangXiaZaiFragment);
                                //应用插件下载
                                // TODO: 2017/3/27 0027  应用插件下载
                                GeRenYongYingYongChaJianXiaZaiFragment geRenYongYingYongChaJianXiaZaiFragment = new GeRenYongYingYongChaJianXiaZaiFragment();
                                fragments.add(geRenYongYingYongChaJianXiaZaiFragment);
                                //其他相关下载
                                // TODO: 2017/3/27 0027  其他相关下载
                                GeRenYongHuQiTaXiaZaiFragment qiTaXiaZaiFragment = new GeRenYongHuQiTaXiaZaiFragment();
                                fragments.add(qiTaXiaZaiFragment);
                                break;
                            case R.id.navi_menu_6:
                                setTitle("安全设置");
                                pagerTitles = getResources().getStringArray(R.array.gerenyonghu6);
                                //重置密码
                                GeRenYongHuAnQuanSheZhiFragment geRenYongHuAnQuanSheZhiFragment = new GeRenYongHuAnQuanSheZhiFragment();
                                fragments.add(geRenYongHuAnQuanSheZhiFragment);
                                break;
                            case R.id.navi_menu_7:
                                setTitle("扫一扫答题");
                                /*pagerTitles = getResources().getStringArray(R.array.gerenyonghu6);
                                //重置密码
                                GeRenYongHuAnQuanSheZhiFragment geRenYongHuAnQuanSheZhiFragment = new GeRenYongHuAnQuanSheZhiFragment();
                                fragments.add(geRenYongHuAnQuanSheZhiFragment);*/
                                setTitle("个人用户首页");
                                pagerTitles = getResources().getStringArray(R.array.gerenyonghu1);
                                //首页
                                GeRenYongHuShouYeFragment geRenYongHuShouYeFragment2 = new GeRenYongHuShouYeFragment();
                                fragments.add(geRenYongHuShouYeFragment2);

                                Intent intent = new Intent(MainActivity.this,GeRenScannerQrCodeActivity.class);
                                startActivity(intent);
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

        }
    }

    private void xianji() {
        fragments.clear();
        pagerTitles = getResources().getStringArray(R.array.qiye0);
        QYManagerHomeFragment qyHomeFragment = new QYManagerHomeFragment();
        fragments.add(qyHomeFragment);
        setVP();
        naviView.inflateMenu(R.menu.navi_menu_xianji);
        naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                fragments.clear();
                int id = item.getItemId();
                switch (id) {
                    case R.id.navi_menu_1:
                        setTitle("菜单");
                        pagerTitles = getResources().getStringArray(R.array.xianji0);
                        QYManagerHomeFragment qyHomeFragment = new QYManagerHomeFragment();
                        fragments.add(qyHomeFragment);
                        break;
                    case R.id.navi_menu_2:

                        //用户中心
                        setTitle("用户中心");
                        pagerTitles = getResources().getStringArray(R.array.xianji1);
                        //用户信息
                        //QYManager
                        XianJiYongHuXinXiFragment xianJiYongHuXinXiFragment = new XianJiYongHuXinXiFragment();
                        fragments.add(xianJiYongHuXinXiFragment);
                        //我的证书
                        XianJiYongHuZhengShuFragment xianJiYongHuZhengShuFragment = new XianJiYongHuZhengShuFragment();
                        fragments.add(xianJiYongHuZhengShuFragment);
                        //通知消息
                        XianJiMessageSearchFragment xianJiMessageSearchFragment = new XianJiMessageSearchFragment();
                        fragments.add(xianJiMessageSearchFragment);
                        //我的信息卡
                        XianJiXinXiKaFargment xianJiXinXiKaFargment = new XianJiXinXiKaFargment();
                        fragments.add(xianJiXinXiKaFargment);
                        //我的体检报告
                        XianJiYonghuTiJianBaoGaoFragment xianJiYonghuTiJianBaoGaoFragment = new XianJiYonghuTiJianBaoGaoFragment();
                        fragments.add(xianJiYonghuTiJianBaoGaoFragment);


                        break;
                    case R.id.navi_menu_3:
                        setTitle("培训报名");
                        pagerTitles = getResources().getStringArray(R.array.qiye2);
                        SelectTrainFragment projectApplyFragment = new SelectTrainFragment();
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
                        SJGRDownloadDocFragment2 sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment2();
                        SJGRDownloadDocFragment3 sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment3();
                        SJGRDownloadDocFragment4 sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment4();
                        fragments.add(sjgrDownloadDocFragment);
                        fragments.add(sjgrDownloadDocFragment1);
                        //fragments.add(sjgrDownloadDocFragment2);
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
                        QYManagerTiJianBaoGaoFragment qyManagerTiJianBaoGaoFragment = new QYManagerTiJianBaoGaoFragment();
                        fragments.add(qyManagerTiJianBaoGaoFragment);
                        QYInfocardManagerFragment qyInfocardManagerFragment = new QYInfocardManagerFragment();
                        fragments.add(qyInfocardManagerFragment);
                        break;
                    case R.id.navi_menu_3:
                        setTitle("培训报名");
                        pagerTitles = getResources().getStringArray(R.array.qiye2);
                        SelectTrainFragment projectApplyFragment = new SelectTrainFragment();
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
                        //法律法规文档下载
                        SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                        SJGRDownloadDocFragment3 sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment3();
                        SJGRDownloadDocFragment4 sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment4();
                        fragments.add(sjgrDownloadDocFragment);
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
        final CircleImageView circleImageView = (CircleImageView) mRootView.findViewById(R.id.user_head);
        final TextView username_tv = (TextView) mRootView.findViewById(R.id.username_tv);
        final TextView name_tv = (TextView) mRootView.findViewById(R.id.name_tv);
        final TextView unit_name_tv = (TextView) mRootView.findViewById(R.id.unit_name_tv);


        RequestParams params = new RequestParams("http://af.0101hr.com/admin/denglu/main");
        params.addBodyParameter("username",user_name);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                JSONObject jsonObj = JSONObject.parseObject(result);
                JSONObject cade = jsonObj.getJSONObject("cade");

                if(!TextUtils.isEmpty(cade.get("username").toString())){
                    username_tv.setText(cade.get("username").toString());
                }
                if(!TextUtils.isEmpty(cade.get("xm").toString())){
                    name_tv.setText(cade.get("xm").toString());
                }
                if(!TextUtils.isEmpty(cade.get("dwmc").toString())){
                    unit_name_tv.setText(cade.get("dwmc").toString());
                }
                Glide.with(MainActivity.this).load(cade.get("txdz").toString()).into(circleImageView);
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

    public void setIndexFragement(int indexFragement){
        viewPager.setCurrentItem(indexFragement);
    }


}
