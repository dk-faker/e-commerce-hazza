package com.example.hazza.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriaResponse {

    @Expose
    @SerializedName("IdCategoria")
    private int idCategoria;

    @Expose
    @SerializedName("Nombre")
    private String nombre;

    @Expose
    @SerializedName("Foto")
    private String foto;

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFoto() {
        return foto;
    }

    public CategoriaResponse() {
    }
}
