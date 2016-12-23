package com.xiaoan.obd.obdproject.module.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jude.beam.bijection.Presenter;
import com.xiaoan.obd.obdproject.module.tire.TireHomeActivity;
import com.xiaoan.obd.obdproject.module.trouble.TroubleCodeSearchActivity;

/**
 * author：Administrator on 2016/12/8 11:47
 * company: xxxx
 * email：1032324589@qq.com
 */
public class HomeFragmentPresenter extends Presenter<HomeFragment> {
    @Override
    protected void onCreate(@NonNull HomeFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
    }
    public void openTire(){
        this.getView().startActivity(new Intent(this.getView().getActivity(), TireHomeActivity.class));
    }

    public void searchCode() {
        this.getView().startActivity(new Intent(this.getView().getActivity(), TroubleCodeSearchActivity.class));
    }
}
