package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.CategoryDto;
import com.hcl.entity.Category;
import com.hcl.repository.IProductRepo;
import com.hcl.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	IProductRepo productRepo;
	@Autowired
	IProductService productService;
	
	@PostMapping("/productbycategory")
	public ResponseEntity<CategoryDto> addProduct(@RequestBody Category category,
			@RequestParam(value="userStatus") String userStatus,
			@RequestParam(value="userId") Long userId)
	{
		CategoryDto product=productService.addProduct(category, userStatus, userId);
		return new ResponseEntity<CategoryDto>(product,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/productbycategory")
	public ResponseEntity<CategoryDto> productByCategory(@RequestParam(value="categoryId") Long categoryId){
		CategoryDto product=productService.productByCategory(categoryId);
		return new ResponseEntity<CategoryDto>(product,HttpStatus.OK);
		}
	
	@GetMapping("/products")
	public ResponseEntity<List<Category>> products(){
		List<Category> product=productService.products();
		return new ResponseEntity<List<Category>>(product,HttpStatus.OK);
		}
}
