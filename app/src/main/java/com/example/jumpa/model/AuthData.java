package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class AuthData {

	@SerializedName("unique_id")
	private String uniqueId;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setUniqueId(String uniqueId){
		this.uniqueId = uniqueId;
	}

	public String getUniqueId(){
		return uniqueId;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}