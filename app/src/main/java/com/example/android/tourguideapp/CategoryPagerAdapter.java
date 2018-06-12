package com.example.android.tourguideapp;

import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryPagerAdapter extends FragmentPagerAdapter {

    public CategoryPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RestaurantsFragment();
            case 1:
                return new EntertainmentFragment();
            case 2:
                return new NightlifeFragment();
            case 3:
                return new SightsFragment();
            default:
                return null;
        }
    }

        @Nullable
        @Override
        public CharSequence getPageTitle ( int position){
            switch (position) {
                case 0:
                    return Resources.getSystem().getString(R.string.r);
                case 1:
                    return Resources.getSystem().getString(R.string.e);
                case 2:
                    return Resources.getSystem().getString(R.string.n);
                case 3:
                    return Resources.getSystem().getString(R.string.s);
                default:
                    return null;
            }
        }




    }