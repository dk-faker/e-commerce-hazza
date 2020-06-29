package com.example.hazza.ui.main.productos;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductoDataItem implements Parcelable {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;
    private String tipo;
    private String foto;

    public ProductoDataItem(int idProducto, String nombre, String descripcion, Double precio, int stock, String tipo, String foto) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.tipo = tipo;
        this.foto = foto;
    }

    protected ProductoDataItem(Parcel in) {
        idProducto = in.readInt();
        nombre = in.readString();
        descripcion = in.readString();
        if (in.readByte() == 0) {
            precio = null;
        } else {
            precio = in.readDouble();
        }
        stock = in.readInt();
        tipo = in.readString();
        foto = in.readString();
    }

    public static final Creator<ProductoDataItem> CREATOR = new Creator<ProductoDataItem>() {
        @Override
        public ProductoDataItem createFromParcel(Parcel in) {
            return new ProductoDataItem(in);
        }

        @Override
        public ProductoDataItem[] newArray(int size) {
            return new ProductoDataItem[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idProducto);
        parcel.writeString(nombre);
        parcel.writeString(descripcion);
        if (precio == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(precio);
        }
        parcel.writeInt(stock);
        parcel.writeString(tipo);
        parcel.writeString(foto);
    }
}
