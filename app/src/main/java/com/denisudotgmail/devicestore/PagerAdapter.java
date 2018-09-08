package com.denisudotgmail.devicestore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    //array for data
    List<ItemData> itemDataList;

        public PagerAdapter(FragmentManager mgr, List<ItemData> itemDataList) {
            super(mgr);
            this.itemDataList = itemDataList;
        }
        @Override
        public int getCount() {
            return(itemDataList.size());
        }
        @Override
        public Fragment getItem(int position) {
            return(ItemFragment.newInstance(position, itemDataList.get(position)));
        }
    }
//    List<String> data;
//
//    public PagerAdapter(FragmentManager fm, List<String> data) {
//        super(fm);
//        this.data = data;
//
//    }
//
//    @Override
//    public Fragment getItem(int i) {
//
//        Fragment fragment = new ItemFragment();
//
//        Bundle args = new Bundle();
//        args.putString(ItemFragment.ARG_TEXT, data.get(i));
//        args.putInt(ItemFragment.ARG_POSITION, i+1);
//        args.putInt(ItemFragment.ARG_COUNT, getCount());
//
//        fragment.setArguments(args);
//
//        return fragment;
//
//    }
//
//    @Override
//    public int getCount() {
//
//        return data.size();
//    }
//
//    public String getTextVP(int i) {
//        return data.get(i);
//    }
//
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return "Item " + (position + 1);
//    }
//
//
//    @Override
//    public int getItemPosition(Object object) {
//        return POSITION_NONE;
//    }
//}