package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class DataDashboard {

	@SerializedName("berat_total")
	private String beratTotal;

	@SerializedName("total_harga")
	private String totalHarga;

	public void setBeratTotal(String beratTotal){
		this.beratTotal = beratTotal;
	}

	public String getBeratTotal(){
		return beratTotal;
	}

	public void setTotalHarga(String totalHarga){
		this.totalHarga = totalHarga;
	}

	public String getTotalHarga(){
		return totalHarga;
	}
}