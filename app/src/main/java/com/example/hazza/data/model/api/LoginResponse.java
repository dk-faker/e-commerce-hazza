
package com.example.hazza.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public final class LoginResponse {

    @Expose
    @SerializedName("data")
    private List<TokenResponse> data;

    @Expose
    @SerializedName("token")
    private String token;

    @Expose
    @SerializedName("fb_profile_pic_url")
    private String fbProfilePicUrl;

    @Expose
    @SerializedName("google_profile_pic_url")
    private String googleProfilePicUrl;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("server_profile_pic_url")
    private String serverProfilePicUrl;

    @Expose
    @SerializedName("status_code")
    private String statusCode;

    @Expose
    @SerializedName("Descripcion")
    private String Descripcion;

    @Expose
    @SerializedName("user_id")
    private Long userId;

    @Expose
    @SerializedName("user_name")
    private String userName;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        LoginResponse that = (LoginResponse) object;

        if (statusCode != null ? !statusCode.equals(that.statusCode) : that.statusCode != null) {
            return false;
        }
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) {
            return false;
        }
        if (token != null ? !token.equals(that.token) : that.token != null) {
            return false;
        }
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) {
            return false;
        }
        if (Descripcion != null ? !Descripcion.equals(that.Descripcion) : that.Descripcion != null) {
            return false;
        }
        if (serverProfilePicUrl != null ? !serverProfilePicUrl.equals(that.serverProfilePicUrl)
                : that.serverProfilePicUrl != null) {
            return false;
        }
        if (fbProfilePicUrl != null ? !fbProfilePicUrl.equals(that.fbProfilePicUrl)
                : that.fbProfilePicUrl != null) {
            return false;
        }
        if (googleProfilePicUrl != null ? !googleProfilePicUrl.equals(that.googleProfilePicUrl)
                : that.googleProfilePicUrl != null) {
            return false;
        }
        return message != null ? message.equals(that.message) : that.message == null;

    }

    @Override
    public int hashCode() {
        int result = statusCode != null ? statusCode.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (Descripcion != null ? Descripcion.hashCode() : 0);
        result = 31 * result + (serverProfilePicUrl != null ? serverProfilePicUrl.hashCode() : 0);
        result = 31 * result + (fbProfilePicUrl != null ? fbProfilePicUrl.hashCode() : 0);
        result = 31 * result + (googleProfilePicUrl != null ? googleProfilePicUrl.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    public String getToken() {

        for(LoginResponse.TokenResponse str : getData())
        {
            token = str.getToken();
        }
      return token;
    }

    public List<TokenResponse> getData() {
        return data;
    }

    public LoginResponse() {
    }

    public static final  class TokenResponse{

       @Expose
       @SerializedName("Token")
        private String token;

       public String getToken() {
           return token;
       }
   }
}
