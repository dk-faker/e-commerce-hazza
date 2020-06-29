
package com.example.hazza.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public final class LoginRequest {

    private LoginRequest() {
    }

    public static class ServerLoginRequest {

        @Expose
        @SerializedName("Username")
        private String username;

        @Expose
        @SerializedName("Password")
        private String password;

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }

            ServerLoginRequest that = (ServerLoginRequest) object;

            if (username != null ? !username.equals(that.username) : that.username != null) {
                return false;
            }
            return password != null ? password.equals(that.password) : that.password == null;
        }

        @Override
        public int hashCode() {
            int result = username != null ? username.hashCode() : 0;
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }


        public ServerLoginRequest() {
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
