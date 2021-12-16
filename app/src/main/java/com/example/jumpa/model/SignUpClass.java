package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class SignUpClass {

	@SerializedName("error")
	private boolean error;

	@SerializedName("user")
	private SignUpData signUpData;

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setSignUpData(SignUpData signUpData){
		this.signUpData = signUpData;
	}

	public SignUpData getSignUpData(){
		return signUpData;
	}
}