
package com.example.hazza.data.remote.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiHeader {

    private ProtectedApiHeader mProtectedApiHeader;

    @Inject
    public ApiHeader(ProtectedApiHeader protectedApiHeader) {
        mProtectedApiHeader = protectedApiHeader;
    }

    public ProtectedApiHeader getProtectedApiHeader() {
        return mProtectedApiHeader;
    }

    public static final class ProtectedApiHeader {


        @Expose
        @SerializedName("token")
        private String token;

        public ProtectedApiHeader(String mToken) {
            this.token=mToken;

        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

}
