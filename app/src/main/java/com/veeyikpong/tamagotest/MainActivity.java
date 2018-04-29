package com.veeyikpong.tamagotest;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.viven.fragmentstatemanager.FragmentStateManager;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentStateManager fragmentStateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        FrameLayout content = findViewById(R.id.fragmentContainer);
        fragmentStateManager = new FragmentStateManager(content, getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new HomeFragment();
                    case 1:
                        return new LiveFragment();
                    case 2:
                        return new ProfileFragment();
                    default:
                        return new HomeFragment();
                }
            }
        };

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch(tabId){
                    case R.id.tab_home:
                        fragmentStateManager.changeFragment(0);
                        break;
                    case R.id.tab_live:
                        fragmentStateManager.changeFragment(1);
                        break;
                    case R.id.tab_profile:
                        fragmentStateManager.changeFragment(2);
                        break;
                    default:
                        fragmentStateManager.changeFragment(0);
                        break;
                }
            }
        });
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
