package com.example.hazza.ui.main.categorias;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class CategoriaFragmentProvider {

    @ContributesAndroidInjector(modules = CategoriaFragmentModule.class)
    abstract CategoriasFragment provideCategoriasFragmentFactory();
}
