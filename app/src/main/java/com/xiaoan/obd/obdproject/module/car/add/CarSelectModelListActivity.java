package com.xiaoan.obd.obdproject.module.car.add;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.jude.beam.expansion.list.BeamListActivity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.xiaoan.obd.obdproject.R;

/**
 * author：Administrator on 2016/12/12 11:06
 * company: xxxx
 * email：1032324589@qq.com
 */

public class CarSelectModelListActivity extends BeamListActivity{
    @Override
    public BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new CarModelViewHolder(parent);
    }
    @Override
    public int getLayout() {
        return R.layout.aty_carmodle;
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
