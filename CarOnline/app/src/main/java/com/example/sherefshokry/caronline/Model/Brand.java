package com.example.sherefshokry.caronline.Model;

import java.io.Serializable;
import java.util.ArrayList;


public class Brand {

	private int brandID;
	private String brandName;
	private String brandImage;


	public Brand(int brandID, String brandName, String brandImage) {
		this.brandID = brandID;
		this.brandName = brandName;
		this.brandImage = brandImage;
	}

	public String getBrandImage() {
		return brandImage;
	}
	public void setBrandImage(String brandImage) {
		this.brandImage = brandImage;
	}
	
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


}
