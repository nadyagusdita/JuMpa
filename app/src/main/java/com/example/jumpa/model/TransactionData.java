package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class TransactionData {

	@SerializedName("id")
	private String id;

	@SerializedName("tanggal")
	private String tanggal;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}
}