/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.example.hazza.ui.main.login;

import android.app.Application;

import com.example.hazza.data.AppDataManager;
import com.example.hazza.data.DataManager;
import com.example.hazza.data.model.api.LoginRequest;
import com.example.hazza.ui.base.BaseViewModel;
import com.example.hazza.utils.rx.SchedulerProvider;


/**
 * Created by amitshekhar on 08/07/17.
 */

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
