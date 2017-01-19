package com.lxkj.yiyao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.lxkj.yiyao.jianguan.CompanyManagerFragment;
import com.lxkj.yiyao.jianguan.JGCompanyManFragment;
import com.lxkj.yiyao.jianguan.LawManagerFragment;
import com.lxkj.yiyao.jianguan.QiyeInfoCardFragment;
import com.lxkj.yiyao.jianguan.UserManagerFragment;
import com.lxkj.yiyao.qiye.QYHomeFragment;
import com.lxkj.yiyao.qiye.QYPwesonManagerAddFragment;
import com.lxkj.yiyao.qiye.QYSignedTrainFragment;
import com.lxkj.yiyao.qiyemanager.QYManagerHomeFragment;
import com.lxkj.yiyao.qiyemanager.QYManagerPeiXunDingDanFragment;
import com.lxkj.yiyao.qiyemanager.QYManagerSelectTrainFragment;
import com.lxkj.yiyao.qiyemanager.QYManagerTongZhiFragment;
import com.lxkj.yiyao.qiyemanager.QYManagerYiBaoPeiXunXiangMuFragment;
import com.lxkj.yiyao.shengji.HomeFragment;
import com.lxkj.yiyao.shengji.ShenHeFragment;
import com.lxkj.yiyao.shengjugeren.SJGRMessageFragment;
import com.lxkj.yiyao.shengjugeren.SJGRYiBaoPeiXunXiangMuFragment;
import com.lxkj.yiyao.shengjugeren.SJGRZhiFaSerachFragment;
import com.lxkj.yiyao.shiji.PeiXunListFragment;
import com.lxkj.yiyao.shiji.ProjectApplyFragment;

/**
 * Created by sun on 2017/1/18.
 */

public class VPFAdapter extends FragmentPagerAdapter {
    private String[] pagerTitles;
    /**
     * 角色端，0是省级端, 1是企业端，3是
     */

    private int part;
    public VPFAdapter(FragmentManager fm, int part, String[] pagerTitles) {
        super(fm);
        this.part = part;
        this.pagerTitles = pagerTitles;
    }

    @Override
    public Fragment getItem(int position) {
        //先判断角色
        switch (part){
            case 0:
                //第position个fragment页面, new 出fragment并返回
                switch (position){
                    case 0:
                        HomeFragment homeFragment = new HomeFragment();
                        return homeFragment;
                    case 1:
                        ShenHeFragment shenHeFragment = new ShenHeFragment();
                        return shenHeFragment;
                    case 2:
                        UserManagerFragment userManagerFragment = new UserManagerFragment();
                        return userManagerFragment;
                    case 3:
                        CompanyManagerFragment companyManagerFragment = new CompanyManagerFragment();
                        return companyManagerFragment;
                    case 4:
                        QiyeInfoCardFragment qiyeInfoCardFragment = new QiyeInfoCardFragment();
                        return qiyeInfoCardFragment;
                    case 5:
                        JGCompanyManFragment jgCompanyManFragment = new JGCompanyManFragment();
                        return jgCompanyManFragment;
                    case 6:
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
                        return homeFragment;
                    case 2:
                        HomeFragment homeFragment2 = new HomeFragment();
                        return homeFragment;
                    //1 2
                    case 3:
                        ShenHeFragment shenHeFragment = new ShenHeFragment();
                        return shenHeFragment;
                    case 4:
                        ShenHeFragment shenHeFragment4 = new ShenHeFragment();
                        return shenHeFragment;
                    case 5:
                        ShenHeFragment shenHeFragment5 = new ShenHeFragment();
                        return shenHeFragment;
                    case 6:
                        ShenHeFragment shenHeFragment6 = new ShenHeFragment();
                        return shenHeFragment;
                    case 7:
                        ShenHeFragment shenHeFragment7 = new ShenHeFragment();
                        return shenHeFragment;

                }
                break;
            case 2:
                switch (position){
                    case 0:
                        SJGRYiBaoPeiXunXiangMuFragment sjgrYiBaoPeiXunXiangMuFragment = new SJGRYiBaoPeiXunXiangMuFragment();
                        return  sjgrYiBaoPeiXunXiangMuFragment;
                    case 1:
                        SJGRYiBaoPeiXunXiangMuFragment sjgrYiBaoPeiXunXiangMuFragment1 = new SJGRYiBaoPeiXunXiangMuFragment();
                        return  sjgrYiBaoPeiXunXiangMuFragment;
                    case 2:
                        SJGRYiBaoPeiXunXiangMuFragment sjgrYiBaoPeiXunXiangMuFragment2 = new SJGRYiBaoPeiXunXiangMuFragment();
                        return  sjgrYiBaoPeiXunXiangMuFragment;
                    case 3:
                        SJGRYiBaoPeiXunXiangMuFragment sjgrYiBaoPeiXunXiangMuFragment3 = new SJGRYiBaoPeiXunXiangMuFragment();
                        return  sjgrYiBaoPeiXunXiangMuFragment;
                    case 4:
                        SJGRMessageFragment sjgrMessageFragment = new SJGRMessageFragment();
                        return sjgrMessageFragment;
                    case 5:
                        SJGRZhiFaSerachFragment sjgrZhiFaSerachFragment = new SJGRZhiFaSerachFragment();
                        return sjgrZhiFaSerachFragment;
                }

                break;
            case 3:
                switch (position){
                    case 0:
                        com.lxkj.yiyao.shiji.HomeFragment shiJihomeFragment = new com.lxkj.yiyao.shiji.HomeFragment();
                        return shiJihomeFragment;
                    case 1:
                        PeiXunListFragment peiXunListFragment1 = new PeiXunListFragment();
                        return peiXunListFragment1;
                    case 2:
                        ProjectApplyFragment projectApplyFragment = new ProjectApplyFragment();
                        return projectApplyFragment;
                    case 3:
                        PeiXunListFragment peiXunListFragment = new PeiXunListFragment();
                        return peiXunListFragment;
                    case 4:
                        PeiXunListFragment peiXunListFragment4 = new PeiXunListFragment();
                        return peiXunListFragment;
                    case 5:
                        PeiXunListFragment peiXunListFragment5 = new PeiXunListFragment();
                        return peiXunListFragment;

                }
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
                        return qyManagerTongZhiFragment;
                }
            case 5:
                switch (position){
                    case 0:
                        QYHomeFragment qyHomeFragment = new QYHomeFragment();
                        return qyHomeFragment;
                    case 1:
                        QYHomeFragment qyHomeFragment1 = new QYHomeFragment();
                        return qyHomeFragment;
                    case 2:
                        QYSignedTrainFragment qySignedTrainFragment = new QYSignedTrainFragment();
                        return qySignedTrainFragment;
                    case 3:
                        QYPwesonManagerAddFragment qyPwesonManagerAddFragment = new QYPwesonManagerAddFragment();
                        return qyPwesonManagerAddFragment;
                    case 4:
                        QYPwesonManagerAddFragment qyPwesonManagerAddFragmen4 = new QYPwesonManagerAddFragment();
                        return qyPwesonManagerAddFragment;
                    case 5:
                        QYPwesonManagerAddFragment qyPwesonManagerAddFragment5 = new QYPwesonManagerAddFragment();
                        return qyPwesonManagerAddFragment;
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
