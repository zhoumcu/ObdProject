package com.xiaoan.obd.obdproject.module.tire;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.jude.beam.expansion.BeamBaseActivity;
import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;
import com.xiaoan.obd.obdproject.R;
import com.xiaoan.obd.obdproject.module.tire.fragment.CarConditionFragment;
import com.xiaoan.obd.obdproject.module.tire.fragment.TpmsFragment;
import com.xiaoan.obd.obdproject.module.tire.fragment.TravelDistanceFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 11:36
 * company: xxxx
 * email：1032324589@qq.com
 */
public class TireHomeActivity extends BeamBaseActivity {
    @BindView(R.id.tabs)
    AdvancedPagerSlidingTabStrip tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_tirehome);
        ButterKnife.bind(this);
        viewPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(viewPager);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case android.R.id.home:
                // 处理返回逻辑
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private class myPagerAdapter extends FragmentPagerAdapter {
        String[] title = {"行程", "胎压监测","车况"};
        TravelDistanceFragment mTravelDistanceFragment;
        TpmsFragment mTpmsFragment;
        CarConditionFragment mCarConditionFragment;
        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    mTravelDistanceFragment = new TravelDistanceFragment();
                    return mTravelDistanceFragment;
                case 1:
                    mTpmsFragment = new TpmsFragment();
                    return mTpmsFragment;
                case 2:
                    mCarConditionFragment = new CarConditionFragment();
                    return mCarConditionFragment;
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
