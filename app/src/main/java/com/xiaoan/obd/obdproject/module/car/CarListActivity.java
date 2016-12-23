package com.xiaoan.obd.obdproject.module.car;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListActivity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.xiaoan.obd.obdproject.entity.CarBean;

/**
 * author：Administrator on 2016/12/12 10:45
 * company: xxxx
 * email：1032324589@qq.com
 */
@RequiresPresenter(CarListPresenter.class)
public class CarListActivity extends BeamListActivity<CarListPresenter,CarBean>{
    @Override
    public BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new CarListViewHolder(parent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
