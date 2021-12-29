package com.example.jumpa.model;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("berat_total")
	private String beratTotal;

	@SerializedName("foto_sampah")
	private Object fotoSampah;

	@SerializedName("no_ponsel")
	private String noPonsel;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("waktu")
	private String waktu;

	@SerializedName("total_harga")
	private String totalHarga;

	@SerializedName("id")
	private String id;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("kategori_sampah")
	private String kategoriSampah;

	@SerializedName("unique_code")
	private Object uniqueCode;

	@SerializedName("alamat")
	private Object alamat;

	@SerializedName("status")
	private Object status;

	public void setBeratTotal(String beratTotal){
		this.beratTotal = beratTotal;
	}

	public Object getBeratTotal(){
		return beratTotal;
	}

	public void setFotoSampah(Object fotoSampah){
		this.fotoSampah = fotoSampah;
	}

	public Object getFotoSampah(){
		return fotoSampah;
	}

	public void setNoPonsel(String noPonsel){
		this.noPonsel = noPonsel;
	}

	public String getNoPonsel(){
		return noPonsel;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setWaktu(String waktu){
		this.waktu = waktu;
	}

	public String getWaktu(){
		return waktu;
	}

	public void setTotalHarga(String totalHarga){
		this.totalHarga = totalHarga;
	}

	public Object getTotalHarga(){
		return totalHarga;
	}

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

	public void setKategoriSampah(String kategoriSampah){
		this.kategoriSampah = kategoriSampah;
	}

	public String getKategoriSampah(){
		return kategoriSampah;
	}

	public void setUniqueCode(Object uniqueCode){
		this.uniqueCode = uniqueCode;
	}

	public Object getUniqueCode(){
		return uniqueCode;
	}

	public void setAlamat(Object alamat){
		this.alamat = alamat;
	}

	public Object getAlamat(){
		return alamat;
	}

	public void setStatus(Object status){
		this.status = status;
	}

	public Object getStatus(){
		return status;
	}
}