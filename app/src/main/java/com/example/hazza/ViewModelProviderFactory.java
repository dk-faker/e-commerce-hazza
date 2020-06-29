package com.example.hazza;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.hazza.data.AppDataManager;
import com.example.hazza.ui.main.MainViewModel;
import com.example.hazza.ui.main.categorias.CategoriaViewModel;
import com.example.hazza.ui.main.login.LoginViewModel;
import com.example.hazza.ui.main.productos.ProductoViewModel;
import com.example.hazza.ui.main.splash.SplashViewModel;
import com.example.hazza.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {
    private final Application application;
    private final AppDataManager appDataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        this.application = application;
        this.appDataManager = appDataManager;
        this.schedulerProvider = schedulerProvider;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(application, appDataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
                //noinspection unchecked
                return (T) new SplashViewModel(application, appDataManager, schedulerProvider);

        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel(application, appDataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(CategoriaViewModel.class)) {
            //noinspection unchecked
            return (T) new CategoriaViewModel(application, appDataManager, schedulerProvider);
        }
        else if (modelClass.isAssignableFrom(ProductoViewModel.class)) {
            //noinspection unchecked
            return (T) new ProductoViewModel(application, appDataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}