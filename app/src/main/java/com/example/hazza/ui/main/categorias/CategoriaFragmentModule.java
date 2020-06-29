package com.example.hazza.ui.main.categorias;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoriaFragmentModule {

    @Provides
    CategoariaAdapter provideCategoriaAdapter() {
        return new CategoariaAdapter(new ArrayList<>());
    }
}
