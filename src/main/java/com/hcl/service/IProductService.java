package com.hcl.service;

import java.util.List;

import com.hcl.dto.CategoryDto;
import com.hcl.entity.Category;
import com.hcl.entity.Product;

public interface IProductService {
	
	public Product addProduct(Product product, String userStatus, Long userId);
	
	public CategoryDto productByCategory(Long categoryId);
	
	public List<Category> products();

	public CategoryDto addCategory(Category category);



	

}
