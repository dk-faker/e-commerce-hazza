package com.example.hazza.data.model.api;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
    @SerializedName("status")
    public String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @SuppressWarnings({"unused", "used by Retrofit"})
    public ErrorResponse() {
    }

    public ErrorResponse(String status) {
        this.status = status;
    }
}
