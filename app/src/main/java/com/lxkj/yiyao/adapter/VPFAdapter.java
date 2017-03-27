package com.lxkj.yiyao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.lxkj.yiyao.base.BaseFragment;
import com.lxkj.yiyao.jianguan.CompanyManagerFragment;
import com.lxkj.yiyao.jianguan.JGManagerFragment;
import com.lxkj.yiyao.jianguan.LawManagerFragment;
import com.lxkj.yiyao.jianguan.QiyeInfoCardFragment;
import com.lxkj.yiyao.jianguan.UserManagerFragment;
import com.lxkj.yiyao.qiye.QYHomeFragment;
import com.lxkj.yiyao.qiye.QYInfoInputFragment;
import com.lxkj.yiyao.qiye.QYInfocardManagerFragment;
import com.lxkj.yiyao.qiye.QYPersonManagerFragment;
import com.lxkj.yiyao.qiye.QYPwesonManagerAddFragment;
import com.lxkj.yiyao.qiye.QYSignedTrainFragment;
import com.lxkj.yiyao.qiye.QYTrainOrderFragment;
import com.lxkj.yiyao.xianji.QYManagerHomeFragment;
import com.lxkj.yiyao.xianji.QYManagerPeiXunDingDanFragment;
import com.lxkj.yiyao.xianji.QYManagerSelectTrainFragment;
import com.lxkj.yiyao.xianji.QYManagerTongZhiFragment;
import com.lxkj.yiyao.xianji.QYManagerYiBaoPeiXunXiangMuFragment;
import com.lxkj.yiyao.shengji.HomeFragment;
import com.lxkj.yiyao.shengji.ShenHeFragment;
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
import com.lxkj.yiyao.shiji.MessageSearchFragment;
import com.lxkj.yiyao.shiji.PeiXunListFragment;
import com.lxkj.yiyao.shiji.ProjectApplyFragment;
import com.lxkj.yiyao.shiji.QiYeInfoFragment;

/**
 * Created by sun on 2017/1/18.
 */

public class VPFAdapter extends FragmentPagerAdapter {
    private String[] pagerTitles;
    /**
     * 角色端，0是省级端, 1是企业端，3是
     */

    private BaseFragment baseFragment;

    private int mChildCount = 0;
    private int part;
    public VPFAdapter(FragmentManager fm, int part, String[] pagerTitles) {
        super(fm);
        this.part = part;
        this.pagerTitles = pagerTitles;
    }


    public void setData(int part, String[] pagerTitles){
        this.part = part;
        this.pagerTitles = pagerTitles;
    }
    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
        /*if ( mChildCount > 0) {
            mChildCount --;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);*/
    }

    @Override
    public Fragment getItem(int position) {
        //先判断角色
        switch (part){
            case 0:
                //第position个fragment页面, new 出fragment并返回
                switch (position){
                    case 0:
                        com.lxkj.yiyao.jianguan.HomeFragment homeFragment = new com.lxkj.yiyao.jianguan.HomeFragment();
                        return homeFragment;
                    case 1:
                        UserManagerFragment userManagerFragment = new UserManagerFragment();
                        return userManagerFragment;
                    case 2:
                        CompanyManagerFragment  qiyeFragment = new CompanyManagerFragment();
                        return qiyeFragment;
                    case 3:
                        QiyeInfoCardFragment qiyeInfoCardFragment = new QiyeInfoCardFragment();
                        return qiyeInfoCardFragment;
                    case 4:
                        JGManagerFragment jgManagerFragment = new JGManagerFragment();
                        return jgManagerFragment;
                    case 5:
                        LawManagerFragment lawManagerFragment = new LawManagerFragment();
                        return lawManagerFragment;
                }
                break;
            case 1:
                switch (position){
                    case 0:
                        HomeFragment homeFragment = new HomeFragment();
                        return homeFragment;
                    case 1:
                        HomeFragment homeFragment1 = new HomeFragment();
                        return homeFragment1;
                    case 2:
                        HomeFragment homeFragment2 = new HomeFragment();
                        return homeFragment2;
                    //1 2
                    case 3:
                        ShenHeFragment shenHeFragment = new ShenHeFragment();
                        return shenHeFragment;
                    case 4:
                        ShenHeFragment shenHeFragment4 = new ShenHeFragment();
                        return shenHeFragment4;
                    case 5:
                        ShenHeFragment shenHeFragment5 = new ShenHeFragment();
                        return shenHeFragment5;
                    case 6:
                        ShenHeFragment shenHeFragment6 = new ShenHeFragment();
                        return shenHeFragment6;
                    case 7:
                        ShenHeFragment shenHeFragment7 = new ShenHeFragment();
                        return shenHeFragment7;

                }
                break;
            /**
             * 省局管理员
             */
            case 10:
                switch (position){
                    //首页
                    case 0:
                        HomeFragment homeFragment = new HomeFragment();
                        return homeFragment;
                }
                break;
            case 11://监管单位管理
                switch (position){
                    case 0:
                        //监管单位信息
                        CompanyManageyFragment companyManageyFragment = new CompanyManageyFragment();
                        return companyManageyFragment;
                    case 1:
                        //监管人员管理
                        AdminManagerFragment adminManagerFragment = new AdminManagerFragment();
                        return adminManagerFragment;
                }
                break;
            case 12://培训通知管理
                switch (position){
                    case 0:
                        //培训通知列表
                        SJGRMessageSearchFragment sjgrMessageSearchFragment = new SJGRMessageSearchFragment();
                        return sjgrMessageSearchFragment;
                }
            case 13://体检机构审核
                switch (position){
                    case 0:
                        ShenHeFragment shenHeFragment = new ShenHeFragment();
                        return shenHeFragment;
                }
                break;
            case 14://企业管理
                switch (position){
                    case 0:
                        //企业信息列表
                        SJGRCompanyInfoListFragment sjgrCompanyInfoListFragment = new SJGRCompanyInfoListFragment();
                        return sjgrCompanyInfoListFragment;
                }
                break;
            case 15://培训报名
                switch (position){
                    case 0:
                        //培训项目报名
                        ProjectApplyFragment projectApplyFragment = new ProjectApplyFragment();
                        return projectApplyFragment;
                    case 1:
                        //已报培训项目
                        PeiXunListFragment peiXunListFragment = new PeiXunListFragment();
                        return peiXunListFragment;
                    case 2:
                        //通知消息
                        MessageSearchFragment messageSearchFragment = new MessageSearchFragment();
                        return messageSearchFragment;
                }
                break;
            case 16://监管统计
                switch (position){
                    case 0:
                        //监管单位统计分析
                        SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment = new SJGRJianGuanTongJiFragment();
                        return sjgrJianGuanTongJiFragment;
                    case 1:
                        //执法记录统计分析 待定
                        SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment1 = new SJGRJianGuanTongJiFragment();
                        return sjgrJianGuanTongJiFragment1;
                    case 2:
                        //企业用户统计分析
                        SJGRCompanyTongJiFragment sjgrCompanyTongJiFragment = new SJGRCompanyTongJiFragment();
                        return sjgrCompanyTongJiFragment;
                    case 3:
                        //个人用户统计分析
                        SJGRPersonAnalysisFragment sjgrPersonAnalysisFragment = new SJGRPersonAnalysisFragment();
                        return sjgrPersonAnalysisFragment;
                }
                break;
            case 17://体检信息
                switch (position){
                    case 0:
                        //体检统计
                        SJGRTiJianTongJiFragment sjgrTiJianTongJiFragment = new SJGRTiJianTongJiFragment();
                        return sjgrTiJianTongJiFragment;
                    case 1:
                        //体检查询
                        SJGRTiJianSearchFragment sjgrTiJianSearchFragment = new SJGRTiJianSearchFragment();
                        return sjgrTiJianSearchFragment;
                }
                break;
            case 18://下载中心
                switch (position){
                    case 0:
                        //法律法规文档下载
                        SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment;
                    case 1:
                        //应用模板下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment1;
                    case 2:
                        //应用插件下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment2;
                    case 3:
                        //其他相关下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment3;
                }
                break;
            case 19:
                switch (position){
                    case 0:
                        //安全设置
                        SJGRUpdatePswFragment sjgrUpdatePswFragment = new SJGRUpdatePswFragment();
                        return sjgrUpdatePswFragment;
                }
                break;

            /**
             * 省局个人相关页面
             */
            case 20:
                switch (position){
                    case 0:
                        //省局个人首页
                        SJGRMessageFragment sjgrMessageFragment = new SJGRMessageFragment();
                        return sjgrMessageFragment;
                }
                break;
            case 21://监管人员中心
                switch (position){
                    case 0:
                        //监管人员信息
                        SJGRPersonManagerAddFragment sjgrPersonManagerAddFragment = new SJGRPersonManagerAddFragment();
                        return sjgrPersonManagerAddFragment;
                    case 1:
                        //我的证书  待定
                        SJGRPersonManagerAddFragment sjgrPersonManagerAddFragment1 = new SJGRPersonManagerAddFragment();
                        return sjgrPersonManagerAddFragment1;
                    case 2:
                        //我的执法
                        SJGRZhiFaSerachFragment sjgrZhiFaSerachFragment = new SJGRZhiFaSerachFragment();
                        return sjgrZhiFaSerachFragment;
                    case 3:
                        //通知消息 查询
                        SJGRMessageSearchFragment sjgrMessageSearchFragment = new SJGRMessageSearchFragment();
                        return sjgrMessageSearchFragment;
                }
                break;
            case 22://培训学习
                switch (position){
                    case 0:
                        //已报培训项目
                        SJGRYiBaoPeiXunXiangMuFragment sjgrYiBaoPeiXunXiangMuFragment = new SJGRYiBaoPeiXunXiangMuFragment();
                        return sjgrYiBaoPeiXunXiangMuFragment;
                }
                break;
            case 23://企业管理
                switch (position){
                    case 0:
                        //企业信息列表
                        SJGRCompanyInfoListFragment sjgrCompanyInfoListFragment = new SJGRCompanyInfoListFragment();
                        return sjgrCompanyInfoListFragment;
                    case 1:
                        //企业报名信息
                        SJGRBaoMingMessageFragment sjgrBaoMingMessageFragment = new SJGRBaoMingMessageFragment();
                        return sjgrBaoMingMessageFragment;
                }
                break;
            case 24://监管统计
                switch (position){
                    case 0:
                        //监管单位统计分析
                        SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment = new SJGRJianGuanTongJiFragment();
                        return sjgrJianGuanTongJiFragment;
                    case 1:
                        //执法记录统计分析 待定
                        SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment1 = new SJGRJianGuanTongJiFragment();
                        return sjgrJianGuanTongJiFragment1;
                    case 2:
                        //企业用户统计分析
                        SJGRCompanyTongJiFragment sjgrCompanyTongJiFragment = new SJGRCompanyTongJiFragment();
                        return sjgrCompanyTongJiFragment;
                    case 3:
                        //个人用户统计分析
                        SJGRPersonAnalysisFragment sjgrPersonAnalysisFragment = new SJGRPersonAnalysisFragment();
                        return sjgrPersonAnalysisFragment;
                }
                break;
            case 25://体检信息
                switch (position){
                    case 0:
                        //体检统计
                        SJGRTiJianTongJiFragment sjgrTiJianTongJiFragment = new SJGRTiJianTongJiFragment();
                        return sjgrTiJianTongJiFragment;
                    case 1:
                        //体检查询
                        SJGRTiJianSearchFragment sjgrTiJianSearchFragment = new SJGRTiJianSearchFragment();
                        return sjgrTiJianSearchFragment;
                }
                break;
            case 26://下载中心
                switch (position){
                    case 0:
                        //法律法规文档下载
                        SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment;
                    case 1:
                        //应用模板下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment1;
                    case 2:
                        //应用插件下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment2;
                    case 3:
                        //其他相关下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment3;
                }
                break;
            case 27:
                switch (position){
                    case 0:
                        //安全设置
                        SJGRUpdatePswFragment sjgrUpdatePswFragment = new SJGRUpdatePswFragment();
                        return sjgrUpdatePswFragment;
                }
                break;
            /**
             * 市级管理员
             */
            case 30://监督单位首页
                switch (position) {
                    case 0:
                        //监管单位首页
                        com.lxkj.yiyao.shiji.HomeFragment homeFragment = new com.lxkj.yiyao.shiji.HomeFragment();
                        return homeFragment;
                }
                break;

            case 31://监管单位管理
                switch (position){
                    case 0:
                        //监管单位信息
                        CompanyManageyFragment companyManageyFragment = new CompanyManageyFragment();
                        return companyManageyFragment;
                    case 1:
                        //监管人员管理
                        AdminManagerFragment adminManagerFragment = new AdminManagerFragment();
                        return adminManagerFragment;
                }
                break;
            case 32://培训通知管理
                switch (position) {
                    case 0:
                    PeiXunListFragment peiXunListFragment = new PeiXunListFragment();
                    return peiXunListFragment;
                }
                break;
            case 33://企业管理
                switch (position) {
                    case 0:
                        QiYeInfoFragment qiYeInfoFragment = new QiYeInfoFragment();
                        return qiYeInfoFragment;
                }
                break;
            case 34://培训报名
                switch (position){
                    case 0:
                        //培训项目报名
                        ProjectApplyFragment projectApplyFragment = new ProjectApplyFragment();
                        return projectApplyFragment;
                    case 1:
                        //已报培训项目
                        PeiXunListFragment peiXunListFragment = new PeiXunListFragment();
                        return peiXunListFragment;
                    case 2:
                        //通知消息
                        MessageSearchFragment messageSearchFragment = new MessageSearchFragment();
                        return messageSearchFragment;
                }
                break;
            case 35://监管统计
                switch (position){
                    case 0:
                        //监管单位统计分析
                        SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment = new SJGRJianGuanTongJiFragment();
                        return sjgrJianGuanTongJiFragment;
                    case 1:
                        //执法记录统计分析 待定
                        SJGRJianGuanTongJiFragment sjgrJianGuanTongJiFragment1 = new SJGRJianGuanTongJiFragment();
                        return sjgrJianGuanTongJiFragment1;
                    case 2:
                        //企业用户统计分析
                        SJGRCompanyTongJiFragment sjgrCompanyTongJiFragment = new SJGRCompanyTongJiFragment();
                        return sjgrCompanyTongJiFragment;
                    case 3:
                        //个人用户统计分析
                        SJGRPersonAnalysisFragment sjgrPersonAnalysisFragment = new SJGRPersonAnalysisFragment();
                        return sjgrPersonAnalysisFragment;
                }
                break;
            case 36://体检信息
                switch (position){
                    case 0:
                        //体检统计
                        SJGRTiJianTongJiFragment sjgrTiJianTongJiFragment = new SJGRTiJianTongJiFragment();
                        return sjgrTiJianTongJiFragment;
                    case 1:
                        //体检查询
                        SJGRTiJianSearchFragment sjgrTiJianSearchFragment = new SJGRTiJianSearchFragment();
                        return sjgrTiJianSearchFragment;
                }
                break;
            case 37://下载中心
                switch (position){
                    case 0:
                        //法律法规文档下载
                        SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment;
                    case 1:
                        //应用模板下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment1;
                    case 2:
                        //应用插件下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment2;
                    case 3:
                        //其他相关下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment3;
                }
                break;
            case 38:
                switch (position){
                    case 0:
                        //安全设置
                        SJGRUpdatePswFragment sjgrUpdatePswFragment = new SJGRUpdatePswFragment();
                        return sjgrUpdatePswFragment;
                }
                break;
            /**
             * 企业管理员
             */
            case 40:
                switch (position){
                    case 0:
                        //首页
                        QYHomeFragment qyHomeFragment = new QYHomeFragment();
                        return qyHomeFragment;
                }
                break;
            case 41://企业管理
                switch (position){
                    case 0:
                        //企业信息
                        QYInfoInputFragment qyInfoInputFragment = new QYInfoInputFragment();
                        return qyInfoInputFragment;
                    case 1:
                        //员工管理
                        QYPersonManagerFragment qyPersonManagerFragment = new QYPersonManagerFragment();
                        return qyPersonManagerFragment;
                    case 2:
                        //体检报告管理
                        QYPersonManagerFragment qyPersonManagerFragment1 = new QYPersonManagerFragment();
                        return qyPersonManagerFragment1;
                    case 3:
                        //信息卡管理
                        QYInfocardManagerFragment qyInfocardManagerFragment = new QYInfocardManagerFragment();
                        return qyInfocardManagerFragment;
                }
                break;
            case 42://培训报名
                switch (position){
                    case 0:
                        //选购培训项目
                        ProjectApplyFragment projectApplyFragment = new ProjectApplyFragment();
                        return projectApplyFragment;
                    case 1:
                        //培训项目订单
                        QYTrainOrderFragment qyTrainOrderFragment = new QYTrainOrderFragment();
                        return qyTrainOrderFragment;
                    case 2:
                        //已报培训项目
                        PeiXunListFragment peiXunListFragment = new PeiXunListFragment();
                        return peiXunListFragment;
                    case 3:
                        //通知消息
                        MessageSearchFragment messageSearchFragment = new MessageSearchFragment();
                        return messageSearchFragment;
                }
                break;
            case 43://下载中心
                switch (position){
                    case 0:
                        //法律法规文档下载
                        SJGRDownloadDocFragment sjgrDownloadDocFragment = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment;
                    case 1:
                        //应用模板下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment1 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment1;
                    case 2:
                        //应用插件下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment2 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment2;
                    case 3:
                        //其他相关下载  待定
                        SJGRDownloadDocFragment sjgrDownloadDocFragment3 = new SJGRDownloadDocFragment();
                        return sjgrDownloadDocFragment3;
                }
                break;
            case 44:
                switch (position){
                    case 0:
                        //安全设置
                        SJGRUpdatePswFragment sjgrUpdatePswFragment = new SJGRUpdatePswFragment();
                        return sjgrUpdatePswFragment;
                }
                break;

            case 3:
                switch (position){
                    case 0:
                        com.lxkj.yiyao.shiji.HomeFragment shiJihomeFragment = new com.lxkj.yiyao.shiji.HomeFragment();
                        return shiJihomeFragment;
                    case 1:
                        QYManagerPeiXunDingDanFragment peiXunListFragment1 = new QYManagerPeiXunDingDanFragment();
                        return peiXunListFragment1;
                    case 2:
                        ProjectApplyFragment projectApplyFragment = new ProjectApplyFragment();
                        return projectApplyFragment;
                    case 3:
                        PeiXunListFragment peiXunListFragment = new PeiXunListFragment();
                        return peiXunListFragment;
                    case 4:
                        PeiXunListFragment peiXunListFragment4 = new PeiXunListFragment();
                        return peiXunListFragment4;
                    case 5:
                        PeiXunListFragment peiXunListFragment5 = new PeiXunListFragment();
                        return peiXunListFragment5;
                }
                break;
            case 4:
                switch (position){
                    case 0:
                        QYManagerHomeFragment qyManagerHomeFragment = new QYManagerHomeFragment();
                        return qyManagerHomeFragment;
                    case 1:
                        QYManagerSelectTrainFragment qyManagerSelectTrainFragment = new QYManagerSelectTrainFragment();
                        return qyManagerSelectTrainFragment;
                    case 2:
                        QYManagerPeiXunDingDanFragment qyManagerPeiXunDingDanFragment = new QYManagerPeiXunDingDanFragment();
                        return qyManagerPeiXunDingDanFragment;
                    case 3:
                        QYManagerYiBaoPeiXunXiangMuFragment qyManagerYiBaoPeiXunXiangMuFragment = new QYManagerYiBaoPeiXunXiangMuFragment();
                        return qyManagerYiBaoPeiXunXiangMuFragment;
                    case 4:
                        QYManagerTongZhiFragment qyManagerTongZhiFragment = new QYManagerTongZhiFragment();
                        return qyManagerTongZhiFragment;
                    case 5:
                        QYManagerTongZhiFragment qyManagerTongZhiFragment5 = new QYManagerTongZhiFragment();
                        return qyManagerTongZhiFragment5;
                }
                break;

            case 5:
                switch (position){
                    case 0:
                        QYHomeFragment qyHomeFragment = new QYHomeFragment();
                        return qyHomeFragment;
                    case 1:
                        QYHomeFragment qyHomeFragment1 = new QYHomeFragment();
                        return qyHomeFragment1;
                    case 2:
                        QYSignedTrainFragment qySignedTrainFragment = new QYSignedTrainFragment();
                        return qySignedTrainFragment;
                    case 3:
                        QYPwesonManagerAddFragment qyPwesonManagerAddFragment = new QYPwesonManagerAddFragment();
                        return qyPwesonManagerAddFragment;
                    case 4:
                        QYPwesonManagerAddFragment qyPwesonManagerAddFragmen4 = new QYPwesonManagerAddFragment();
                        return qyPwesonManagerAddFragmen4;
                    case 5:
                        QYPwesonManagerAddFragment qyPwesonManagerAddFragment5 = new QYPwesonManagerAddFragment();
                        return qyPwesonManagerAddFragment5;
                }
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return pagerTitles.length;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pagerTitles[position];
    }
}
