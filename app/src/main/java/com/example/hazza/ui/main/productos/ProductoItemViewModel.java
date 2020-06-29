package com.example.hazza.ui.main.productos;

import androidx.databinding.ObservableField;

import com.example.hazza.ui.base.BaseItemListener;

public class ProductoItemViewModel {
    private final ProductoDataItem productoDataItem;
    private final ProductoItemViewModelListener listener;
    public final ObservableField<String> IdProducto;
    public final ObservableField<String> Nombre;
    public final ObservableField<String> Descripcion;
    public final ObservableField<String> Precio;
    public final ObservableField<String> Stock;
    public final ObservableField<String> Tipo;
    public final ObservableField<String> Foto;


    public ProductoItemViewModel(ProductoDataItem productoDataItem, ProductoItemViewModelListener listener) {
        this.productoDataItem = productoDataItem;
        this.listener = listener;
        IdProducto = new ObservableField<>(""+productoDataItem.getIdProducto());
        Nombre =  new ObservableField<>(productoDataItem.getNombre());;
        Descripcion =  new ObservableField<>(productoDataItem.getDescripcion());;
        Precio =  new ObservableField<>(""+productoDataItem.getPrecio());;
        Stock =  new ObservableField<>(""+productoDataItem.getStock());;
        Tipo =  new ObservableField<>(productoDataItem.getTipo());;
        Foto =  new ObservableField<>(productoDataItem.getFoto());;
    }


    public void onItemClick() {
        listener.onItemClick(productoDataItem);
    }
    public interface ProductoItemViewModelListener extends BaseItemListener<ProductoDataItem> {

    }
}
