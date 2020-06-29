package com.example.hazza.di.builder;

import com.example.hazza.ui.main.MainActivity;
import com.example.hazza.ui.main.MainActivityModule;
import com.example.hazza.ui.main.categorias.CategoriaFragmentProvider;
import com.example.hazza.ui.main.login.LoginActivity;
import com.example.hazza.ui.main.productos.ProductoFragmentProvider;
import com.example.hazza.ui.main.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            CategoriaFragmentProvider.class,
            ProductoFragmentProvider.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();
}
