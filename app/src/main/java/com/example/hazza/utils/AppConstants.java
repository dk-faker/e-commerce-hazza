package com.example.hazza.utils;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hazza.BuildConfig;

public final class AppConstants {

    public static final String DB_NAME = BuildConfig.APPLICATION_ID + ".db";

    public static final String PREF_NAME = BuildConfig.APPLICATION_ID + "_pref";
    public static String TOKEN="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZTg2YWQ5MDFjOWQ0NDAwMDA0OWRjODMiLCJpYXQiOjE1ODU5MzA0MjB9.xkY0FlF4vneIKRgk6ahfinMQZy4Fsp9CXardNrp_xA0";
    public static final String ARTICLE = "article";

    public static final int VIEW_TYPE_EMPTY = 0;
    public static int CONNECTION_INTERNET=0;
    public static int INTERNET=0;
    public static View viewConstant;
    public static  String URL_BD = "http://143.137.145.236:8190";
           // "http://104.211.62.150";///

    public static int COD_FRA = 0;



    public static final int VIEW_TYPE_NORMAL = 1;
    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";
}
