package com.xiaoan.obd.obdproject.module.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.beam.bijection.BeamFragment;
import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;
import com.xiaoan.obd.obdproject.R;
import com.xiaoan.obd.obdproject.module.main.fragment.chart.MileageFragment;
import com.xiaoan.obd.obdproject.module.main.fragment.chart.OilWeakFragment;
import com.xiaoan.obd.obdproject.module.main.fragment.chart.WeekFragment;
import com.xiaoan.obd.obdproject.widget.CustomViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 11:43
 * company: xxxx
 * email：1032324589@qq.com
 */
public class ChartFragment extends BeamFragment {
    @BindView(R.id.viewPager)
    CustomViewPager viewPager;
    @BindView(R.id.tabs)
    AdvancedPagerSlidingTabStrip tabs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_chart, container, false);
        ButterKnife.bind(this, view);
        viewPager.setAdapter(new myPagerAdapter(getActivity().getSupportFragmentManager()));
        viewPager.setScanScroll(false);
        tabs.setViewPager(viewPager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    private class myPagerAdapter extends FragmentPagerAdapter {
        String[] title = { "本周之最", "油耗排行", "里程排行"};
        WeekFragment mWeekFragment;
        OilWeakFragment mOilWeakFragment;
        MileageFragment mMileageFragment;
        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    mWeekFragment = new WeekFragment();
                    return mWeekFragment;
                case 1:
                    mOilWeakFragment = new OilWeakFragment();
                    return mOilWeakFragment;
                case 2:
                    mMileageFragment = new MileageFragment();
                    return mMileageFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

    }
}
