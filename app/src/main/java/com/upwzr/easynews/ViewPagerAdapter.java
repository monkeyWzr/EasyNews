package com.upwzr.easynews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzr on 2017/9/7.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mfragmentList = new ArrayList<>();

    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        mfragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
}
