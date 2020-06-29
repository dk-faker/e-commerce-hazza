package com.example.hazza.data.remote;

import com.example.hazza.data.model.api.CategoriaResponse;
import com.example.hazza.data.model.api.LoginRequest;
import com.example.hazza.data.model.api.LoginResponse;
import com.example.hazza.data.model.api.ProductosResponse;
import com.example.hazza.data.remote.network.ApiHeader;
import java.util.List;

import io.reactivex.Single;

public interface ApiDataSource {



    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<List<CategoriaResponse>> getCategorias();

    Single<List<ProductosResponse>> getProductos(int id);

    ApiHeader getApiHeader();
}
