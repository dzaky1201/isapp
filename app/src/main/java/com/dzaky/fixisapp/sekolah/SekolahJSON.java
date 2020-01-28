package com.dzaky.fixisapp.sekolah;

import com.google.gson.annotations.SerializedName;

public class SekolahJSON {

	public SekolahJSON(int id, String namaSekolah, String nomorHp, String alamat, String images){
		this.id = id;
		this.namaSekolah = namaSekolah;
		this.nomorHp = nomorHp;
		this.alamat = alamat;
		this.images = images;

	}

	private String images;
	private String namaSekolah;
	private int id;
	private String nomorHp;
	private String alamat;

	public void setImages(String images){
		this.images = images;
	}

	public String getImages(){
		return images;
	}

	public void setNamaSekolah(String namaSekolah){
		this.namaSekolah = namaSekolah;
	}

	public String getNamaSekolah(){
		return namaSekolah;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setNomorHp(String nomorHp){
		this.nomorHp = nomorHp;
	}

	public String getNomorHp(){
		return nomorHp;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	@Override
	public String toString(){
		return
				"SekolahJSON{" +
						"images = '" + images + '\'' +
						",nama_sekolah = '" + namaSekolah + '\'' +
						",id = '" + id + '\'' +
						",nomor_hp = '" + nomorHp + '\'' +
						",alamat = '" + alamat + '\'' +
						"}";
	}
}