package com.example.hazza.data.remote.network;

import com.example.hazza.data.model.api.CategoriaResponse;
import com.example.hazza.data.model.api.LoginRequest;
import com.example.hazza.data.model.api.LoginResponse;
import com.example.hazza.data.model.api.ProductosResponse;

import java.util.List;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {


    @POST(ApiEndPoint.ENDPOINT_LOGIN)
    Single<LoginResponse> doServerLoginApiCall(@Body LoginRequest.ServerLoginRequest usuario);

    @GET(ApiEndPoint.ENDPOINT_CATEGORIAS)
    Single<List<CategoriaResponse>>getCategorias(@Header("Authorization") String token);

    @GET(ApiEndPoint.ENDPOINT_PRODUCTOS)
    Single<List<ProductosResponse>>getProductos(@Header("Authorization") String token,@Path("id") int id);

    @POST(ApiEndPoint.ENDPOINT_LOGOUT)
    Single<LoginResponse>doLogoutApiCall(@Header("Authorization") String token);


}
