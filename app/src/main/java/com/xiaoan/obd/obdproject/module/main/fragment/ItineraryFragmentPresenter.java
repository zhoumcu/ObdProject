package com.xiaoan.obd.obdproject.module.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.xiaoan.obd.obdproject.entity.ItineraryBean;
import com.xiaoan.obd.obdproject.module.travel.TravelInfoActivity;
import com.xiaoan.obd.obdproject.server.SchedulerTransform;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * author：Administrator on 2016/12/8 11:52
 * company: xxxx
 * email：1032324589@qq.com
 */
public class ItineraryFragmentPresenter extends BeamListFragmentPresenter<ItineraryFragment,ItineraryBean>{
    @Override
    protected void onCreate(@NonNull ItineraryFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }
    @Override
    protected void onCreateView(@NonNull ItineraryFragment view) {
        super.onCreateView(view);
        getAdapter().setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(getView().getContext(),TravelInfoActivity.class);
                getView().startActivity(i);
            }
        });
    }
    private void initData(){
        List<ItineraryBean> o = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            o.add(new ItineraryBean("2016-10-23","2016-11-23"));
        }
        Observable<List<ItineraryBean>> observable = Observable.just(o);
        observable.compose(new SchedulerTransform<>())
                .unsafeSubscribe(getRefreshSubscriber());
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        initData();
    }
}
