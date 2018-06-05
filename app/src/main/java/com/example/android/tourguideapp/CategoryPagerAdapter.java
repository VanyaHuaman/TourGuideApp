package com.example.android.tourguideapp;

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
                    return "R";
                case 1:
                    return "E";
                case 2:
                    return "N";
                case 3:
                    return "S";
                default:
                    return null;
            }
        }




    }