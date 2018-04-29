package com.veeyikpong.tamagotest;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.veeyikpong.tamagotest.fragments.HomeFragment;
import com.veeyikpong.tamagotest.fragments.LiveFragment;
import com.veeyikpong.tamagotest.fragments.ProfileFragment;
import com.viven.fragmentstatemanager.FragmentStateManager;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentStateManager fragmentStateManager;
    private boolean doubleBackToExitPressedOnce = false;

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

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please Again to Quit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
