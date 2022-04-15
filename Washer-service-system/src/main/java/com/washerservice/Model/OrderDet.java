package com.washerservice.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class OrderDet {

@Id
	
	private int orderId;
    private String carName;
    private String carModel;
	private String washerName;
	private int washpackId;
	private String date;
	private Long contactno;

	
	
	public OrderDet() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public int getWashpackId() {
		return washpackId;
	}
	public void setWashpackId(int washpackId) {
		this.washpackId = washpackId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getContactno() {
		return contactno;
	}
	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}

	
	
	
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", carName=" + carName + ", carModel=" + carModel + ", washerName="
				+ washerName + ", washpackId=" + washpackId + ", date=" + date + ", contactno=" + contactno + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
