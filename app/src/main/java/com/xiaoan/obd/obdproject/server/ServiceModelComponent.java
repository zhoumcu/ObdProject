package com.xiaoan.obd.obdproject.server;

import com.xiaoan.obd.obdproject.module.login.FindAccountPresenter;
import com.xiaoan.obd.obdproject.module.login.FindPwdPresenter;
import com.xiaoan.obd.obdproject.module.login.LoginPresenter;
import com.xiaoan.obd.obdproject.module.login.RegisterActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhuchenxi on 16/1/25.
 */
@Singleton
@Component(modules = {ServiceAPIModule.class})
public interface ServiceModelComponent {

    void inject(LoginPresenter loginPresenter);

    void inject(FindAccountPresenter findAccountPresenter);

    void inject(FindPwdPresenter findPwdPresenter);

    void inject(RegisterActivityPresenter registerActivityPresenter);
}