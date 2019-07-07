package com.hcl.service;

import java.util.List;

import com.hcl.dto.CategoryDto;
import com.hcl.entity.Category;

public interface ProductService {
	
	public CategoryDto addProduct(Category category, String userStatus, Long userId);
	
	public CategoryDto productByCategory(Long categoryId);
	
	public List<Category> products();



	

}
