package com.example.hazza.ui.main.productos;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.hazza.data.AppDataManager;
import com.example.hazza.data.model.api.ProductosResponse;
import com.example.hazza.ui.base.BaseViewModel;
import com.example.hazza.utils.rx.SchedulerProvider;
import java.util.ArrayList;
import java.util.List;

public class ProductoViewModel extends BaseViewModel<ProductoNavigator> {

    private MutableLiveData<List<ProductoDataItem>> productoLiveData;

    public ProductoViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(application, appDataManager, schedulerProvider);
        productoLiveData= new MutableLiveData<>();
    }

    public void getProductos(int id) {
        setIsLoading(true);
        getCompositeDisposable().add(getAppDataManager().getApiRepository().getProductos(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(productoResponse -> {
                    if (productoResponse != null) {
                        mapArticlesDataItem(productoResponse);
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable.getMessage());
                }));
    }

    private void mapArticlesDataItem(List<ProductosResponse> productos) {
        List<ProductoDataItem> productoDataItems = new ArrayList<>();
        for (ProductosResponse productosResponse : productos) {
                    productoDataItems.add(new ProductoDataItem(
                            productosResponse.getIdProducto(),
                    productosResponse.getNombre(),
                    productosResponse.getDescripcion(),
                    productosResponse.getPrecio(),
                    productosResponse.getStock(),
                    productosResponse.getTipo(),
                    productosResponse.getFoto()
            ));
        }
        productoLiveData.setValue(productoDataItems);
    }

    public LiveData<List<ProductoDataItem>> getProductoLiveDataLiveData() {
        return productoLiveData;
    }
}
