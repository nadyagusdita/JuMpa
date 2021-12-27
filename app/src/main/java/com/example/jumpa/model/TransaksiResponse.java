package com.example.jumpa.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TransaksiResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("error")
	private boolean error;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}
}