
package com.example.jumpa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthClass {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("user")
    @Expose
    private AuthData authData;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public AuthData getAuthData() {
        return authData;
    }

    public void setAuthData(AuthData authData) {
        this.authData = authData;
    }

}
