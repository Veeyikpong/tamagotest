package com.veeyikpong.tamagotest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by User on 29/4/2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    private String [] tabs = {"Channels","Tamago","Discovery"};

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show TamagoFragment
                return new TamagoFragment();
            case 1: // Fragment # 0 - This will show TamagoFragment different title
                return new TamagoFragment();
            case 2: // Fragment # 1 - This will show SecondFragment
                return new TamagoFragment();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

}