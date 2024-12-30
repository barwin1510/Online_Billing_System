package com.project.OnlineBillingSystem.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String productName;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date manufactureDate;
	
	private Long gst;
	private Long price;
	
	public Product() {
		super();
	}
	
	public Product(String productName, Date manufactureDate, Long gst, Long price) {
		super();
		this.productName = productName;
		this.manufactureDate = manufactureDate;
		this.gst = gst;
		gstPrice();
	}
	
	public void gstPrice() {
		this.price=gst+price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Long getGst() {
		return gst;
	}
	public void setGst(Long gst) {
		this.gst = gst;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}
