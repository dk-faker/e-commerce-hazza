package com.example.hazza.data.remote;

import com.example.hazza.data.model.api.CategoriaResponse;
import com.example.hazza.data.model.api.LoginRequest;
import com.example.hazza.data.model.api.LoginResponse;
import com.example.hazza.data.model.api.ProductosResponse;
import com.example.hazza.data.remote.network.ApiHeader;
import com.example.hazza.data.remote.network.ApiService;
import com.example.hazza.di.ApiInfo;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class ApiRepository implements ApiDataSource {
    private final String apiKey;
    private ApiService apiService;
    private ApiHeader mApiHeader;

    @Inject
    public ApiRepository(ApiService apiService, @ApiInfo String apiKey,ApiHeader apiHeader) {
        this.apiKey = apiKey;
        this.apiService = apiService;
        this.mApiHeader=apiHeader;
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return apiService.doServerLoginApiCall(request);
    }

    @Override
    public Single<List<CategoriaResponse>> getCategorias() {
        return apiService.getCategorias(mApiHeader.getProtectedApiHeader().getToken());
    }

    @Override
    public Single<List<ProductosResponse>> getProductos(int id) {
        return apiService.getProductos(mApiHeader.getProtectedApiHeader().getToken(),id);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }
}
