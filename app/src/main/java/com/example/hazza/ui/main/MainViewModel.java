package com.example.hazza.ui.main;

import android.app.Application;

import com.example.hazza.data.AppDataManager;
import com.example.hazza.ui.base.BaseViewModel;
import com.example.hazza.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel {

    public MainViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(application, appDataManager, schedulerProvider);
    }
}
