package com.example.sherefshokry.caronline.Model;

import java.io.Serializable;
public class Car {

	private int carID;
	private String carName;
	private String carDescription;
	private double carPrice;
	private String carPic;
	
	
	public Car(int carID, String carName, String carDescription,
			double carPrice, String carPic) {
		this.carID = carID;
		this.carName = carName;
		this.carDescription = carDescription;
		this.carPrice = carPrice;
		this.carPic = carPic;
	}

	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarDescription() {
		return carDescription;
	}
	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	public String getCarPic() {
		return carPic;
	}
	public void setCarPic(String carPic) {
		this.carPic = carPic;
	}

}