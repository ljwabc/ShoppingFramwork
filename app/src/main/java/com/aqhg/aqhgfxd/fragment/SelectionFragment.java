package com.aqhg.aqhgfxd.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.aqhg.aqhgfxd.R;
import com.aqhg.aqhgfxd.adapter.MainPagerAdapter;
import com.aqhg.aqhgfxd.global.PagerSlidingTab;

/**
 * Created by Colin.JiaWei on 2017/7/31.
 */
public class SelectionFragment extends BaseFragment {

    private PagerSlidingTab pagerSlidingTab;
    private ViewPager viewPager;

    @Override
    protected int setLayoutResouceId() {

        return R.layout.layout_selection;
    }


    @Override
    protected void findViews() {
        pagerSlidingTab = (PagerSlidingTab) mRootView.findViewById(R.id.slidingTab);
        viewPager = (ViewPager) mRootView.findViewById(R.id.viewPager);
    }

    @Override
    protected void initView() {
        //1.填充ViewPager
        viewPager.setAdapter(new MainPagerAdapter(getChildFragmentManager()));
        //2. 绑定viewpager和indicator
        pagerSlidingTab.setViewPager(viewPager);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void setDataOnView() {

    }


    @Override
    public void onClick(View v) {

    }
}
