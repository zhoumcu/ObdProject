package com.xiaoan.obd.obdproject.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jude.beam.bijection.Presenter;
import com.jude.utils.JUtils;
import com.xiaoan.obd.obdproject.app.APP;
import com.xiaoan.obd.obdproject.entity.User;
import com.xiaoan.obd.obdproject.module.main.HomeActivity;
import com.xiaoan.obd.obdproject.server.DaggerServiceModelComponent;
import com.xiaoan.obd.obdproject.server.SchedulerTransform;
import com.xiaoan.obd.obdproject.server.ServiceAPI;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * author：Administrator on 2016/10/28 09:03
 * company: xxxx
 * email：1032324589@qq.com
 */

public class LoginPresenter extends Presenter<LoginActivity>{

    @Inject
    ServiceAPI serviceAPI;

    @Override
    protected void onCreate(@NonNull LoginActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        DaggerServiceModelComponent.builder().build().inject(this);
    }

    public void login() {
        getView().getExpansion().showProgressPage();
        String phone = getView().phone.getText().toString();
        String mPassword = getView().tvPwd.getText().toString();
        if (phone.length() != 11) {
            getView().phone.setError("手机号格式错误");
            return;
        }
        if (mPassword.length() < 6 || mPassword.length() > 12) {
            getView().tvPwd.setError("密码应为6-12位");
            return;
        }
        serviceAPI.login(phone,mPassword,null)
                .compose(new SchedulerTransform<>())
                .unsafeSubscribe(getLoginSubscriber);
    }
    public void findPwd() {
        this.getView().startActivity(new Intent(this.getView(), FindPwdActivity.class));
    }
    public void findCount() {
        this.getView().startActivity(new Intent(this.getView(), FindAccountActivity.class));
    }

    public void register() {
        this.getView().startActivity(new Intent(this.getView(), RegisterActivity.class));
    }

    Subscriber<User> getLoginSubscriber = new Subscriber<User>() {
        @Override
        public void onCompleted() {

        }
        @Override
        public void onError(Throwable e) {
            JUtils.Toast("登录失败！");
            getView().getExpansion().dismissProgressPage();
        }
        @Override
        public void onNext(User user) {
            JUtils.Toast("登录成功！"+user.getUserCode());
            APP.getInstances().getDaoSession().insert(user);
            getView().getExpansion().dismissProgressPage();
            getView().startActivity(new Intent(getView(), HomeActivity.class));
        }
    };
}

