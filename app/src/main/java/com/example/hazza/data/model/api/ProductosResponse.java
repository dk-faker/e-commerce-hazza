package com.example.hazza.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductosResponse {
    @Expose
    @SerializedName("IdProducto")
    private int idProducto;

    @Expose
    @SerializedName("Nombre")
    private String nombre;

    @Expose
    @SerializedName("Descripcion")
    private String descripcion;

    @Expose
    @SerializedName("Precio")
    private Double precio;

    @Expose
    @SerializedName("Stock")
    private int stock;

    @Expose
    @SerializedName("Tipo")
    private String tipo;

    @Expose
    @SerializedName("Foto")
    private String foto;

    public ProductosResponse(int idProducto, String nombre, String descripcion, Double precio, int stock, String tipo, String foto) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.tipo = tipo;
        this.foto = foto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFoto() {
        return foto;
    }
}
