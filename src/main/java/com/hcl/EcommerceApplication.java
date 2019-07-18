package com.hcl;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.entity.Category;
import com.hcl.entity.Product;
import com.hcl.repository.IProductRepo;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
	@Autowired
	IProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	  public void run(String... args) throws Exception {
	    /*
	     * Apple company & products
	     */
	    // initial company and products 
	    Product iphone7 = new Product();
	    iphone7.setProductName("Iphone 7");
	    Product iPadPro = new Product();
	    iPadPro.setProductName("IPadPro");
	    
	    Set<Product> appleProducts = Stream.of(iphone7, iPadPro).collect(Collectors.toSet());
	    
	    Category apple = new Category();
	    apple.setCategoryName("Apple");
	    
	    iphone7.setCategory(apple);
	    iPadPro.setCategory(apple);
	    
	    // send message to ActiveMQ
	    productRepo.save(apple);
	        
	        /*
	         * Samsung company and products
	         */
	    Product galaxyS8 = new Product();
	    galaxyS8.setProductName("Galaxy S8");
	    Product gearS3 = new Product();
	    gearS3.setProductName("Gear S3");
	    
	    Set<Product> samsungProducts = Stream.of(galaxyS8, gearS3).collect(Collectors.toSet());
	    
	    Category samsung = new Category();
	    samsung.setCategoryName("Samsung");
	    galaxyS8.setCategory(samsung);
	    gearS3.setCategory(samsung);
	    
	        /*
	         * send message to ActiveMQ
	         */
	    productRepo.save(samsung);
	  }

}
