package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class DashboardResponse{

	@SerializedName("data")
	private DataDashboard dataDashboard;

	@SerializedName("error")
	private boolean error;

<<<<<<< HEAD
	public void setDataDashboard(DataDashboard dataDashboard){
=======
	public void setData(DataDashboard dataDashboard){
>>>>>>> 181ebd7de8b82a152648dd0a98d2b0c766ce28aa
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