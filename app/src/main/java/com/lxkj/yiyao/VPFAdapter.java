package com.lxkj.yiyao;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

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

                        break;
                    case 1:

                        break;
                }
                break;
            case 1:

                break;
            case 2:

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
