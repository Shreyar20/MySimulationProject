package com.cognizant.menu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name="laundryservice")
@EntityListeners(AuditingEntityListener.class)
public class LaundryModel{
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="serviceid")
	private int serviceId;
	
	@Column(name="productname")
	private String productName;
	@Column(name="servicetype")
	private String serviceType;
	@Column(name="price")
	private int price;
	
	
	
	public LaundryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LaundryModel(int serviceId, String productName, String serviceType, int price) {
		super();
		this.serviceId = serviceId;
		this.productName = productName;
		this.serviceType = serviceType;
		this.price = price;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(int l) {
		this.serviceId = l;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
