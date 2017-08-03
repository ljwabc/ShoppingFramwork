package com.aqhg.aqhgfxd.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aqhg.aqhgfxd.R;
import com.aqhg.aqhgfxd.fragment.SelectionAllFragment.HomeFragment;
import com.aqhg.aqhgfxd.fragment.SelectionAllFragment.PinPaiTuanFragment;
import com.aqhg.aqhgfxd.fragment.SelectionAllFragment.XieXueFragment;
import com.aqhg.aqhgfxd.util.CommonUtil;


/**
 *
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private String[] tabs;
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        tabs = CommonUtil.getStringArray(R.array.tab_names);   //标签个数
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new HomeFragment();
        }else if (position == 1){
            return new PinPaiTuanFragment();
        }else{
            return new XieXueFragment();
        }
    }   //前两个写死 后面都用一个fragment 把数据通过构造方法传过去(也就是说规律的话可以用一个fragment)

    @Override
    public int getCount() {
        return tabs.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
