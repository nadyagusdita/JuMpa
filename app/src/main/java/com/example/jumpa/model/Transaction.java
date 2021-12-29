package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class Transaction{

	@SerializedName("id")
	private String id;

	@SerializedName("status")
	private String status;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}