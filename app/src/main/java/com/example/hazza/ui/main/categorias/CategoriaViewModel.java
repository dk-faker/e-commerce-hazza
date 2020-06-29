package com.example.hazza.ui.main.categorias;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.hazza.data.AppDataManager;
import com.example.hazza.data.model.api.CategoriaResponse;
import com.example.hazza.ui.base.BaseViewModel;
import com.example.hazza.utils.rx.SchedulerProvider;
import java.util.ArrayList;
import java.util.List;

public class CategoriaViewModel extends BaseViewModel<CategoriaNavigator> {

    private MutableLiveData<List<CategoriaDataItem>> categoriaLiveData;

    public CategoriaViewModel(Application application, AppDataManager appDataManager, SchedulerProvider schedulerProvider) {
        super(application, appDataManager, schedulerProvider);
        categoriaLiveData= new MutableLiveData<>();
    }

    public void getCategorias() {
        setIsLoading(true);
        getCompositeDisposable().add(getAppDataManager().getApiRepository().getCategorias()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(articlesResponse -> {
                    if (articlesResponse != null) {
                        mapArticlesDataItem(articlesResponse);
                    }
                    System.out.println(articlesResponse);
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable.getMessage());
                }));
    }


    private void mapArticlesDataItem(List<CategoriaResponse> categorias) {
        List<CategoriaDataItem> categoriaDataItems = new ArrayList<>();

        for (CategoriaResponse categoriaResponse : categorias) {
            categoriaDataItems.add(new CategoriaDataItem(
                    categoriaResponse.getIdCategoria(),
                    categoriaResponse.getNombre(),
                    categoriaResponse.getFoto()
            ));
        }
        categoriaLiveData.setValue(categoriaDataItems);
    }
    public LiveData<List<CategoriaDataItem>> getCategoriaLiveDataLiveData() {
        return categoriaLiveData;
    }

}
