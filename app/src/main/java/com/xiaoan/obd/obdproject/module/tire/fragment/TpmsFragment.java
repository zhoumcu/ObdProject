package com.xiaoan.obd.obdproject.module.tire.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.beam.bijection.BeamFragment;
import com.xiaoan.obd.obdproject.R;

import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/9 10:28
 * company: xxxx
 * email：1032324589@qq.com
 */
public class TpmsFragment extends BeamFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_tiretpms, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
