package com.hcl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productCode;
	private String productName;
	private int quantity;
	private double price;
	@ManyToOne
	private Category category;
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getProductCode() {
		return productCode;
	}
	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	/*public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}*/
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", quantity=" + quantity + ", productName=" + productName + ", price=" + price + "]";
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
}
