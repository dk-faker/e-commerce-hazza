package com.example.hazza.ui.main.splash;

import android.app.Application;

import com.example.hazza.data.AppDataManager;
import com.example.hazza.data.DataManager;
import com.example.hazza.ui.base.BaseViewModel;
import com.example.hazza.utils.rx.SchedulerProvider;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(application, appDataManager, schedulerProvider);
    }

    public void startSeeding() {
        getCompositeDisposable().add(getAppDataManager()
                .seedDatabaseQuestions()
                .flatMap(aBoolean -> getAppDataManager().seedDatabaseOptions())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(aBoolean -> {
                    decideNextActivity();
                }, throwable -> {
                    decideNextActivity();
                }));
    }

    public void validateToken() {
        getCompositeDisposable().add(getAppDataManager().getApiRepository().getCategorias()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(articlesResponse -> {
                    System.out.println(articlesResponse);
                    if (articlesResponse != null) {
                        authenticated(true);
                    }
                }, throwable -> {
                    System.out.println(throwable.getMessage());
                    authenticated(false);
                }));
    }

    public void authenticated(boolean bool){
        if(bool){
            getNavigator().openMainActivity();
        }else{
            getNavigator().openLoginActivity();
        }
    }

    private void decideNextActivity() {
        if (getAppDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getNavigator().openLoginActivity();
        }else if(getAppDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER.getType()){
            validateToken();
        }
    }
}
