package com.example.hazza.ui.main.productos;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductoFragmentModule {

    @Provides
    ProductoAdapter provideProductoAdapter() {
        return new ProductoAdapter(new ArrayList<>());
    }
}
