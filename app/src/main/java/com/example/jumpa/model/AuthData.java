
package com.example.jumpa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthData {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("user_key")
    @Expose
    private String userKey;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

}
