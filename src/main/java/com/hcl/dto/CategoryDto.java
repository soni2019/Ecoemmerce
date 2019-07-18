package com.hcl.dto;

import java.util.Date;

public class CategoryDto {
	
	private String categoryName;
	private Date lastUpdate;
	
		
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	

}
