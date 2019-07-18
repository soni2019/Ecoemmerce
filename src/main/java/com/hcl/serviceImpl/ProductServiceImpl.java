package com.hcl.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.CategoryDto;
import com.hcl.entity.Category;
import com.hcl.entity.Product;
import com.hcl.entity.Registration;
import com.hcl.exception.DataNotFoundException;
import com.hcl.repository.IProduct;
import com.hcl.repository.IProductRepo;
import com.hcl.repository.IUserServiceRepo;
import com.hcl.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService  {
	@Autowired
	IUserServiceRepo userServiceRepo;
	@Autowired
	IProductRepo productRepo;
	@Autowired
	IProduct prod;

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Override
	public Product addProduct(Product category, String userStatus, Long userId)
	{
		Registration oldUser=userServiceRepo.getOne(userId);
		Product product=null;
		if(oldUser.getUserType().equals(userStatus)) {
			product = prod.save(category);
			
		}
		else {
			logger.info("Unable to add productCode : " +category.getProductCode()+ "invalid user");
			throw new DataNotFoundException("No Record Avaliable");
		}
		
		return product;
	}
	
	@Override
	public CategoryDto addCategory(Category category)
	{
			Category product = productRepo.save(category);
			CategoryDto regDto= new CategoryDto();		
			BeanUtils.copyProperties(product, regDto);
		
		return regDto;
	}

	@Override
	public CategoryDto productByCategory(Long categoryId) {
		CategoryDto regDto=null;
		if(categoryId!=null) {
		Optional<Category> product=productRepo.findById(categoryId);
		regDto= new CategoryDto();		
		BeanUtils.copyProperties(product, regDto);
		}else {
			throw new DataNotFoundException("No Record Avaliable");
		}
		return regDto;
		
	}

	@Override
	public List<Category> products() {
		List<Category> products = productRepo.findAll();
		return products;
	}

}
