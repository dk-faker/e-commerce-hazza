package com.example.hazza.ui.main.categorias;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoriaDataItem implements Parcelable {

    private int idCategoria;
    private String nombre;
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

    public CategoriaDataItem(int idCategoria, String nombre, String foto) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.foto = foto;
    }

    protected CategoriaDataItem(Parcel in) {
        idCategoria = in.readInt();
        nombre = in.readString();
        foto = in.readString();
    }

    public static final Creator<CategoriaDataItem> CREATOR = new Creator<CategoriaDataItem>() {
        @Override
        public CategoriaDataItem createFromParcel(Parcel in) {
            return new CategoriaDataItem(in);
        }

        @Override
        public CategoriaDataItem[] newArray(int size) {
            return new CategoriaDataItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idCategoria);
        parcel.writeString(nombre);
        parcel.writeString(foto);
    }
}
