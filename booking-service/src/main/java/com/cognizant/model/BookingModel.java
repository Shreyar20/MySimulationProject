package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="booking")
public class BookingModel {

	@Id
	@Column(name="bookingid") 
	private long bookingId;
	
	@Column(name="userid")
	private long userId;
	
	@Column(name="serviceid")
	private long serviceId;
	
	@Column(name="qty")
	private int quantity;
	
	@Column(name="productname")
	private String productName;
	
	@Column(name="total")
	private double total;

	public BookingModel(long bookingId, long userId, long serviceId, int quantity, String productName) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.serviceId = serviceId;
		this.quantity = quantity;
		this.productName = productName;
	}
	

	public BookingModel(long bookingId, long userId, long serviceId, int quantity, String productName, double total) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.serviceId = serviceId;
		this.quantity = quantity;
		this.productName = productName;
		this.total = total;
	}
	
	


	public BookingModel() {
		super();
	}


	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
}
