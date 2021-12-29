package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class EditTransaksi{

	@SerializedName("error")
	private boolean error;

	@SerializedName("transaction")
	private Transaction transaction;

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setTransaction(Transaction transaction){
		this.transaction = transaction;
	}

	public Transaction getTransaction(){
		return transaction;
	}
}