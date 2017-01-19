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
import com.lxkj.yiyao.shengji.HomeFragment;
import com.lxkj.yiyao.shengji.ShenHeFragment;

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
                }
                break;
            case 2:

                break;
            case 3:

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
