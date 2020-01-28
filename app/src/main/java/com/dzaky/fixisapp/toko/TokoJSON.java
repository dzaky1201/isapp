package com.dzaky.fixisapp.toko;

import com.google.gson.annotations.SerializedName;

public class TokoJSON{

	public TokoJSON(String jenis, String image, String namaToko, int id, String nomorHp, String alamat) {
		this.jenis = jenis;
		this.image = image;
		this.namaToko = namaToko;
		this.nomorHp = nomorHp;
		this.id = id;
		this.alamat = alamat;

	}

	@SerializedName("jenis")
	private String jenis;

	@SerializedName("image")
	private String image;

	@SerializedName("nama_toko")
	private String namaToko;

	@SerializedName("id")
	private int id;

	@SerializedName("nomor_hp")
	private String nomorHp;

	@SerializedName("alamat")
	private String alamat;

	public void setJenis(String jenis){
		this.jenis = jenis;
	}

	public String getJenis(){
		return jenis;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setNamaToko(String namaToko){
		this.namaToko = namaToko;
	}

	public String getNamaToko(){
		return namaToko;
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
			"TokoJSON{" + 
			"nama_pemilik = '" + jenis + '\'' +
			",image = '" + image + '\'' + 
			",jenis_dagangan = '" + namaToko + '\'' +
			",id = '" + id + '\'' + 
			",nomor_hp = '" + nomorHp + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}