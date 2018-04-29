package com.example.android.tourguideapp;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by vladislavakopalova on 27.4.18.
 */

public class FragmentPageAdapter extends FragmentPagerAdapter {
    Context mContext;

    public FragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
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
                return mContext.getResources().getString(R.string.mustsee_string);
            case 1:
                return mContext.getResources().getString(R.string.events_string);
            case 2:
                return mContext.getResources().getString(R.string.restaurant_string);
            case 3:
                return mContext.getResources().getString(R.string.bars_string);

            default:
                throw new IllegalArgumentException("Position "+position+" not supported!");
        }
    }
}