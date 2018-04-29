package com.veeyikpong.tamagotest.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.veeyikpong.tamagotest.R;
import com.veeyikpong.tamagotest.fragments.ChannelsFragment;
import com.veeyikpong.tamagotest.fragments.DiscoveryFragment;
import com.veeyikpong.tamagotest.fragments.TamagoFragment;

import java.util.ArrayList;

/**
 * Created by User on 29/4/2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    private ArrayList<String> tabs = new java.util.ArrayList<>();

    public MyPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        tabs.add(context.getString(R.string.channels));
        tabs.add(context.getString(R.string.tamago));
        tabs.add(context.getString(R.string.discovery));
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
                return new ChannelsFragment();
            case 1: // Fragment # 0 - This will show TamagoFragment different title
                return new TamagoFragment();
            case 2: // Fragment # 1 - This will show SecondFragment
                return new DiscoveryFragment();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }

}