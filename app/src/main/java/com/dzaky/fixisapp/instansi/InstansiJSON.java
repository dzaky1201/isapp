package com.dzaky.fixisapp.instansi;

import com.google.gson.annotations.SerializedName;

public class InstansiJSON{

	public InstansiJSON(String image, String lembaga, String namaInstansi, String jenisLayanan, int id, String alamat){
		this.id = id;
		this.namaInstansi = namaInstansi;
		this.jenisLayanan = jenisLayanan;
		this.lembaga = lembaga;
		this.alamat = alamat;
		this.image = image;
	}

	@SerializedName("image")
	private String image;

	@SerializedName("lembaga")
	private String lembaga;

	@SerializedName("nama_Instansi")
	private String namaInstansi;

	@SerializedName("jenis_layanan")
	private String jenisLayanan;

	@SerializedName("id")
	private int id;

	@SerializedName("alamat")
	private String alamat;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setLembaga(String lembaga){
		this.lembaga = lembaga;
	}

	public String getLembaga(){
		return lembaga;
	}

	public void setNamaInstansi(String namaInstansi){
		this.namaInstansi = namaInstansi;
	}

	public String getNamaInstansi(){
		return namaInstansi;
	}

	public void setJenisLayanan(String jenisLayanan){
		this.jenisLayanan = jenisLayanan;
	}

	public String getJenisLayanan(){
		return jenisLayanan;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
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
			"InstansiJSON{" + 
			"image = '" + image + '\'' + 
			",lembaga = '" + lembaga + '\'' + 
			",nama_Instansi = '" + namaInstansi + '\'' + 
			",jenis_layanan = '" + jenisLayanan + '\'' + 
			",id = '" + id + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}