package com.denisudotgmail.devicestore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;

public class ItemFragmentAdapter extends FragmentStatePagerAdapter {

    //array for data
    List<ItemData> itemDataList;

    public ItemFragmentAdapter(FragmentManager mgr, List<ItemData> itemDataList) {
        super(mgr);

        this.itemDataList = itemDataList;
    }

    @Override
    public int getCount() {
        return (itemDataList.size());
    }

    @Override
    public Fragment getItem(int position) {
        return (ItemFragment.newInstance(itemDataList.get(position)));
    }
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
