package com.xiaoan.obd.obdproject.module.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jude.beam.bijection.Presenter;
import com.xiaoan.obd.obdproject.module.car.CarListActivity;

/**
 * author：Administrator on 2016/12/13 15:10
 * company: xxxx
 * email：1032324589@qq.com
 */
public class MineFragmentPresenter extends Presenter<MineFragment> {
    @Override
    protected void onCreate(@NonNull MineFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
    }

    public void goCarActivity() {
        getView().startActivity(new Intent(getView().getActivity(), CarListActivity.class));
    }
}
