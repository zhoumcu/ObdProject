package com.xiaoan.obd.obdproject.module.main;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.jude.beam.expansion.BeamBaseActivity;
import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;
import com.xiaoan.obd.obdproject.R;
import com.xiaoan.obd.obdproject.module.main.fragment.ChartFragment;
import com.xiaoan.obd.obdproject.module.main.fragment.ConditionFragment;
import com.xiaoan.obd.obdproject.module.main.fragment.HomeFragment;
import com.xiaoan.obd.obdproject.module.main.fragment.ItineraryFragment;
import com.xiaoan.obd.obdproject.module.main.fragment.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 11:36
 * company: xxxx
 * email：1032324589@qq.com
 */
public class HomeActivity extends BeamBaseActivity {
    @BindView(R.id.tabs)
    AdvancedPagerSlidingTabStrip tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(viewPager);
        tabs.showDot(0, "99+");
    }
    private class myPagerAdapter extends FragmentPagerAdapter implements AdvancedPagerSlidingTabStrip.IconTabProvider{
        String[] title = { "首页", "行程", "车况","排行","我的" };
        int[] iconNo = {R.mipmap.home_auther_icon_f_n, R.mipmap.home_auther_icon_f_n, R.mipmap.home_auther_icon_f_n, R.mipmap.home_auther_icon_f_n,R.mipmap.home_auther_icon_f_n };
        int[] iconSelt = {R.mipmap.home_auther_icon_f_p, R.mipmap.home_auther_icon_f_p,R.mipmap.home_auther_icon_f_p,R.mipmap.home_auther_icon_f_p,R.mipmap.home_auther_icon_f_p };
        HomeFragment mHomeFragment;
        ItineraryFragment mItineraryFragment;
        ConditionFragment mConditionFragment;
        ChartFragment mChartFragment;
        MineFragment mMineFragment;
        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    mHomeFragment = new HomeFragment();
                    return mHomeFragment;
                case 1:
                    mItineraryFragment = new ItineraryFragment();
                    return mItineraryFragment;
                case 2:
                    mConditionFragment = new ConditionFragment();
                    return mConditionFragment;
                case 3:
                    mChartFragment = new ChartFragment();
                    return mChartFragment;
                case 4:
                    mMineFragment = new MineFragment();
                    return mMineFragment;
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

        @Override
        public Integer getPageIcon(int position) {
            return iconNo[position];
        }

        @Override
        public Integer getPageSelectIcon(int position) {
            return iconSelt[position];
        }

        @Override
        public Rect getPageIconBounds(int position) {
            return null;
        }
    }
}
