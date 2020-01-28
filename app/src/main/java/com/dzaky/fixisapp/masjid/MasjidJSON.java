package com.dzaky.fixisapp.masjid;

import com.google.gson.annotations.SerializedName;
public class MasjidJSON {

	public MasjidJSON(String image, String namaMasjid, int id, String alamat) {
		this.image = image;
		this.namaMasjid = namaMasjid;
		this.id = id;
		this.alamat = alamat;

	}

	@SerializedName("image")
	private String image;

	@SerializedName("nama_masjid")
	private String namaMasjid;

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

	public void setNamaMasjid(String namaMasjid){

		this.namaMasjid = namaMasjid;
	}

	public String getNamaMasjid(){

		return namaMasjid;
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
			"MasjidJSON{" +
			"image = '" + image + '\'' + 
			",nama_masjid = '" + namaMasjid + '\'' + 
			",id = '" + id + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}