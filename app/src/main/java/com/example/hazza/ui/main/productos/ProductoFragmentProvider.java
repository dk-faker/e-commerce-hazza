package com.example.hazza.ui.main.productos;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ProductoFragmentProvider {

    @ContributesAndroidInjector(modules = ProductoFragmentModule.class)
    abstract ProductoFragment provideProductosFragmentFactory();
}
