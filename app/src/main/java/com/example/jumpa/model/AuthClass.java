package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class AuthClass{

	@SerializedName("error")
	private boolean error;

	@SerializedName("user")
	private AuthData authData;

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setAuthData(AuthData authData){
		this.authData = authData;
	}

	public AuthData getAuthData(){
		return authData;
	}
}