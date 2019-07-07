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
import com.hcl.entity.Registration;
import com.hcl.exception.DataNotFoundException;
import com.hcl.repository.ProductRepo;
import com.hcl.repository.UserServiceRepo;
import com.hcl.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService  {
	@Autowired
	UserServiceRepo userServiceRepo;
	@Autowired
	ProductRepo productRepo;

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Override
	public CategoryDto addProduct(Category category, String userStatus, Long userId)
	{
		Registration oldUser=userServiceRepo.getOne(userId);
		CategoryDto regDto=null;
		if(oldUser.getUserType().equals(userStatus)) {
			Category product = productRepo.save(category);
			regDto= new CategoryDto();		
			BeanUtils.copyProperties(product, regDto);
		}
		else {
			logger.info("Unable to find product category:" + category.getCategoryId()+ " OR invalid user");
			throw new DataNotFoundException("No Record Avaliable");
		}
		
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
