package com.lxkj.yiyao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 紫荆 on 2017/1/26.
 */

public class VPFAdapter2 extends FragmentStatePagerAdapter{
    private String[] pagerTitles;
    private List<Fragment> fragments;
    private FragmentManager fm;
    public VPFAdapter2(FragmentManager fm, List<Fragment> fragments, String[] pagerTitles) {
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
        this.pagerTitles = pagerTitles;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
    public void setFragments(List<Fragment> fragments, String[] pagerTitles){
        Log.d("VPFAdapter2", "setFragments");
        if(this.fragments != null){
            FragmentTransaction ft = fm.beginTransaction();
            for(Fragment f:this.fragments){
                ft.remove(f);
            }
            ft.commit();
            ft=null;
            fm.executePendingTransactions();
        }
        this.fragments = fragments;
        this.pagerTitles = pagerTitles;
        notifyDataSetChanged();
    }


    public void setData(List<Fragment> fragments, String[] pagerTitles){
        this.fragments = fragments;
        this.pagerTitles = pagerTitles;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pagerTitles[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
