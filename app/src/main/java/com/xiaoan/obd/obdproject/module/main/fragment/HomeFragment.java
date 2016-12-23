package com.xiaoan.obd.obdproject.module.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.beam.bijection.BeamFragment;
import com.jude.beam.bijection.RequiresPresenter;
import com.xiaoan.obd.obdproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 11:39
 * company: xxxx
 * email：1032324589@qq.com
 */
@RequiresPresenter(HomeFragmentPresenter.class)
public class HomeFragment extends BeamFragment<HomeFragmentPresenter> {

    @BindView(R.id.img_open)
    ImageView imgOpen;
    @BindView(R.id.tv_searchcode)
    TextView tvSearchcode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_home, container, false);
        ButterKnife.bind(this, view);
        imgOpen.setOnClickListener(view1 -> getPresenter().openTire());
        tvSearchcode.setOnClickListener(view1 -> getPresenter().searchCode());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
