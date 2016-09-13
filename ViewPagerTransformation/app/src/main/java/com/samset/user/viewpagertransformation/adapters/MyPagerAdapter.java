package com.samset.user.viewpagertransformation.adapters;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.samset.user.viewpagertransformation.fragments.FirstFragment;


/**
 * Created by user on 13-Sep-16.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FirstFragment.newInstance(Color.parseColor("#03A9F4"), position); // blue
            case 1:
                return FirstFragment.newInstance(Color.parseColor("#9C27B0"), position); // purpal
            case 2:
                return FirstFragment.newInstance(Color.parseColor("#E91E63"), position); // pink
            case 3:
                return FirstFragment.newInstance(Color.parseColor("#F44336"), position); // red
            default:
                return FirstFragment.newInstance(Color.parseColor("#4CAF50"), position); // green
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

}