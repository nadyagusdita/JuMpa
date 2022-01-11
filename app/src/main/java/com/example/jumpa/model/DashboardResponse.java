package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class DashboardResponse{

	@SerializedName("data")
	private DataDashboard dataDashboard;

	@SerializedName("error")
	private boolean error;

	public void setData(DataDashboard dataDashboard){
		this.dataDashboard = dataDashboard;
	}

	public DataDashboard getData(){
		return dataDashboard;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}
}