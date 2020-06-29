
package com.example.hazza.ui.main.login;

import android.app.Application;

import com.example.hazza.data.AppDataManager;
import com.example.hazza.data.DataManager;
import com.example.hazza.data.model.api.LoginRequest;
import com.example.hazza.ui.base.BaseViewModel;
import com.example.hazza.utils.rx.SchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {


    public LoginViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(application, appDataManager, schedulerProvider);
    }

    public void login(LoginRequest.ServerLoginRequest usuario) {
        setIsLoading(true);
        getCompositeDisposable().add(getAppDataManager()
                .getApiRepository().doServerLoginApiCall(usuario)
                .doOnSuccess(response -> getAppDataManager()
                        .updateUserInfo(
                                response.getToken(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().openMainActivity();
                    System.out.println(response.getToken());
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }


    public void onServerLoginClick() {
        getNavigator().login();
    }
}
