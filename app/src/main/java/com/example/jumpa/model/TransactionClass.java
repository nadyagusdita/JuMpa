package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class TransactionClass{

	@SerializedName("error")
	private boolean error;

	@SerializedName("transaction")
	private TransactionData transactionData;

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setTransactionData(TransactionData transactionData){
		this.transactionData = transactionData;
	}

	public TransactionData getTransactionData(){
		return transactionData;
	}
}