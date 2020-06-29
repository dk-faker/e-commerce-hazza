package com.example.hazza.ui.main.categorias;

import androidx.databinding.ObservableField;

import com.example.hazza.ui.base.BaseItemListener;

public class CategoriaItemViewModel {

    private final CategoriaDataItem categoriaDataItem;
    private final CategoriaItemViewModelListener mListener;
    public final ObservableField<String>IdCategoria;
    public final ObservableField<String>Nombre;
    public final ObservableField<String>Foto;

    public CategoriaItemViewModel(CategoriaDataItem categoriaDataItem, CategoriaItemViewModelListener mListener) {
        this.categoriaDataItem = categoriaDataItem;
        this.mListener = mListener;
        IdCategoria= new ObservableField<>(""+categoriaDataItem.getIdCategoria());
        Nombre= new ObservableField<>(categoriaDataItem.getNombre());
        Foto= new ObservableField<>(categoriaDataItem.getFoto());
    }
    public void onItemClick() {
        mListener.onItemClick(categoriaDataItem);
    }
    public interface CategoriaItemViewModelListener extends BaseItemListener<CategoriaDataItem> {

    }
}
