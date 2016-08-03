package com.example.sherefshokry.caronline.Model;

import java.io.Serializable;
public class ServiceCenters {
	private int    centerId; 
	private	String centerName;
	private	String centerAddress;
	private	String centerPhone;
	private	String centerWorkingHours;
	private	String centerHolidays;
	
	
	
	public ServiceCenters(int centerId, String centerName,
			String centerAddress, String centerPhone,
			String centerWorkingHours, String centerHolidays) {

		this.centerId = centerId;
		this.centerName = centerName;
		this.centerAddress = centerAddress;
		this.centerPhone = centerPhone;
		this.centerWorkingHours = centerWorkingHours;
		this.centerHolidays = centerHolidays;
	}

	public int getCenterId() {
		return centerId;
	}
	
	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	public String getCenterPhone() {
		return centerPhone;
	}
	public void setCenterPhone(String centerPhone) {
		this.centerPhone = centerPhone;
	}
	public String getCenterWorkingHours() {
		return centerWorkingHours;
	}
	public void setCenterWorkingHours(String centerWorkingHours) {
		this.centerWorkingHours = centerWorkingHours;
	}
	public String getCenterHolidays() {
		return centerHolidays;
	}
	public void setCenterHolidays(String centerHolidays) {
		this.centerHolidays = centerHolidays;
	}

	
	
}
