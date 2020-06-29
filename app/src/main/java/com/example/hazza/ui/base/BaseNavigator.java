package com.example.hazza.ui.base;

public interface BaseNavigator<T> {

    void handleError(String message);

    void setData(T data);
}
