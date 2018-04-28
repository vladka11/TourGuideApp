package com.example.android.tourguideapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by vladislavakopalova on 27.4.18.
 */

public class FragmentPageAdapter extends FragmentPagerAdapter {


    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AttractionFragment();
        } else if (position == 1) {
            return new EventsFragment();
        } else if (position == 2) {
            return new RestaurantsFragment();
        } else {
            return new BarsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Must see";
            case 1:
                return "Events";
            case 2:
                return "Food";
            case 3:
                return "Bars";

            default:
                return null;
        }
    }
}